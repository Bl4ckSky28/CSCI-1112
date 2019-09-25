import java.util.*;

public class LargestAtBack {

    public static void main (String[] argv)
    {
        // Some test data (a subset of Java's reserved words).
		String[] reservedWords = {"if", "else", "while", "do", "return", 
				  "true", "false", "instanceof", "class"};
        
        System.out.println ( "Before: " + Arrays.toString(reservedWords) );
        System.out.println("After: " + Arrays.toString(largestAtBack(reservedWords)));

    }

	public static String[] largestAtBack (String[] reservedWords) {
		// Assumes that first element is the largest
		String largest = reservedWords[0];
		int pos = 0;

		for (int i=1; i<reservedWords.length; i++) {
			// Compares strings lexicographically
			if(reservedWords[i].compareTo(largest) >= 1) {
				// Strings are assigned lexicographically
				largest = reservedWords[i];
				pos = i;
			}
		}
		
		// Swap
		String temp = reservedWords[reservedWords.length-1];
		reservedWords[reservedWords.length-1] = largest;
		reservedWords[pos] = temp;
   
        return reservedWords;
    }
    
}