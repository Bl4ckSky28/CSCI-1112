/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program performs unit testing on the Stack class.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class StackTesting {

    /**
     * use this to test the methods in your stack implementation. DO not use this to test the browser example
     * @param args
     */
    public static void main(String[] args){

    	if(testConstructor())
    		System.out.println("testConstructor: succeeded");
    	else
    		System.out.println("testConstructor: failed");
    	if(testPush())
    		System.out.println("testPush: succeeded");
    	else
    		System.out.println("testPush: failed");
        if(testPop())
            System.out.println("testPop: succeeded");
        else
            System.out.println("testPop: failed");
        if(testPeek())
            System.out.println("testPeek: succeeded");
        else
            System.out.println("testPeek: failed");
    }
	// ------------------------------------------------------------------------
	/// Validates that stack is constructed correctly
    public static boolean testConstructor() {
    	MyStack stack = new MyStack();

    	// Validate that stack is empty
    	if(!stack.isEmpty())
    		return false;

    	// Validate that length of stack is zero
    	if(stack.length() != 0)
    		return false;

  
    	return true;
    }
    // ------------------------------------------------------------------------
	/// Validates that push method works correctly
    public static boolean testPush() {
    	MyStack stack = new MyStack();

    	// Implement push method
    	stack.push(2);

    	// Validate that stack is not empty
    	if(stack.isEmpty())
    		return false;

    	// Validate that length stack is as expected
    	if(stack.length() != 1)
    		return false;

    	return true;
    }
	// ------------------------------------------------------------------------
	/// Validates that pop method works correctly
	public static boolean testPop() {
		MyStack stack = new MyStack();

		stack.push(2);
		
		// Validate that element is in expected position
        if(stack.pop() != 2)
            return false;

        // Validate that stack is expected length
        if(stack.length() != 0)
            return false;

		return true;
	}
    // ------------------------------------------------------------------------
    /// Validates that peek method works correctly
    public static boolean testPeek() {
        MyStack stack = new MyStack();
        stack.push(2);

        // Validate that element is in first position
        if(stack.peek() != 2)
            return false;

        // Validate that stack is unchanged
        if(stack.length() != 1)
            return false;

        return true;
    }


}
