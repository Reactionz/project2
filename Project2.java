import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.awt.Desktop;
import java.io.File;
import java.io.BufferedWriter;

public class Project2 {
    static Scanner scanner = new Scanner(System.in);

    static String menu[] = {
        "======================== CS 3990 Assignment 1 ===============",
        "G/g:   Ask for a N, and generate N members of mixed",
        "       Member classes objects, and store into a Vector",
        "       and an array object.",
        "",
        "S/s:   Sort the members in the vector and array in",
        "       ascending order.",
        "",
        "V/v:   Show the members in the vector and array.",
        "",
        "O/o:   Save Members inside vector into an HTML file",
        "       and members are in the format of an HTML table.",
        "",
        "F/f:   Show HTML file contents on screen.",
        "",
        "L/l:   Launch the default internet browser to",
        "       display the generated HTML file.",
        "-------------------------------------------------------------",
        "H/h/?: Display this menu.",
        "E/e:   Exit",
        "============================================================="
    };

    static int n;
    static Random rand = new Random();
    static Member arr[] = null;
    static Vector<Member> vec = null;

    static char showAndGetMenuItem() {
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("\n\t\t%s", menu[i]);
        }
        System.out.printf("\n\n\t\t%s", "Enter a command: or E for quit: ");

        return scanner.next().trim().charAt(0);
    }

    public static void main(String args[]) {
        char choice = ' ';

        while (true ) {
            choice = showAndGetMenuItem();

        switch (choice) {
            case 'H':
            case 'h':
            case '?':
                break;
            case 'G':
            case 'g':
                generateAndStore();
                break;
            case 'S':
            case 's':
                sortItemsInVecAndArr();
                break;
            case 'V':
            case 'v':
                showMembersInVecAndArr();
                break;
            case 'O':
            case 'o':
                saveMembersIntoVecAndArr();
                break;
            case 'F':
            case 'f':
                showContentsOfHTMLFile();
                break;
            case 'L':
            case 'l':
                launchBrowser();
                break;
            case 'E':
            case 'e':
                System.exit(0);
                return;
                // break;
            default:
                System.out.println("Run the program again with a different input!");
                break;
        }
        }
    }

    static Member nextMember() {
        switch(rand.nextInt(2)) {
            case 0:
                return new Member();
            case 1:
                // return new Employee();
        }
        return new Member();
    }

    static void generateAndStore() {
        System.out.printf("\n\t\t Members to be generated? ");
        n = scanner.nextInt();
        arr = new Member[n];
        vec = new Vector<Member>(n);
        for (int i = 0 ; i < n; i++) {
            arr[i] = nextMember();
            vec.add(nextMember());
        }
    }

    static void sortItemsInVecAndArr() {

    }

    static void showMembersInVecAndArr() {
        System.out.printf("\n\t\t====================   Members in Array    =================");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("\n\t\t%s", arr[i].toString(true));
        }
        System.out.printf("\n\t\t====================   Members in Vector   =================");
        for (int i = 0; i < vec.size(); i++) {
            System.out.printf("\n\t\t%s", vec.get(i).toString());
        }
    }

    static void saveMembersIntoVecAndArr() {
        //Filewriter fout = null;
        BufferedWriter bfout = null;
        Member m = new Member();
        char[] cArr = null;

        try {
            bfout = new BufferedWriter(new FileWriter("display.html"));
            bfout.write("<HTML>\n\t<TABLE>\n");

            for (int i = 0; i < vec.size(); i++) {
                //cArr = vec.get(i).htmlRow().toCharArray();
                //for (int j = 0; j < cArr.length; j++) {
                //  fout.write( cArr[j] );
                //}

                bfout.write( vec.get(i).htmlRow());
                bfout.write("\n");
            }
                //fout.printf("<\TABLE>\n<HTML>\n");

                bfout.write("\t</TABLE>\n<HTML>\n");
                bfout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void showContentsOfHTMLFile() {
        FileReader fin = null;
        int ch;
        try {
            fin = new FileReader("display.html");
            while ((ch = fin.read()) != 1) {
                System.out.printf("%c", ch);
                fin.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void launchBrowser() {
        if(Desktop.isDesktopSupported()) {
            try {
                File file = new File( "display.html" ); // fileNae example: "hw01.html".
                Desktop.getDesktop().browse( file.toURI() );
            } catch ( IOException e ) { 
                e.printStackTrace(); 
            }
        }  
    }

}