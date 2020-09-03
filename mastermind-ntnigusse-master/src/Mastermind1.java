import java.util.Random;
import java.util.Scanner;
/**
 * Mastermind game with code all in main and no non-constant data members defined
 */
public class Mastermind1 {
    public static final String colors="RGYBOP";


    public static void main(String[] args) {



        // getGuess\
        // you'll need to add code to validate that user entered four
        // valid colors, but leave that at end of project

        //generateSecret
        String secret = "";
        StringBuilder Secret = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int secret_index = random.nextInt(6);
            char ch = colors.charAt(secret_index);
            secret+=ch;
        }
        Secret.append(secret);

        System.out.println(Secret);



        boolean done = false;
        while (!done) {
            //getGuess--returns a string
            System.out.println("Guesses consist of 4 letters from:" + colors);
            System.out.println("Please enter a 4 letter guess");
            System.out.println(" Guess the code: ");
            Scanner sc = new Scanner(System.in);
            String guess = sc.nextLine();


            /*for (int i = 0; i < 4; i++) {
                if (!(guess.charAt(i) == 'R') || (guess.charAt(i) == 'G') || (guess.charAt(i) == 'Y') || (guess.charAt(i) == 'B') || (guess.charAt(i) == 'O') || (guess.charAt(i) == 'P'))
                {
                  System.out.println("You entered unfamiliar letters. Game over");
                  System.exit(0);
                }}*/

            if (guess.length() != 4) {
                System.out.println("Try again");
                System.out.println("Your Guess has too many or not enough letters");
                break;
            }
            System.out.println("Your Guess:" + guess);


            //computes exacts

            int exacts = 0;
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == Secret.charAt(i)) {
                    Secret.setCharAt(i, '*');
                    exacts++;

                }
            }


            if (exacts == 4) {
                System.out.println("You win");
                System.exit(0);
            }

            //computes partials
            System.out.println(Secret);

            Secret.replace(0,4, secret);
            while(Secret.length()!=0){
                Secret.deleteCharAt(0);
            }
            Secret.append(secret);

            int partials=0;
            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i)!=secret.charAt(i)) {
                    for (int j = 0; j< guess.length(); j++) {
                        if (j!=i && guess.charAt(i)==secret.charAt(j)){
                            partials++;
                            break;


                        }

                    }}}








            System.out.print("Exacts:" + exacts + "\r\n");
            System.out.println("Partials:" + partials + "\r\n");
            System.out.println(Secret);
            Secret.replace(0, 6, secret);
            System.out.println(Secret);


            System.out.println(Secret.length());
            }



        System.exit(0);
    }}


