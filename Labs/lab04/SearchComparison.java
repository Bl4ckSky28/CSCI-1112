import java.util.*;

public class SearchComparison {
    static int binaryComparisons = 0;
    public static void main (String[] argv)
    {
        // Fill an array with some random values - for testing.
        int size = 10000;
        int[] testData = makeRandomSortedArray (size);
        
        // Generate a random search term.
        int value = UniformRandom.uniform (1, size);
 
        // Simple search.
        boolean found = simpleSearch (testData, value);
        System.out.println ("found = " + found);

        // Binary.
        found = binarySearch (testData, value, 0, testData.length-1);
        System.out.println ("found = " + found);

        System.out.println(binaryComparisons);
    }
    

    static boolean simpleSearch (int[] A, int value)
    {
        int comparisons = 0;
        for (int i=0; i<A.length; i++) {
            comparisons++;
            if (A[i] == value) {
                return true;
            }
        }
        System.out.println(comparisons);
        return false;
    }


    static boolean binarySearch (int[] A, int value, int start, int end)
    {
        // Only need to check if the interval got inverted.
        if (start > end) {
            return false;
        }
        binaryComparisons++;
        // Find the middle:
        int mid = (start + end) / 2;

        if (A[mid] == value) {
            return true;
        }
        else if (value < A[mid]) {
            // Search the left half: A[start],...,A[mid-1]
            return binarySearch (A, value, start, mid-1);
        }
        else {
            // Search the right half: A[mid+1],...,A[endreturn binarySearch (A, value, mid+1, end);]
            return binarySearch (A, value, mid+1, end);
        }
    }



    static int[] makeRandomSortedArray (int length)
    {
        int[] A = new int [length];

	for (int i=0; i<A.length; i++) {
	    A[i] = UniformRandom.uniform (1, 2*length);
	}

        Arrays.sort (A);

        return A;
    }
}