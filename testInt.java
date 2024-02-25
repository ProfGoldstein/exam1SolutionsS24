import java.util.Iterator;

/**
 * Question B1 testing, Exam 1, Spring 2024, CSIS-225
 * 
 * @author Ira Goldstein
 * @version February 18, 2024
 */
class testInt {


	/**
	 * main method to test the IntArrayBigValsIterator class
	 * @param args = none
	 */
	public static void main(String args[]) {

		// Array for first five tests
		Integer a1[] = new Integer[5];
		a1[0] = 8;
		a1[1] = 3;
		a1[2] = 0;
		a1[3] = 10;
		a1[4] = 5;

		// Simple check
		Iterator<Integer> i = new IntArrayBigValsIterator(a1, 5);
		System.out.println("\n Testing a1 5\nShould return 8, 10, 5");
		while (i.hasNext()) {
			System.out.println(i.next());
		}
		
		// Check to see if the program works when multiple values are returned, excluding the last one
		Iterator<Integer> j = new IntArrayBigValsIterator(a1, 6);
		System.out.println("\n Testing a1 6\nShould return 8 & 10");
		while (j.hasNext()) {
			System.out.println(j.next());
		}

		// Check to see if the program works when the only value returned is not the last one
		Iterator<Integer> k = new IntArrayBigValsIterator(a1, 10);
		System.out.println("\n Testing a1 10\nShould return 10");
		while (k.hasNext()) {
			System.out.println(k.next());
		}
		
			// Check to see if the program works with a negative threshold
		Iterator<Integer> l = new IntArrayBigValsIterator(a1, -1);
		System.out.println("\n Testing a1 -1\nShould return 8, 3, 0, 10, 5");
		while (l.hasNext()) {
			System.out.println(l.next());
		}
		
		// Check to see if the program works when nothing is returned		
		Iterator<Integer> m = new IntArrayBigValsIterator(a1, 11);
		System.out.println("\n Testing a1 11\nShould not have anything returned");
		while (m.hasNext()) {
			System.out.println(m.next());
		}

		// Array with just one value
		Integer a2[] = new Integer[1];
		a2[0] = 8;

		// Check to see if the program works with a single value less than the threshold
		Iterator<Integer> i2 = new IntArrayBigValsIterator(a2, 9);
		System.out.println("\n Testing a2 9\nShould not have anything returned");
		while (i2.hasNext()) {
			System.out.println(i2.next());
		}

		// Array with just a single zero
		Integer a3[] = new Integer[1];
		a3[0] = 0;
		
		// Test to see if the program works if the threshold and value are both zero
		Iterator<Integer> i3 = new IntArrayBigValsIterator(a3, 0);
		System.out.println("\n Testing a3 0\nShould return zero");
		while (i3.hasNext()) {
			System.out.println(i3.next());	
		}		
	}
}
