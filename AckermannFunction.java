/**
 * CSIS 225 Exam 1 Spring 2024
 * Problem B2 - Solution
 * 
 * Program accepts two variables and returns the Ackermann value
 * 
 * @author Ira Goldstein
 * @version February 18, 2024
 * 
 */
public class AckermannFunction {

    /**
     * 
     * A recursive routine to calculate Ackermann values as follows:
     * 
     * A(m,n) = n+1 if m=0
     * A(m,n) = A(m-1,1) if m>0 and n=0
     * A(m,n) = A(m-1,A(m,n-1)) if m>0 and n>0
     * 
     * @param m First value used in the Ackermann calculation
     * @param n Second value used in the Ackermann calculation
     * @return Ackerman (m, n)
     * 
     */
    public static int ackermann(int m, int n) {
        // A(m,n) = n+1 if m=0
        if (m == 0) {
            return n + 1;
        }

        // A(m,n) = A(m-1,1) if m>0 and n=0
        else if (n == 0) {
            return ackermann(m - 1, 1);
        }

        // A(m,n) = A(m-1,A(m,n-1)) if m>0 and n>0
        else { // NOTE: can *not* use else if here
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }

    /**
     * 
     * main method to call Ackermann(m,n)
     * 
     * Given how large Ackermann numbers can grwo, try/catch for StackOverflowError
     * 
     * @param args[0] First value used in the call to Ackermann
     * @param args[1] Second value used in the call to Ackermann
     * 
     */
    public static void main(String[] args) {
        // Initialize m and n
        int m = 0;
        int n = 0;

        // try/catch for StackOverflowError
        // Did not check/catch other errors
        try {
            m = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);

            int result = ackermann(m, n);
            System.out.println("A(" + m + ", " + n + ") = " + result);
        } catch (StackOverflowError e) {
            System.err.println("Stack overflow error: Cannot calculate large values!");
        }
    }
}
