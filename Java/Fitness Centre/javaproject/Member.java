package javaproject;
import java.util.LinkedList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Member {
    
    char memberType;
    int memberID;
    String name;
    double fees;

    public Member(char pMemberType, int pMemberID, String pName, double pFees) {
        memberType = pMemberType;
        memberID = pMemberID;
        name = pName;
        fees = pFees;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberType(char pMemberType) {
        this.memberType = pMemberType;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int pMemberID) {
        this.memberID = pMemberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double pFees) {
        this.fees = pFees;
    }

    @Override
    public String toString() {
        return memberType + ", " + memberID + ", " + name + ", " + fees;
    }   
}

class SingleClubMember extends Member {
    private int club;

    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {
        super(pMemberType, pMemberID, pName, pFees);
        club = pClub;
    }

    public int getClub() {
        return club;
    }

    public void setClub(int pClub) {
        this.club = pClub;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + club;
    }  
}

class MultiClubMember extends Member {
    private int membershipPoints;

    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints) {
        super(pMemberType, pMemberID, pName, pFees);
        membershipPoints = pMembershipPoints;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int pMembershipPoints) {
        this.membershipPoints = pMembershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + membershipPoints;
    }
}

interface Calculator<T extends Number> {

    double calculateFees(T clubID);
}

class FileHandler {

    public LinkedList readFile() {
        LinkedList<Member> m = new LinkedList();
        String lineRead;
        String[] splitLine;
        Member mem;

        try (BufferedReader reader = new BufferedReader(new FileReader("members.csv"))) {
            lineRead = reader.readLine();

            while (lineRead != null) {
                splitLine = lineRead.split( ", ");
                
                if (splitLine[0].equals("S")) {
                    mem = new SingleClubMember('S', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                    
                } else {
                    mem = new MultiClubMember('M', Integer.parseInt(splitLine[1]), splitLine[2], Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
                    
                }
                m.add(mem);
    
                lineRead = reader.readLine();
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return m;
    }

    public void appendFile(String mem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.csv", true))) {
            writer.write(mem + "\n");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void overwriteFile(LinkedList<Member> m) {
        String s;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.temp", false))) {
            for (int i = 0; i < m.size(); i++) {
                s = m.get(i).toString();
                writer.write(s + "\n");

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            File f = new File("members.csv");
            File tf = new File("members.temp");

            f.delete();
            tf.renameTo(f);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    public int getIntInput() {
        
        int choice = 0;

        while (choice == 0) {
            try {
                System.out.println();
                choice = reader.nextInt();
                
                if (choice == 0) throw new InputMismatchException();
                reader.nextLine();
            } catch (InputMismatchException e) {
                reader.nextLine();
                System.out.println("ERROR: INVALID INPUT. Please try again:");
            }
                
        }
        return choice;

    }

    public void printClubOptions() {
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");

    }

    public int getChoice() {
        System.out.println("WELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println();

        System.out.println("Please select an option (or Enter -1 to quit):");
        return getIntInput();
    }

    public String addMembers(LinkedList<Member> m) {
        String mem;
        double fees;
        int memberID;
        Calculator<Integer> cal;
        Member mbr;

        System.out.print("Name: ");
        String name = reader.nextLine();

        printClubOptions();
        int club = getIntInput();
        while (club < 1 || club > 4) {
            System.out.print("\nInvalid. Try again: ");
            club = getIntInput();
        }

        if (m.size() > 0) {
            memberID = m.getLast().getMemberID() + 1;
        } else {
            memberID = 1;
        }

        if (club != 4) {
            cal = (n)-> {
                switch (n) {
                case 1: return 900;
                case 2: return 950;
                case 3: return 1000;
                default: return -1;
                }
            };

            fees = cal.calculateFees(club);
            mbr = new SingleClubMember('S', memberID, name, fees, club);
            System.out.println("\nSTATUS: Single Club Member added\n");

        } else {
            cal = (n)-> {
                switch (n) {
                case 4: return 1200;
                default: return -1;
                }
            };
            fees = cal.calculateFees(club);
            mbr = new MultiClubMember('M', memberID, name, fees, 100);
            System.out.println("\nSTATUS: Multi Club Member added\n");
                
        }
        m.add(mbr);
        mem = mbr.toString();
        return mem;
    }

    public void removeMember(LinkedList<Member> m) {
        int memberID = getIntInput();

        for (int i = 0; i < m.size(); i++) {
            if (m.get(i).getMemberID() == memberID) {
                m.remove(i);
                System.out.println("Member has been removed.");
                return;
            }
        }
        System.out.println("Member ID is not found.");
    }

    public void printMemberInfo(LinkedList<Member> m) {
        for (int i = 0; i < m.size(); i++) {
        
            String[] memberInfo = m.get(i).toString().split(", ");

            if (memberInfo[0].equals("S")) {
                System.out.println("Member Type: " + memberInfo[0]);
                System.out.println("Member ID: " + memberInfo[1]);
                System.out.println("Member Name: " + memberInfo[2]);
                System.out.println("Membership Fees: " + memberInfo[3]);
                System.out.println("Club ID: " + memberInfo[4]);

            } else {
                System.out.println("Member Type: " + memberInfo[0]);
                System.out.println("Member ID: " + memberInfo[1]);
                System.out.println("Member Name: " + memberInfo[2]);
                System.out.println("Membership Fees: " + memberInfo[3]);
                System.out.println("Membership Points: " + memberInfo[4]);

            }
        }
    }
}
