import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String questions [] = {
            "Who invented Java",
            "Which key word is used to inherit a class",
            "which method is entry point of java"
        };

        String options [][]={
            {"1. james Gosling", "2. Dennis Ritchie", "3. Bjarne Stroustrup", "4. Guido van Rossum"},
            {"1. Implement", "2. Extends", "3. inherit", "4. super"},
            {"1. Start()", "2. run()", "3. main()", "4. init()"}
        };

        int answer[]={1,2,3};
        int score=0;

        //loop through all questions
        for(int i =0; i<questions.length;i++){
            System.out.println("nQuestion "+ (i+1));
            System.out.println(questions[i]);

              //Print options
            for(int j = 0; j<options[i].length; j++){
                System.out.println(options[i][j]);

            }

            System.out.println("Enter your answer (1-4): ");
            int userAnswer = sc.nextInt();

            // check answer
            if(userAnswer==answer[i]){
                System.out.println("Correct");
                score++;
            } else{
                System.out.println("wrong");
            }
            
        }

        System.out.println("\nYour Final Score: " + score + "/" + questions.length);
        sc.close();

      
    
    
}
}

