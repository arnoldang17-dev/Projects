import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String code = "9305";
        int count = 1;
        String guess = "";

        System.out.println("The secret code is prepared: ****.");
        System.out.println();
        
        while (guess != code) {
            System.out.println("Turn "+ count + ". Answer:");
            guess = scanner.nextLine();
            count++;
            
            int bulls = 0;
            int cows = 0;
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == guess.charAt(i)) {
                    bulls++;
                } else if (code.contains(String.valueOf(guess.charAt(i)))) {
                    cows++;
                }
            }
            if (bulls == 4) {
                System.out.println("Grade: " + bulls + " bulls");
                System.out.println("Congrats! The secret code is 9305.");
                break;
            } else if (bulls <= 3 && cows == 0) {
                System.out.println("Grade: " + bulls + " bull.");
            } else if (cows <= 3 &&  bulls == 0) {
                System.out.println("Grade: " + cows + " cow.");
            } else if (cows == 0 && bulls == 0) {
                System.out.println("Grade: none.");
            } else {
                System.out.println("Grade: " + bulls + " bull and " + cows + " cow.");
            }
            System.out.println();
        }
    }
}

