import java.util.*;

public class Student extends Member {
    // Member m = new Member();
    Member m = new Member();
    
    static Random rand = new Random();
    public static void main(final String[] args) {
        System.out.println("yeet");
        // Student student = new Student();
        // for (int i = 0; i < 20; i++) {
        // student.generate();
        // }
    }

    public Student() {
        generate();
    }

    // public Student(String major, float GPA) {

    // }

	public void generate() {
        ID = rnd.nextInt(999999999 - 100000000 ) + 100000000;
        firstName = Names.firstName[rnd.nextInt(180)];
        lastName = Names.lastName[rnd.nextInt(180)];
        GPA = rand.nextFloat() * (4.0f - 0.0f) + 0.0f;
        major = Names.department[rand.nextInt(12)];
        // System.out.println(major);
    }

    public String toString() {
        return String.format("%03d-%02d-%4d %10s %-10s %.2f %10s", ID / 1000000, ID / 10000 % 100, ID % 10000,
                firstName, lastName, GPA, major);
    }

    public String toString(boolean lab) {
        return lab ? "MEM" : "" + String.format("%03d-%02d-%4d %10s %-10s %.2f %10s ", ID / 1000000, ID / 10000 % 100, ID % 10000, firstName,
        lastName, GPA, major);
    }

    
    /*
    public String htmlRow();
    public String htmlColumns();
    */

    protected String major = null;
    float GPA = 0.0f;
}