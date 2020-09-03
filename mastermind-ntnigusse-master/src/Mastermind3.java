import java.util.Random;
import java.util.Scanner;



public class Mastermind3 {
    public static final String colors = "RGYBOP";

    public StringBuilder generateSecret() {
        StringBuilder secret = new StringBuilder();
        StringBuilder HiddenSecret = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int secret_index = random.nextInt(6);
            char ch = colors.charAt(secret_index);
            secret.append(ch);
        }
        return (HiddenSecret.append(secret));
    }


    public String getGuess() {
        System.out.println("Guesses consist of 4 letters from:" + colors);
        System.out.println("Please enter a 4 letter guess");
        System.out.println(" Guess the code: ");
        Scanner sc = new Scanner(System.in);
        return (sc.nextLine());
    }

    public String processGuess(String guess) {
        String ok_letters;
        String ok_length = "";
        String ok = "";
        for (int i = 0; i < 4; i++) {
            if (!((guess.charAt(i) == 'R') || (guess.charAt(i) == 'G') || (guess.charAt(i) == 'Y') || (guess.charAt(i) == 'B') || (guess.charAt(i) == 'O') || (guess.charAt(i) == 'P'))) {
                System.out.println("You entered invalid letters. Please Enter another Guess");
                ok_letters = "bad";

            } else {
                ok_letters = "Good";
            }

            if (guess.length() < 4) {
                System.out.println("Your Guess has  not enough letters.");
                System.out.println("Please try again");

            } else if (guess.length() > 4) {
                System.out.println("Your Guess has too many letters.");
                System.out.println("Please try again");
                ok_length = "Bad";
            } else {
                ok_length = "Good";
            }
            if (ok_length.length()==ok_letters.length()){
                ok = "Good";
            } else {
                ok = "bad";
            }


        }
        return (ok);
    }


    public int computeExacts(StringBuilder Secret, String guess) {
        int exacts = 0;
        for (int i = 0; i < 4; i++){
            if (guess.charAt(i) == Secret.charAt(i)) {
                Secret.setCharAt(i, '*');
                exacts++;
            }
        }
        return (exacts);
    }


    public int computePartials(StringBuilder Secret, String guess) {


        int partials = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) != Secret.charAt(i)) {
                for (int j = 0; j < guess.length(); j++)
                    if (j != i && guess.charAt(i) == Secret.charAt(j)) {
                        partials++;
                        break;
                    }
            }
        }
        return (partials);
    }

    public void main(String[] args) {
        StringBuilder Secret = generateSecret();
        boolean done = false;
        while (!done) {
            String user_Guess=getGuess();
            for (int i = 1; i > 0; i++){

                if (processGuess(user_Guess)== "Good") {
                    break;
                }
            }


            System.out.print("Exacts:" + computeExacts(Secret, user_Guess) + "\r\n");
            System.out.println("Partials:" + computePartials(Secret, user_Guess) + "\r\n");

            if (computeExacts(Secret, user_Guess) == 4) {
                System.out.println("You win");
                done=true;
                System.exit(0);
            }


        }}}







