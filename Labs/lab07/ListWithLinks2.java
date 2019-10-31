class ListItem {

    String data;
    ListItem next;

}


public class ListWithLinks2 {

    // Instance variables.
    ListItem front = null;
    ListItem rear = null;

    // To keep track of the size.
    int numItems = 0;


    public void add (String s) {
		if (front == null) {
            // The special case of an empty list needs to be handled differently.
	    	front = new ListItem ();
	    	front.data = s;
	    	rear = front;
	    	rear.next = null;
		} else {
            // Just like before:
            ListItem nextOne = new ListItem ();
	    	nextOne.data = s;
	    	rear.next = nextOne;
	    	rear = nextOne;
		}    

		numItems ++;
    }


    public int size () {
		return numItems;
    }

    
    public String get (int i) {
		if (i >= numItems) {
	    	return null;
		}

        // Otherwise, count up to the i-th item.
		int count = 0;
		ListItem listPtr = front;

		while (count < i) {
	    	listPtr = listPtr.next;
	    	count ++;
		}
		return listPtr.data;
    }


    public boolean contains (String s) {
		if (front == null) {
	    	return false;
		}

        // Start from the front and walk down the list. If it's there,
        // we'll be able to return true from inside the loop.
		ListItem listPtr = front;
		while (listPtr != null) {
	    	if ( listPtr.data.equals(s) ) {
				return true;
	    	}
	    	listPtr = listPtr.next;
		}
		return false;
    }


    public void printList () {
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
