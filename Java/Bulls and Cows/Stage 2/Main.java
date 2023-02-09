import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String code = "9305";

        System.out.println("The secret code is prepared: ****.");
        System.out.println();
        String guess = scanner.next();
        
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
        } else if (bulls <= 3 && cows == 0) {
            System.out.print("Grade: " + bulls + " bull(s). The secret code is 9305.");
        } else if (cows <= 3 &&  bulls == 0) {
            System.out.print("Grade: " + cows + " cow(s). The secret code is 9305.");
        } else if (cows > 0 && bulls > 0) {
            System.out.print("Grade: " + bulls + " bull(s) and " + cows + " cow(s). The secret code is 9305.");
        } else {
            System.out.print("Grade: none. The secret code is 9305.");
        }
        System.out.println();

    }
}
