import java.util.*;
import java.io.*;



public class QuizApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter your name: ");
        String playerName = sc.nextLine();

        ArrayList<Question> easy = new ArrayList<>();
        ArrayList<Question> medium = new ArrayList<>();
        ArrayList<Question> hard = new ArrayList<>();

        // EASY QUESTIONS
        easy.add(new Question(
                "Who invented Java?",
                new String[]{"James Gosling","Dennis Ritchie","Bjarne Stroustrup","Guido van Rossum"},
                1));

        easy.add(new Question(
                "Which company developed Java?",
                new String[]{"Microsoft","Sun Microsystems","Google","Apple"},
                2));

        // MEDIUM QUESTIONS
        medium.add(new Question(
                "Which keyword is used to inherit a class?",
                new String[]{"implements","extends","inherit","super"},
                2));

        medium.add(new Question(
                "Which method is entry point of Java?",
                new String[]{"start()","run()","main()","init()"},
                3));

        // HARD QUESTIONS
        hard.add(new Question(
                "Which package contains Scanner class?",
                new String[]{"java.io","java.util","java.lang","java.sql"},
                2));

        hard.add(new Question(
                "Which keyword prevents inheritance?",
                new String[]{"static","abstract","final","const"},
                3));

        System.out.println("\nSelect Difficulty Level");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int level = sc.nextInt();

        ArrayList<Question> quiz;

        if(level == 1)
            quiz = easy;
        else if(level == 2)
            quiz = medium;
        else
            quiz = hard;

        playQuiz(quiz, playerName);
    }

    public static void playQuiz(ArrayList<Question> quiz, String playerName){

        Collections.shuffle(quiz);

        int score = 0;

        for(int i=0;i<quiz.size();i++){

            Question q = quiz.get(i);

            System.out.println("\nQuestion " + (i+1));
            System.out.println(q.question);

            for(int j=0;j<q.options.length;j++){
                System.out.println((j+1) + ". " + q.options[j]);
            }

            int userAnswer;

            while(true){

                System.out.print("Enter answer (1-4): ");
                userAnswer = sc.nextInt();

                if(userAnswer >= 1 && userAnswer <= 4)
                    break;
                else
                    System.out.println("Invalid input!");
            }

            if(userAnswer == q.answer){

                System.out.println("Correct ✅");
                score++;

            } else{

                System.out.println("Wrong ❌");
                System.out.println("Correct answer: " + q.options[q.answer-1]);
            }
        }

        showResult(score, quiz.size());

        saveScore(playerName, score);

        showLeaderboard();
    }

    public static void showResult(int score, int total){

        double percentage = (score * 100.0) / total;

        System.out.println("\nFinal Score: " + score + "/" + total);
        System.out.println("Percentage: " + percentage + "%");

        if(percentage >= 50)
            System.out.println("Result: PASS 🎉");
        else
            System.out.println("Result: FAIL");
    }

    public static void saveScore(String name, int score){

        try{

            FileWriter fw = new FileWriter("leaderboard.txt", true);
            fw.write(name + " - " + score + "\n");
            fw.close();

        } catch(IOException e){

            System.out.println("Error saving score.");
        }
    }

    public static void showLeaderboard(){

        System.out.println("\n------ LEADERBOARD ------");

        try{

            File file = new File("leaderboard.txt");
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){

                System.out.println(reader.nextLine());
            }

            reader.close();

        } catch(Exception e){

            System.out.println("Leaderboard not found.");
        }
    }
}