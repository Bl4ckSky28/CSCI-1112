import java.util.*;

public class OurStack2 {

    ArrayList<Character> array;
    int top;

    public OurStack2 () {
	   // Can be unlimited in size now.
	   array = new ArrayList<Character>();
	   top = 0;
    }

    public void push (char ch) {
        array.add(top, ch);
    }

    public char pop () {
        return array.remove(top);
    }


    public boolean isEmpty () {
        return array.isEmpty();
    }

}