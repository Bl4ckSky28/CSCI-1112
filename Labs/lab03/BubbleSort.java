
import java.util.*;

public class BubbleSort {

    public static void main (String[] argv)
    {
        int arraySize = 10;
        for (int i=0; i<10; i++) {
            int[] testData = makeRandomArray (arraySize);
        
            //System.out.println ("Before: " + Arrays.toString(testData));
        
            bubbleSort (testData);
        
            //System.out.println ("After: " + Arrays.toString(testData));
            arraySize += 10;
        }
        
    }

    static void bubbleSort (int[] A)
    {
        int comparisons = 0;
        // Each sweep, i=0...n-1, will put the i-th least element in place.
        for (int i=0; i<A.length-1; i++) {

        // Perform swaps from end-of-array down to i-th position.
            for (int j=A.length-1; j>i; j--) {
                if (A[j] < A[j-1]) {
                    // Out of order: swap needed.
                    int temp = A[j];
                    A[j] = A[j-1];
                    A[j-1] = temp;
                }
                comparisons++;
            }
            
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