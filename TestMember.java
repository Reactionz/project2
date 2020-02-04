import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TestMember {

    public static void main( String args[] ) {

	writeMembersToFile ( "mem.txt" );
	showMembersInFile( "mem.txt");
    }

    static void showMembersInFile( String fileName ) {
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

    static void writeMembersToFile ( String fileName ) {
	FileWriter fout = null;
	//Member m = new Member ();
	//Employee em = new Employee ();
	// Staff staff = new Staff ();
	//Student student = new Student();
	Faculty faculty = new Faculty();
	//char[] cArrm = null;
	//char[] cArre = null;
	// char[] cArrs = null;
	//char[] cArrStu = null;
	char[] cArrFac = null;


	try {
	    fout = new FileWriter( fileName );
	    for ( int i = 0; i < 20; i ++ ) {
		//System.out.printf("Member generated: %s\n", m );
		//System.out.printf("Employee generated: %s\n", em);
		//cArrm = m.toString().toCharArray();
		//cArre = em.toString().toCharArray();
		//cArrs = staff.toString().toCharArray();
		//cArrStu = student.toString().toCharArray();
		cArrFac = faculty.toString().toCharArray();

		//for (int j = 0; j < cArrm.length; j++ ) fout.write( cArrm[j] ); 
		//for (int j = 0; j < cArrStu.length; j++ ) fout.write( cArrStu[j] ); 
		for (int j = 0; j < cArrFac.length; j++ ) fout.write( cArrFac[j] ); 
		fout.write('\n');
		//m.generate();
		//em.generate(); 
		// staff.generate();
		//student.generate();
		faculty.generate();
	    }
	    fout.close();
	} catch (IOException e) { e.printStackTrace(); }
    }
	
}
