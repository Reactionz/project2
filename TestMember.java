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
	Member m = new Member ();
	char[] cArr = null;

	try {
	    fout = new FileWriter( fileName );
	    for ( int i = 0; i < 20; i ++ ) {
		System.out.printf("Member generated: %s\n", m );
		cArr = m.toString().toCharArray();
		for (int j = 0; j < cArr.length; j++ ) fout.write( cArr[j] ); 
		fout.write('\n');
		m.generate(); 
	    }
	    fout.close();
	} catch (IOException e) { e.printStackTrace(); }
    }
	
}
