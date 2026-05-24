import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class BrainBoostGUI {

    public static void main(String[] args) { 
    	

        JFrame frame = new JFrame("BrainBoost - Java Learning App");
        frame.setSize(1000,600);
        frame.setLayout(null);

        // Background (smooth scaled image)
        Image img = new ImageIcon(BrainBoostGUI.class.getResource("/bg.jpg")).getImage();
        Image scaled = img.getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        JLabel bg = new JLabel(new ImageIcon(scaled));
        bg.setBounds(0,0,1000,600);
        
        frame.setContentPane(bg);
        bg.setLayout(null);

        // Soft dark overlay (blur feel)
        JPanel overlay = new JPanel();
        overlay.setBounds(0,0,1000,600);
        overlay.setOpaque(false);
        overlay.setBackground(new Color(0,0,0,50)); // transparent
        bg.add(overlay);
        overlay.setLayout(null);

        
        JLabel title = new JLabel(
        	    "<html><span style='color:#00BFFF;'>BrainBoost</span> - <span style='color:white;'>Learn Smart</span></html>",
        	    JLabel.CENTER
        	);
        	title.setBounds(200,50,600,60);
        	title.setFont(new Font("Segoe UI", Font.BOLD, 28));
        
      
        overlay.add(title);

        // Buttons
        JButton learningBtn = new JButton("Daily Java Concept");
        JButton javaBtn = new JButton("Java Learning");
        JButton quizBtn = new JButton("Java Quiz");
        JButton notesBtn = new JButton("Java Quick Notes");
        JButton aiBtn = new JButton("AI Java Notes");
        JButton exitBtn = new JButton("Exit");

        overlay.add(learningBtn);
        overlay.add(javaBtn);
        overlay.add(quizBtn);
        overlay.add(notesBtn);       
        overlay.add(aiBtn);
        overlay.add(exitBtn); 
         
        // Button Style (modern )
        Font btnFont = new Font("Segoe UI", Font.BOLD, 16);

        Color mainColor = new Color(20,40,90);   // soft blue
        Color hoverColor = new Color(30,60,140); // lighter hover
        

        JButton[] buttons = {learningBtn, javaBtn, quizBtn, notesBtn, aiBtn};

        for(JButton btn : buttons){
            btn.setFont(btnFont);
            btn.setBackground(mainColor);
            btn.setForeground(Color.WHITE);
            btn.setOpaque(true);
            btn.setContentAreaFilled(true);
            
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(new Color(0,150,255), 2, true));
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

            btn.addMouseListener(new MouseAdapter(){
                public void mouseEntered(MouseEvent e){
                    btn.setBackground(hoverColor);
                    btn.setBorder(BorderFactory.createLineBorder(new Color(0,200,255), 3, true));
                }
                public void mouseExited(MouseEvent e){
                	//btn.setBorder(BorderFactory.createLineBorder(new Color(0, 180, 255), 2, true));
                    
                }
            });
        }
        aiBtn.setFont(btnFont);
        aiBtn.setBackground(new Color(0, 150, 170, 180)); 
        aiBtn.setForeground(Color.WHITE);
        aiBtn.setBorder(new javax.swing.border.LineBorder(Color.WHITE, 1, true));
        aiBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        aiBtn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                aiBtn.setBackground(new Color(100,0,150,220));
            }
            public void mouseExited(MouseEvent e){
                aiBtn.setBackground(new Color(128,0,128,180));
            }
        });

        // Exit Button (soft)
        exitBtn.setFont(btnFont);
        exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));  
        exitBtn.setBackground(new Color(180, 0, 0));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setContentAreaFilled(true);
        exitBtn.setOpaque(true);
        exitBtn.setBorder(new javax.swing.border.LineBorder(Color.WHITE, 1, true));

        exitBtn.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                exitBtn.setBackground(new Color(120, 0, 0, 220)); // darker on hover
            }
            public void mouseExited(MouseEvent e){
                exitBtn.setBackground(new Color(180, 0, 0, 180)); // normal
            }
        });

        frame.setVisible(true);

        // Center placement
        int centerX = frame.getWidth()/2 - 120;

        learningBtn.setBounds(centerX,150,240,45);
        javaBtn.setBounds(centerX,210,240,45);
        quizBtn.setBounds(centerX,270,240,45);
        notesBtn.setBounds(centerX,330,240,45);
        exitBtn.setBounds(centerX,390,240,45);
        exitBtn.setBounds(centerX,390,240,45);
        aiBtn.setBounds(centerX,450,240,45);

        // Java Learning
        javaBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String content = "📘 JAVA LEARNING\n\n"

                        + "🔹 History of Java:\n"
                        + "Java was developed by James Gosling in 1995 at Sun Microsystems.\n"
                        + "Initially it was called Oak, later renamed to Java.\n"
                        + "It was designed for portable and platform-independent applications.\n\n"

                        + "🔹 Definition:\n"
                        + "Java is a high-level, object-oriented programming language "
                        + "used to develop applications.\n\n"

                        + "✨ Key Features:\n"
                        + "1. Platform Independent (Write Once Run Anywhere)\n"
                        + "2. Object-Oriented (Uses classes & objects)\n"
                        + "3. Secure (No direct memory access)\n"
                        + "4. Robust (Exception handling support)\n"
                        + "5. Multithreading support\n\n"

                        + "💻 Example:\n"
                        + "public class Hello {\n"
                        + "    public static void main(String[] args) {\n"
                        + "        System.out.println(\"Hello Java\");\n"
                        + "    }\n"
                        + "}\n\n"

                        + "💡 Conclusion:\n"
                        + "Java is widely used in web, mobile, and enterprise applications.";

                JTextArea textArea = new JTextArea(content);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                textArea.setFont(new Font("Arial", Font.PLAIN, 14));

                JScrollPane scroll = new JScrollPane(textArea);
                scroll.setPreferredSize(new Dimension(450, 300));

                JOptionPane.showMessageDialog(frame, scroll,
                        "Java Learning", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Daily Learning
        learningBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String content = "📘 JAVA FULL SYLLABUS\n\n"

                        + "🔹 MODULE I:\n"
                        + "- Scanner class (Input/Output)\n"
                        + "- Platform independence (JVM)\n"
                        + "- Operators (Arithmetic, Logical, etc.)\n"
                        + "- Loops (for, while, do-while)\n"
                        + "- OOP Basics (Encapsulation, Inheritance)\n"
                        + "- Wrapper Classes & Strings\n"
                        + "- Arrays & Methods\n\n"

                        + "🔹 MODULE II:\n"
                        + "- Polymorphism\n"
                        + "- Method Overloading & Overriding\n"
                        + "- Abstraction & Interfaces\n"
                        + "- Packages\n"
                        + "- Collections (ArrayList, LinkedList, Vector)\n"
                        + "- Exception Handling (try, catch, finally)\n"
                        + "- File Handling\n\n"

                        + "🔹 MODULE III:\n"
                        + "- Multithreading & Processes\n"
                        + "- Synchronization\n"
                        + "- Swing & JavaFX\n"
                        + "- JDBC (Database connection)\n"
                        + "- Servlets & Web Programming\n"
                        + "- Session Management\n\n"

                        + "🔹 MODULE IV:\n"
                        + "- JSP\n"
                        + "- Spring MVC\n"
                        + "- Lambda Expressions\n"
                        + "- Collections Framework Advanced\n"
                        + "- Microservices\n"
                        + "- Spring Boot\n\n"

                        + "💡 Note:\n"
                        + "Focus on OOP, Exception Handling, File Handling, and JDBC for exams.";

                JTextArea textArea = new JTextArea(content);
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                textArea.setFont(new Font("Arial", Font.PLAIN, 14));

                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(450, 300));

                JOptionPane.showMessageDialog(frame, scrollPane,
                        "📘 Java Learning (Full Syllabus)", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        // Quiz
        quizBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                String name = JOptionPane.showInputDialog(frame, "Enter your name:");
                if(name == null || name.trim().equals("")){
                    JOptionPane.showMessageDialog(frame, "Please enter a valid name");
                    return;
                }

                ArrayList<Question> questionList = loadQuestions(); //Que from file and store in Array list
                Collections.shuffle(questionList);

                int totalQ = Math.min(25, questionList.size()); // max 25 questions

                JOptionPane.showMessageDialog(frame,
                "Welcome " + name + "!\n\n" +
                "Quiz Instructions:\n" +
                "• Total Questions: " + totalQ + "\n" +
                "• Each question = 1 mark\n" +
                "• Choose carefully!\n");

                long startTime = System.currentTimeMillis();
                int score = 0;

                for(int i = 0; i < totalQ; i++){
                    Question q = questionList.get(i);

                    int ans = JOptionPane.showOptionDialog(
                        frame,
                        "Q" + (i+1) + ": " + q.ques,
                        "Quiz",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        q.options,
                        null
                    );

                    if(ans == q.correct){
                        score++;
                    }
                }

                long endTime = System.currentTimeMillis();
                long totalTime = (endTime - startTime)/1000;

                String result = "";

                if(score >= 20)
                    result = "🔥 Excellent!";
                else if(score >= 12)
                    result = "👍 Good Job!";
                else
                    result = "📚 Keep Practicing!";

                JOptionPane.showMessageDialog(frame,
                "👤 Name: " + name +
                "\n📊 Score: " + score + "/" + totalQ +
                "\n⏱ Time Taken: " + totalTime + " sec" +
                "\n\n" + result);
            }
        });

        // Notes
        notesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JTextArea area = new JTextArea();

                area.setText(
                    "📘 JAVA QUICK NOTES \n\n"

                    + "🔹 JVM:\n"
                    + "Runs Java bytecode on any system.\n"
                    + "Makes Java platform independent.\n"
                    + "Manages memory and execution.\n\n"

                    + "🔹 Scanner:\n"
                    + "Used to take user input.\n"
                    + "Reads data from keyboard.\n"
                    + "Supports int, string, double etc.\n\n"

                    + "🔹 Operators:\n"
                    + "Used for calculations and logic.\n"
                    + "Includes arithmetic and logical ops.\n"
                    + "Example: +, -, &&, ||\n\n"

                    + "🔹 Control Statements:\n"
                    + "Used for decision making.\n"
                    + "Includes if-else and switch.\n"
                    + "Controls program flow.\n\n"

                    + "🔹 Loops:\n"
                    + "Used for repeating code.\n"
                    + "Includes for, while, do-while.\n"
                    + "Saves time and effort.\n\n"

                    + "🔹 Strings:\n"
                    + "Used to store text.\n"
                    + "Immutable in Java.\n"
                    + "Provides many built-in methods.\n\n"

                    + "🔹 Arrays:\n"
                    + "Stores multiple values.\n"
                    + "Same data type elements.\n"
                    + "Access using index.\n\n"

                    + "🔹 Methods:\n"
                    + "Reusable block of code.\n"
                    + "Improves modularity.\n"
                    + "Can return values.\n\n"

                    + "🔹 Constructors:\n"
                    + "Initialize objects.\n"
                    + "Same name as class.\n"
                    + "Called automatically.\n\n"

                    + "🔹 Encapsulation:\n"
                    + "Hides data using private.\n"
                    + "Access using getters/setters.\n"
                    + "Improves security.\n\n"

                    + "🔹 Inheritance:\n"
                    + "One class uses another.\n"
                    + "Promotes code reuse.\n"
                    + "Uses 'extends' keyword.\n\n"

                    + "🔹 Polymorphism:\n"
                    + "Same method, different behavior.\n"
                    + "Overloading & overriding.\n"
                    + "Improves flexibility.\n\n"

                    + "🔹 Abstraction:\n"
                    + "Hides implementation details.\n"
                    + "Uses abstract class/interface.\n"
                    + "Shows only important parts.\n\n"

                    + "🔹 Interface:\n"
                    + "Supports multiple inheritance.\n"
                    + "Contains abstract methods.\n"
                    + "Implemented using 'implements'.\n\n"

                    + "🔹 Collections:\n"
                    + "Dynamic data storage.\n"
                    + "Includes ArrayList, LinkedList.\n"
                    + "Flexible and powerful.\n\n"

                    + "🔹 Exception Handling:\n"
                    + "Handles runtime errors.\n"
                    + "Uses try-catch-finally.\n"
                    + "Prevents program crash.\n\n"

                    + "🔹 File Handling:\n"
                    + "Read/write files.\n"
                    + "Uses File, FileReader etc.\n"
                    + "Stores persistent data.\n\n"

                    + "🔹 Multithreading:\n"
                    + "Runs multiple tasks.\n"
                    + "Improves performance.\n"
                    + "Uses Thread class.\n\n"

                    + "🔹 JDBC:\n"
                    + "Connects Java to database.\n"
                    + "Executes SQL queries.\n"
                    + "Uses Connection class.\n\n"

                    + "🔹 Servlet:\n"
                    + "Handles web requests.\n"
                    + "Runs on server.\n"
                    + "Supports GET/POST.\n\n"

                    + "🔹 JSP:\n"
                    + "Creates dynamic web pages.\n"
                    + "Uses HTML + Java.\n"
                    + "Runs on server.\n\n"

                    + "🔹 Spring Boot:\n"
                    + "Framework for backend.\n"
                    + "Easy configuration.\n"
                    + "Used in modern apps.\n\n"
                );

                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                area.setEditable(false);

                JScrollPane scroll = new JScrollPane(area);
                scroll.setPreferredSize(new Dimension(520, 400));

                JOptionPane.showMessageDialog(frame, scroll, "Java Notes",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        
        aiBtn.addActionListener(e -> {

            String topic = JOptionPane.showInputDialog(frame, "Enter Java Topic:");

            if(topic == null || topic.trim().equals("")){
                JOptionPane.showMessageDialog(frame,"Enter valid topic");
                return;
            }

            // Loading message
            JOptionPane loading = new JOptionPane("Loading... Please wait",
                    JOptionPane.INFORMATION_MESSAGE,
                    JOptionPane.DEFAULT_OPTION,
                    null, new Object[]{}, null);

            JDialog dialog = loading.createDialog(frame, "Fetching AI Notes");
            dialog.setModal(false);
            dialog.setVisible(true);

            // 🔥 Background thread
            new Thread(() -> {

                String result = AIService.getAINotes(topic);

                dialog.dispose(); // close loading

                JTextArea area = new JTextArea(result);
                area.setLineWrap(true);
                area.setWrapStyleWord(true);
                area.setEditable(false);

                JScrollPane scroll = new JScrollPane(area);
                scroll.setPreferredSize(new Dimension(500,400));

                JOptionPane.showMessageDialog(frame, scroll, "AI Notes",
                        JOptionPane.INFORMATION_MESSAGE);

            }).start();
        });

        // Exit
        exitBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static ArrayList<Question> loadQuestions() {
	    ArrayList<Question> list = new ArrayList<>();

	    try {
	        BufferedReader br = new BufferedReader(new FileReader("questions.txt")); // to read Question from ques.txt
	        String line;

	        while((line = br.readLine()) != null){
	            String[] parts = line.split("\\|");

	            Question q = new Question(
	                parts[0], parts[1], parts[2], parts[3], parts[4],
	                Integer.parseInt(parts[5])
	            );

	            list.add(q);
	        }

	        br.close();

	    } catch(Exception e){
	        e.printStackTrace();
	    }

	    return list;
	}

}