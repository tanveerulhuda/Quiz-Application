import java.util.Scanner;

public class QuizApp {

   static String questions [] = {
            "Who invented Java",
            "Which key word is used to inherit a class",
            "which method is entry point of java"
        };

    static    String options [][]={
            {"1. james Gosling", "2. Dennis Ritchie", "3. Bjarne Stroustrup", "4. Guido van Rossum"},
            {"1. Implement", "2. Extends", "3. inherit", "4. super"},
            {"1. Start()", "2. run()", "3. main()", "4. init()"}
        };

    static int answer[]={1,2,3};
    static int score=0;
    static String correctAns = "";
public static void main(String[] args) {
    startQuiz();
    showResult();
    
}    




public static void startQuiz(){
    Scanner sc = new Scanner(System.in);
    //loop through all questions
        for(int i =0; i<questions.length;i++){
            System.out.println("nQuestion "+ (i+1));
            System.out.println(questions[i]);

              //Print options
            for(int j = 0; j<options[i].length; j++){
                System.out.println(options[i][j]);
                correctAns=options[i][j];
            }

            System.out.println("Enter your answer (1-4): ");
            int userAnswer = sc.nextInt();

            // check answer
            if(userAnswer==answer[i]){
                System.out.println("Correct");
                score++;
            } else{
                System.out.println("wrong");
                System.out.println("The correct answer is: "+ correctAns);
            }
}

sc.close();
}

public static void showResult(){
    double percentage =  (score *100) / questions.length;
        System.out.println("\nYour Final Score: " + score + "/" + questions.length);
        System.out.println("\nYour Percentage is: " + percentage+" %");

        if (percentage>=50) {
            System.out.println("Result: PASS");
        }
        else{
            System.out.println("Result: FAIL");
        }

}     
   
}
