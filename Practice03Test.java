import java.util.Random;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative () {
		// TODO: Fill in this iterative function.
		// Set the minimum value index to 0, to start the function
		int minIndex = 0; // O(1) - Constant - Only happens once
		// Iterate through the array, comparing each value to current min value. Replace if current index value is less than minIndex value
		for (int currentIndex = 1; currentIndex < arr.length; currentIndex++) { // O(1) since we only setup once
			if (arr[currentIndex] < arr[minIndex]) { //O(n) since we perform this comparison the amount of times there are items, aka 'n'
				minIndex = currentIndex; //O(n) Worst case we have to replace min value index every time
			}
		}

		return minIndex; //O(1) - Constant - Only happens once
	}


	public int find_min_recursive () {
		// TODO: Fill in this recursive function.
		// minIndex at 0 to simply start comparisons
		int minIndex = 0; // O(1) - Constant - Only happens once
		// pleaseEnd will be the current value we're comparing as well as the comparison for base case
		int pleaseEnd = 1; // O(1) - Constant - Only happens once

		// Call the overloaded recursive function with necessary paramaters
		return find_min_recursive(minIndex, arr, pleaseEnd); // O(1) - Constant - Only happens once
	}


	public int find_min_recursive(int minIndex, double[] arr, int pleaseEnd) { //O(1) * n(after first call) = O(n)
		// Each time we recurse, pleaseEnd increments. Once it equals the array length, that means it has gone through the entire array. So return minIndex.
		if (pleaseEnd == arr.length) { // O(n) Comparison happens n times
			return minIndex; // O(1) - Constant - Once called, will never happen again
		} else {
			// If current index or pleaseEnd is less than current minIndex, replace the minIndex
			if (arr[pleaseEnd] < arr[minIndex]) { // O(n) - Worst cose scenario, happens for every item
				minIndex = pleaseEnd; // O(n) - Worst case scenario, happens every time
			}
			// Recurse until the entire array has been gone through
			return find_min_recursive(minIndex, arr, pleaseEnd+1); // O(n) - Worst case scenario, happens every time
		}
	}

	/*
		Iterative Total: O(1 + 1 + n + n) = O(2n + 2)
		Recursive Total: O(1 + 1 + 1 + n + 1 + n + n + n) = O(4 + 4n)

	*/

	/**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative());
		System.out.println("Recursively determined min at index " + find_min_recursive());
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
