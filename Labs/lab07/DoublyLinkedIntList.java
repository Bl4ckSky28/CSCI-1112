class ListItem {

	int data;
	ListItem next;
	ListItem prev;
    
}


public class DoublyLinkedIntList {

    // INSERT YOUR CODE HERE. 

    // Start by copying over the appropriate methods from DoublyLinkedList.java.
    // Then, change the method signatures.
    // After that, make the remaining changes.

    ListItem front = null;
    ListItem rear = null;

    int numItems = 0;

    public void add (int num) {
    	if(front == null) {
    		front = new ListItem();
    		front.data = num;
    		rear = front;
    		rear.next = null;
    		rear.prev = null;
    	} else {
    		ListItem nextOne = new ListItem();
    		nextOne.data = num;
    		nextOne.next = null;
    		nextOne.prev = rear;

    		rear.next = nextOne;
    		rear = nextOne;
    	}
    	numItems++;
    }

    public int size() {
    	return numItems;
    }

    public int get(int i) {
    	ListItem current = front;
    	int index = 0;
    	while(current != null) {
    		if(i == index)
    			return current.data;
    		index++;
    		current = current.next;
    	}
    	return -1;
    }

    public boolean contains(int i) {
    	ListItem current = front;
    	while(current != null) {
    		if(current.data == i)
    			return true;
    		current = current.next;
    	}
    	return false;
    }

    public void printList() {
    	String s = "";
        int index = 0;
        ListItem current = front;
        while(current != null) {
        	if(index > 0)
        		s += ", ";
        	s += current.data;
        	index++;
        	current = current.next;
        }
        System.out.println(s);
    }

}
