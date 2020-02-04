import java.lang.reflect.Member;
import java.util.*;

public class Employee implements Comparable<Member>{
    Random rnd = new Random();

    public Employee() {
        generate();
    }

    public void generate() {
        
    }

    public int compareTo(Member m) {
        return 0;
    }

    public String toString() {
        return "yeet";
    }

    public String toString(boolean lab) {
        return "yeet2";
    }

    protected String major = null;
    float GPA = 0;
}