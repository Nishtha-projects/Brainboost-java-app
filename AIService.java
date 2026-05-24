import java.io.*;   // data read and write
import java.net.HttpURLConnection;  // connect to the server
import java.net.URL;  // to address

public class AIService {

    public static String getAINotes(String topic) {

        try {
            URL url = new URL("http://localhost:11434/api/generate");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST"); // to send the data
            conn.setRequestProperty("Content-Type", "application/json"); //(javaScript Object Notation) to store or send the data in structured form
            conn.setDoOutput(true); // me to send the data 
            
            String prompt = "Explain " + topic + " in Java for exams.\n"
                    + "Strict format:\n"
                    + "1. Definition (2-3 lines only)\n"
                    + "2. Key Points (exactly 5 points)\n"
                    + "3. Example (short)\n"
                    + "4. Complete Java Code (must be full and correct)\n"
                    + "5. Conclusion (2 lines)\n"
                    + "Do NOT add extra text. Keep it clean and exam-ready.";
            
            
            // if this will not there JSON will break so to protect the JSON error and not to fail the API
            String safePrompt = prompt
                    .replace("\\", "\\\\")
                    .replace("\"", "\\\"")
                    .replace("\n", "\\n");  

            // Faster response (limit tokens)
            String jsonInput = "{"
                    + "\"model\": \"tinyllama\","
                    + "\"prompt\": \"" + safePrompt + "\","
                    + "\"stream\": false,"
                    + "\"num_predict\": 2000"
                    + "}";
            
            
            // to send the data
            OutputStream os = conn.getOutputStream();
            os.write(jsonInput.getBytes());
            os.flush();
            os.close();
            
            // to collect the data
            InputStream is;
            if (conn.getResponseCode() >= 400) {
                is = conn.getErrorStream();
            } else {
                is = conn.getInputStream();
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(is));// to read AI responses

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            String result = response.toString();

            // Extract only AI text
            int index = result.indexOf("\"response\":\"");

            if (index == -1) {
                return "No response from AI\n\n" + result;
            }

            String clean = result.substring(index + 12);

            int end = clean.lastIndexOf("\",\"done\"");
            if (end != -1) {
            	clean = clean.substring(0, end);
            }

            return clean.replace("\\n", "\n")
            		.replace("\\\"", "\"");
            		

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}