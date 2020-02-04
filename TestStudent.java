import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TestStudent {

    public static void main( String args[] ) {

	writeStudentsToFile ( "mem.txt" );
	showStudentsInFile( "mem.txt");
    }

    static void showStudentsInFile( String fileName ) {
	FileReader fin = null;
	int ch ;
	try {
	    fin = new FileReader( fileName  );
	    while ( ( ch = fin.read() ) != -1 )
		System.out.printf("%c", ch);
	    fin.close();
	} catch (IOException e ) {
	    e.printStackTrace();
	}
    }

    static void writeStudentsToFile ( String fileName ) {
	FileWriter fout = null;
	Student stu;
	Member m;
	m = new Member();
    stu = new Student();
	char[] cArrM = null;
	char[] cArrS = null;

	try {

	    fout = new FileWriter( fileName );
	    for ( int i = 0; i < 20; i ++ ) {
		System.out.printf("Student generated: %s\n", stu );
		cArrM = m.toString().toCharArray();
		cArrS = stu.toString().toCharArray();
		for (int j = 0; j < cArrS.length; j++ ) fout.write( cArrS[j] ); 
		fout.write('\n');
		stu.generate(); 
	    }
	    fout.close();
	} catch (IOException e) { e.printStackTrace(); }
    }
	
}
