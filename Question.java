public class Question {
    String ques;
    String[] options;
    int correct;

    public Question(String q, String o1, String o2, String o3, String o4, int c){
        ques = q;
        options = new String[]{o1,o2,o3,o4};
        correct = c;
    }
}
