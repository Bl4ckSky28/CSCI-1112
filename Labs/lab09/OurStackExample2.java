import java.util.*;

public class OurStackExample2 {

    public static void main (String[] argv)
    {
		String s = "((()))";
		checkParens (s);

		s = "()(())()";
		checkParens (s);

		s = "((())";
		checkParens (s);
    }

    static void checkParens (String inputStr) {
        // Extract the letters from the String into a char array.
		char[] letters = inputStr.toCharArray();

        // Create an instance of the stack.
		OurStack2 stack = new OurStack2 ();

		boolean unbalanced = false;

		for (int i=0; i<letters.length; i++) {

	    	if (letters[i] == '(') {
				stack.push (letters[i]);
	    	}
	    	else if (letters[i] == ')') {
				// We should have a match on the stack.
				char ch = ')';
				if (! stack.isEmpty() ) {
		    		ch = stack.pop ();
				}
				if (ch != '(') {
		    		// Not balanced.
		    		unbalanced = true;
		    		break;
				}	
	    	}
		}
	
		if ( (unbalanced) || (! stack.isEmpty()) ) {
	    	System.out.println ("String " + inputStr + " has unbalanced parens");
		}
		else {
	    	System.out.println ("String " + inputStr + " has balanced parens");	
        }
    }

}