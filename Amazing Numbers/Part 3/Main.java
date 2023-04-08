import java.util.Scanner;

public class Main {

    private boolean isEvenOrOdd(long n) {
                if (n % 2 == 0) {
                    return true;
                    
                } else {
                    return false;
                } 
    }

    private boolean isBuzzNumber(long n) {
        String nVal = String.valueOf(n);
        long lastValueOfN = Integer.parseInt(nVal.substring(nVal.length() - 1));

        if (lastValueOfN == 7 && n % 7 != 0 || n % 7 == 0) {
            return true;

        } else {
            return false;

        }
    }

    private boolean isDuckNumber(long n) {
        String nVal = String.valueOf(n);
        
        if (nVal.charAt(0) == 0 && nVal.substring(1).contains("0") || nVal.substring(1).contains("0")) {
                    
            return true;
        } else {
            return false;
        }

    }

    private boolean isPalindrome(long n) {
        String number = String.valueOf(n);
        StringBuilder flippedNumber = new StringBuilder();
        for (int i =  number.length() - 1; i >= 0; i--) {
            flippedNumber.append(number.charAt(i));

        }

        if (flippedNumber.toString().equals(number)) {
            return true;
        } else {
            return false;
        }
    }
    private void  printMessage(Scanner scan) {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        
        while (true) {

            try {
                System.out.println("Enter a request: ");
                long n = scan.nextLong();
                if (n == 0){
                    System.out.println("Goodbye!");
                    break;
                } 
                if (n < 0) throw new Exception();
                
                System.out.println();
                System.out.println(String.format("Properties of %,d", n));
                System.out.printf("\teven: %b\n", isEvenOrOdd(n));
                System.out.printf("\t odd: %b\n", !isEvenOrOdd(n));
                System.out.printf("\tbuzz: %b\n", isBuzzNumber(n));
                System.out.printf("\tduck: %b\n", isDuckNumber(n));
                System.out.printf(" palindromic: %b\n", isPalindrome(n));

                
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("The first parameter should be a natural number or zero.\n");
                
            }
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        Main number = new Main();
        
        number.printMessage(scan);
        
    }
}