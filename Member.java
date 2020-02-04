import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.io.*;
// Required to use Desktop
import java.awt.*;

/*
     * public String toString( boolean ); 
     * public int compareTo(Member); 
     * public String htmlRow(); 
     * public String htmlColumns(); other necessay methods....
*/

public class Member implements Comparable<Member> {
    static Random rnd = new Random();

    public int compareTo(Member m) {
        // int mID = (Member m).
        return ID - m.ID;
    }

    public Member() {
        generate();
    }

    public void generate() {
        // ID = rnd.nextInt( 999999999 - 100000000 ) + 100000000;
        ID = rnd.nextInt(999999999 - 100000000) + 1000000;
        firstName = Names.firstName[rnd.nextInt(180)];
        lastName = Names.lastName[rnd.nextInt(180)];

    }

    public String toString() {
        // return String.format("%03d-%02d-%04d %10s %-10s", ID / 1000000, ID / 10000 % 100, ID % 10000, firstName,
        //         lastName);
        return toString(false);
    }

    public String toString(boolean lab) {
        return lab ? "MEM"
                : "" + String.format("%03d-%02d-%4d %10s %-10s", ID / 1000000, ID / 10000 % 100, ID % 10000, firstName,
                        lastName);
    }

    public String htmlRow() {
        return "\t\t<TR>   " + htmlColumns() + "    </TR>";
    }

    public String htmlColumns() {
        return String.format("<TD>%03d-%02d-%4d</TD> <TD>%10s</TD> <TD>%-10s</TD>", ID / 1000000, ID / 10000 % 100, ID % 10000, firstName,
        lastName);
    }

    public static void showHTMLFile( String fileName ) {
        if(Desktop.isDesktopSupported()) {
           try {
              File file = new File( fileName ); // fileNae example: "hw01.html".
              Desktop.getDesktop().browse( file.toURI() );
           } catch ( Exception e ) { e.printStackTrace(); }
       }
     }
  

    public static void menu() {

        // String selection;
        // Scanner input = new Scanner(System.in);

        System.out.println("===================== CS 3390 Assignment 1 =============");
        System.out.println(
                "G/g:    Ask for a N, and generate N members of mixed\n Member class's objects, and store in a Vector\n and an array Objects.");
        System.out.println("S/s:    Sort the members in the vector and array in ascending order.");
        System.out.println("V/v:    Show the members in the vector and array.");
        System.out.println(
                "O/o:    Save the objects inside the vector into a HTML file\nwith objects saved in the format of an HTML Table.");
        System.out.println("F/f:    Show HTML file contents on screen.");
        System.out.println("L/l:    Launch the default internet browser to\ndisplay the generated HTML file.");
        System.out.println("--------------------------------------------------");
        System.out.println("H/h/?: Display this menu.");
        System.out.println("E/e: Exit\n");

    }

    protected String firstName = null, lastName = null;
    int ID = 0;

    public static void main(String[] args) {
        // Member member = new Member();
        // for (int i = 0 ; i < 20; i++) {
        //     System.out.println(member.toString());
        // }
        String userChoice = "";
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter H/h/? for help, or enter a command.");

            userChoice = input.nextLine();

            switch (userChoice) {
                case "H":
                case "h":
                case "?":
                    menu();
                    break;
                case "G":
                case "g":
                    break;
                case "S":
                case "s":
                    break;
                case "V":
                case "v":
                    break;
                case "O":
                case "o":
                    break;
                case "F":
                case "f":
                    break;
                case "L":
                case "l":
                    showHTMLFile("hw02.html");
                    break;
                case "E":
                case "e":
                    return;
                    // break;
                default:
                    System.out.println("Run the program again with a different input!");
                    break;
            }
        } while (userChoice != "e" ||  userChoice != "E");
        input.close();
    }
}
