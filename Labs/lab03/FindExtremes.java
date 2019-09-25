
import java.util.*;

public class FindExtremes {

    public static void main (String[] argv)
    {
        // Fill an array with some random values - for testing.
        int[] testData = makeRandomArray (10);
        
		// Find largest and smallest elements.
		int[] smallest = findSmallest (testData);
		int[] largest = findLargest (testData);

        // Print.
		System.out.println ("Smallest=" + smallest[0] + " at position=" + smallest[1] + ", largest=" + largest[0] + " at position=" + largest[1] + " in array " + Arrays.toString(testData));

    }


    static int[] findSmallest (int[] A)
    {
        // Initiates and array so that two values can be returned
        int[] arr = new int [2];
        // Start by assuming first is smallest.
		int smallest = A[0];

        // Check against A[1], A[2] ... etc.
		for (int i=1; i<A.length; i++) {
	    	if (A[i] < smallest) {
				smallest = A[i];
				// Assigns position of smallest array value to first position in array
				arr[1] = i;
	    	}
		}
		// Assigns smallest array value to first position in array
		arr[0] = smallest;
		// Array is returned with both values
		return arr;
    }


    static int[] findLargest (int[] A)
    {
        // Similar to findSmallest except for if-condition.
		int largest = A[0];
		int[] arr = new int [2];
		for (int i=1; i<A.length; i++) {
	    	if (A[i] > largest) {
				largest = A[i];
				arr[1] = i;
	    	}
		}
		arr[0] = largest;
		return arr;
    }


    static int[] makeRandomArray (int length)
    {
        int[] A = new int [length];

	for (int i=0; i<A.length; i++) {
	    A[i] = UniformRandom.uniform (1, 100);
	}

        return A;
    }

}