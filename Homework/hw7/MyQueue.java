/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program implements the queue data structure.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class MyQueue {

    //Nodes that will be used as the basis for your linked-list implementation of a Queue
    private class Node {
        Instruction inst;
        Node next;
    }

    private Node front;
    private Node back;
    private int size;

    /* Constructs a new list.
     */
    public MyQueue(){
        front = null;
        back = null;
    }

    /* add a new element to your Queue, adjust the nodes accordingly
     */
    public void enqueue(int duration, MyOperation operation) {
        // Creates instruction to be added to queue
        Instruction element = new Instruction(duration, operation);

        // Elements exist in queue
        if(back != null) {
            back.next = new Node();
            back.next.inst = element;
            back = back.next;
        // Elements do not exist in queue
        } else {
            front = new Node();
            front.inst = element;
            back = front;
        }
        // Size increased by one to represent added value
        size += 1;
    }

    /* return and remove the appropriate element from the queue
    if empty, return null
     */
    public Instruction dequeue(){
        // Elements exist in queue
        if(front != null) {
            Node current = front;
            front = front.next;
            size -= 1;
            return current.inst;
        }
        // Queue is empty
        return null;
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
        String str = "";
        Node current = front;
        while(current != null) {
            str += current.inst + " ";
            current = current.next;
        }
        return str;
    }
}
