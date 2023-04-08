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
        if (String.valueOf(n).length() <= 2) {
            return false;
        } else {
            String na = String.valueOf(n);
            String firstNum = String.valueOf(na.charAt(0));
            String secondNum = String.valueOf(na.charAt(String.valueOf(n).length() - 1));
            StringBuilder gap = new StringBuilder().append(firstNum + secondNum);

            if (n % Integer.parseInt(gap.toString()) == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    private void printMenu() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests: ");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
        
    }
    private void  showMessage(Scanner scan) {
        
        while (true) {

            try {
                System.out.println();
                System.out.println("Enter a request: ");
                String n = scan.nextLine();

                if (n.equals(" ")) {
                    printMenu();
                    continue;
                }
                ArrayList<String> twoNum = new ArrayList<>(Arrays.asList(n.split(" ")));
                if (twoNum.get(0).equals("0")){
                    System.out.println("Goodbye!");
                    break;

                }

                if (Long.parseLong(twoNum.get(0)) < 0) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    throw new Exception();
                }
                 
                if (twoNum.size() == 2) {
                    if (Long.parseLong(twoNum.get(1)) < 0) {
                        System.out.println("second parameter should be a natural number");
                        throw new Exception();
                    }
                    long firstNum = Long.parseLong(twoNum.get(0));
                    long secondNum = Long.parseLong(twoNum.get(1));
                    System.out.println(n);
                    
                    if (firstNum > secondNum) {
                        secondNum += firstNum - 1;
                    }
                    for (long i = firstNum; i <= secondNum; i++) {
                        StringBuilder message = new StringBuilder();

                        message.append(i + " is ");
                        
                        if (isBuzzNumber(i)) {
                            message.append("buzz, ");
                        }
                        
                        if (isPalindrome(i)) {
                            message.append("palindromic, ");
                        }
                        
                        if (isGapful(i) == true) {
                            message.append("gapful, ");
                        }

                        if (isDuckNumber(i) == true) {
                            message.append("duck, ");
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
                    ,
                    System.out.println(String.format("Properties of %,d", nVal));
                    System.out.printf("\teven: %s\n", isEvenOrOdd(nVal));
                    System.out.printf("\t odd: %s\n", !isEvenOrOdd(nVal));
                    System.out.printf("\tbuzz: %s\n", isBuzzNumber(nVal));
                    System.out.printf("\tduck: %s\n", isDuckNumber(nVal));
                    System.out.printf(" palindromic: %s\n", isPalindrome(nVal));
                    System.out.printf("\tgapful: %s\n", isGapful(nVal));

                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
                continue;
                
            }
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(System.in);
        Main number = new Main();
        
        number.printMenu();
        number.showMessage(scan);
        
    }
}

