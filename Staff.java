import java.util.Random;

public class Staff extends Employee {
    static Random rnd = new Random();
    public Staff () {
        generate();
    }
    @Override
    public void generate() {
        super.generate();
        title = Names.title[rnd.nextInt(Names.title.length)];
    }
    @Override
    public String toString() {
        return toString(false);
    }
    
    @Override
    public String toString(boolean lab) {
        return (lab ? "" : "") + super.toString(false) + String.format(" %10s", title);
    }

    @Override
    public String htmlRow() {
        return "\t\t<TR>    " + htmlColumns() + "   </TR>";
    }

    @Override
    public String htmlColumns() {
        return super.htmlColumns() + String.format("<TD>%10s</TD>", title);
    }

    protected String title = null;
}
