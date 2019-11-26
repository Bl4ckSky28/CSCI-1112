/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program implements the stack data structure. 

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class MyStack {

    private int topLoc;
    // Keep track of stack size
    private int size;
    private int[] theStack;

    /*constructor for your stack
     *
     */
    public MyStack(){
        topLoc = 0;
        theStack = new int[3];
    }

    /* add an element to the stack
    resize accordingly
     */
    public void push(int insert) {
        // Implement newArray with size increase 1
        int[] newArray = new int[theStack.length + 1];
        // Insert value at front of newArray
        newArray[0] = insert;
        // Populate newArray with values from the stack
        for(int i = 1; i < theStack.length; i++) 
            newArray[i] = theStack[i];
        // Reassign theStack from newArray
        theStack = newArray;
        // Size is increased by one to represent new value
        size += 1;
    }

    /* return the top of stack and remove it
     if there is nothing in the stack, return Integer.Min
     */
    public int pop(){
        if(isEmpty())
            return Integer.MIN_VALUE;

        int[] newArray = new int[theStack.length - 1];
        // Retrieve value from front of theStack
        int value = theStack[topLoc];  

        // Assign values in newArray from values in theStack
        for(int i = 1; i < theStack.length - 1; i++) 
            newArray[i] = theStack[i];
        
        theStack = newArray;

        // Size is decreaed by one to represent removed value
        size -= 1;

        return value;
    }

    /* return the top of stack without removing it
     if there is nothing in the stack, return Integer.Min
     */
    public int peek(){
        if(isEmpty())
            return Integer.MIN_VALUE;
        return theStack[topLoc];
    }

    /* return true if there is nothing in the stack, false otherwise

     */
    public boolean isEmpty(){
        return size == 0;
    }

    /* return the length of the stack based on the number of elements
    that have been added
     */
    public int length() {
        return size;
    }

    @Override
    /**
     * return the contents as a string
     */
    public String toString() {
        String str = "[";

        for(int i = 0; i < theStack.length; i++) {
            if(i > 0)
                str += ", ";
            str += theStack[i];
        }
        str += "]";

        return str;
    }
}
