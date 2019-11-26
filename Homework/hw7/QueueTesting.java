/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program performs unit testing on the Queue class.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class QueueTesting {

    /**
     * use this to test the methods in your Queue implementation. DO not use this to test the browser example
     * @param args
     */
    public static void main(String[] args){

    	if(testConstructor())
    		System.out.println("testConstructor: succeeded");
    	else
    		System.out.println("testConstructor: failed");
    	if(testEnqueue()) 
    		System.out.println("testEnqueue: succeeded");
    	else
    		System.out.println("testEnqueue: failed");
    	if(testDequeue()) 
    		System.out.println("testDequeue: succeeded");
    	else
    		System.out.println("testDequeue: failed");
 
    }
    // ------------------------------------------------------------------------
	/// Validates that constructor works correctly
	public static boolean testConstructor() {
		MyQueue q = new MyQueue();

		// Validate that queue is empty
		if(!q.isEmpty()) 
			return false;

		// Validate that length of queue is zero
		if(q.length() != 0)
			return false;

		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that enqueue works correctly
	public static boolean testEnqueue() {
		MyQueue q = new MyQueue();

		// Form test operation
		MyOperation op = new MyOperation(OpType.LOAD, 3);

		// Implement enqueue method
		q.enqueue(2, op);

		// Validate that queue is not empty
		if(q.isEmpty()) 
			return false;

		// Validate that length is as expected
		if(q.length() != 1)
			return false;


		return true;
	}
	// ------------------------------------------------------------------------
	/// Validates that dequeue works correctly
	public static boolean testDequeue() {
		MyQueue q = new MyQueue();

		// Form test operation
		MyOperation op = new MyOperation(OpType.LOAD, 3);

		// Implement enqueue method
		q.enqueue(2, op);

		// Implement dequeue method
		Instruction inst = q.dequeue();

		// Validate that element is in expected position
		if(inst.getOp() != op)
			return false;

		// // Validate that queue is expected length
		if(q.length() != 0)
			return false;

		return true;


	}
}
