import java.util.ArrayList;
import java.util.Arrays;
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

    private boolean isGapful(long n) {
        
    }
    private void  printMessage(Scanner scan) {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.");
        
        while (true) {

            try {
                System.out.println("Enter a request: ");
                String n = scan.nextLine();
                ArrayList<String> twoNum = new ArrayList<>(Arrays.asList(n.split(" ")));
                System.out.println(twoNum.toString());
                if (twoNum.get(0).equals("0")){
                    System.out.println("Goodbye!");
                    break;
                } 

                System.out.println(Integer.parseInt(twoNum.get(0)) < 0);
                if (Integer.parseInt(twoNum.get(0)) < 0) throw new Exception();

                if (twoNum.size() == 2) {
                                        
                    for (int i = Integer.parseInt(twoNum.get(0)); i <= Integer.parseInt(twoNum.get(1)); i++) {
                        StringBuilder message = new StringBuilder();

                        message.append(i + " is ");
                        
                        if (isBuzzNumber(i)) {
                            message.append("buzz, ");
                        }
                        
                        if (isPalindrome(i)) {
                            message.append("palindromic, ");
                        }
                        
                        if (isEvenOrOdd(i) == true) {
                            message.append("even");
                        } else {
                            message.append("odd");
                        }

                        System.out.println(message.toString());
                    }    

                } else {
                    long nVal = Long.parseLong(n);
                    System.out.println();
                    System.out.println(String.format("Properties of %,d", nVal));
                    System.out.printf("\teven: %s\n", isEvenOrOdd(nVal));
                    System.out.printf("\t odd: %s\n", !isEvenOrOdd(nVal));
                    System.out.printf("\tbuzz: %s\n", isBuzzNumber(nVal));
                    System.out.printf("\tduck: %s\n", isDuckNumber(nVal));
                    System.out.printf(" palindromic: %s\n", isPalindrome(nVal));

                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
                System.out.println("The first parameter should be a natural number or zero.\n");
                scan.next();
                
            }
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        Main number = new Main();
        
        number.printMessage(scan);
        
    }
}

