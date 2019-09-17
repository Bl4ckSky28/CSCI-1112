import java.util.*;
public class RandomArray2 {
	public static void main(String[] argv) {
		double p = estimateSortedProb (5, 100000);
		System.out.println ("Probability an array of length 5 is sorted: " + p);
	}

	static double estimateSortedProb (int arraySize, int numTrials) {
		// Count the number of sorted arrays generated.
		int numSorted = 0;

		// Repeat for given number of experiments.
		for (int n=0; n < numTrials; n++) {

			// Generate a random array.
			int[] randomInts = new int [arraySize];
			for (int i=0; i < randomInts.length; i++) {
				randomInts[i] = UniformRandom.uniform (1,100);
			}

			// See if sorted ascending
			boolean isSortedAscending = true;
			for (int i=1; i < randomInts.length; i++) {
				if (randomInts[i] < randomInts[i-1]) {
					isSortedAscending = false;
				}
			}
			if (isSortedAscending) {
				numSorted ++;
			}

			//See if sorted descending
			boolean isSortedDescending = true;
			for (int i=1; i < randomInts.length; i++) {
				// Modified if statement that checks for descending order.
				if (randomInts[i] > randomInts[i-1]) {
					isSortedDescending = false;
				}
			}
			// Adjusts numSorted accordingly
			if (isSortedDescending) {
				numSorted ++;
			}
		} //end-for-numTrials
		
		// The fraction of trials that resulted in a sorted array:
		double prob = (double) numSorted / (double) numTrials;
		return prob;
	} 
}