public class Test {

    // Allow function main to have access to "cnt"
    //static int cnt = 100;
    int cnt = 100;

    public static void main ( String args[] ) {
        Test tst = new Test ();
        // This way is incorrect
        // int cnt = 100;
       if(args.length < 1) return;

       for(int i = 0; i < args.length; i++)
           System.out.printf("%d : %s\n", i, args[i]);

        System.out.printf("tst.cnt = %d\n", tst.cnt);
    }
}