
import java.util.*;

public class SelectionSort {

    public static void main (String[] argv)
    {
    	int arraySize = 10;
        for (int i=0; i<10; i++) {
        	
        	int[] testData = makeRandomArray (arraySize);
        
        	//System.out.println ("Before: " + Arrays.toString(testData));
        
			selectionSort (testData);

        	//System.out.println ("After: " + Arrays.toString(testData));

        	arraySize += 10;
    	}

    }

    static void selectionSort (int[] A)
    {
        int comparisons = 0;
        // i starts at back of array and works backwards
		for (int i=A.length-1; i>-1; i--) {

	    	// Find i-th largest and swap.
	    	int largest = A[i];
	    	int pos = i;

            // Look from i-1 and down.
	    	for (int j=i-1; j>-1; j--) {
				if (A[j] > largest) {
		    		largest = A[j];
		    		pos = j;
		    		
				}
				comparisons++;
	    	}

	    	// Swap into position i.
	    	int temp = A[i];
	    	A[i] = A[pos];
	    	A[pos] = temp;
	    	
		}
		System.out.println("Comparisons: " + comparisons);

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