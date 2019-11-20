import java.util.*;

public class StackExample3 {

    public static void main (String[] argv) {
		String s = "!skrow tI";
		printReverse (s);
    }

    static void printReverse (String str) {
    	// Create new stack
		Stack<Character> stack = new Stack<Character>();
		// Add characters in string to char array
		char[] ch = str.toCharArray();

		// Populate stack with characters in char array
		for(int i=0; i<str.length(); i++) {
			stack.push(ch[i]);
		}

		// Index
		int j=0;

		while(!stack.isEmpty()) {
			// Add characters back to char array from stack in correct order
			ch[j++] = stack.pop();
		}

		// Print char array as a string
		System.out.println(str.copyValueOf(ch));
	}
}