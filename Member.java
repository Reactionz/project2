import java.util.Random;

public class Member implements Comparable<Member> {
    static Random rnd = new Random();
    public int compareTo(Member m) {
        return ID - m.ID;
    }
    public Member () {
        generate();
    }
    public void generate() {
        ID = rnd.nextInt(999999999 - 100000000 ) + 100000000;
        firstName = Names.firstName[rnd.nextInt(180)];
        lastName = Names.lastName[rnd.nextInt(180)];
    }
    public String toString() {
        //return String.format("%03d-%02d-%04d %10s %-10s", ID/1000000,
        //ID/10000 % 100, ID % 10000, firstName, lastName);
        return toString(false);
    }
    
    public String toString(boolean lab) {
        return (lab ? "MEM" : "") + String.format("%03d-%02d-%04d %10s %-10s", ID/1000000,
        ID/10000 % 100, ID % 10000, firstName, lastName);
    }

    public String htmlRow() {
        return "\t\t<TR>    " + htmlColumns() + "   </TR>";
    }

    public String htmlColumns() {
        return String.format("<TD>%03d-%02d-%4d</TD> <TD>%10s</TD> <TD>%-10s</TD>", ID / 1000000, ID / 10000 % 100, ID % 10000, firstName,
        lastName);
    }

    protected String firstName = null, lastName = null;
    int ID = 0;
}