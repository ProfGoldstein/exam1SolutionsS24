import java.util.Iterator;

/**
 * CSIS 225 Exam 1 Spring 2024
 * Problem B1 - Solution
 * 
 * Program iterates over an array of Integers, returning just those values
 * greater than or equal to a threshold
 * 
 * @author Ira Goldstein (Solutions)
 * @author Jim Teresco (starter framework)
 * @version February 18, 2024
 * 
 */
public class IntArrayBigValsIterator implements Iterator<Integer> {
	// Instance variables
	Integer[] a; // Array of Integers that we will be iterating over
	int bigVal; // Threshold value
	int current; // Current position in the array

	/**
	 * Construct a new iterator over the given array of Integers
	 * Initialized current to zero (head)
	 * 
	 * @param a      the array of Integers of which this iterator will operate
	 * @param bigVal the threshold value used while iterating over the array
	 */
	public IntArrayBigValsIterator(Integer a[], int bigVal) {
		this.a = a;
		this.bigVal = bigVal;
		current = 0;
	}

	/**
	 * Check to see if the iterator has more Integers to return
	 * 
	 * @return boolean - wheterh the iteratore has more Integers to return
	 */
	public boolean hasNext() {
		for (int i = current; i < a.length; i++) {
			// Skip to the next value greater than or equal to the threshold
			if (a[i] >= bigVal) {
				current = i;
				return true;
			}
		}
		current = a.length;
		return false;
	}

	/**
	 * Returns the next Integer in the array that is greater than or equal to the
	 * threshold
	 * 
	 * Throws an exception if the .next() goes beyond the end of the list
	 * 
	 * @return the next Integer in the array that is greater than or equal to the
	 *         threshold
	 */
	public Integer next() {
		for (int i = current; i < a.length; i++) {
			// Only returns value greater than or equal to the threshold
			if (a[i] >= bigVal) {
				current = i + 1;
				return a[i];
			}
		}

		// If the method is used correctly, should never get here
		throw new RuntimeException(
				"Attempted To .next() Beyond End 	Of Array\n\tShould have checked for .hasNext()");
	}
}
