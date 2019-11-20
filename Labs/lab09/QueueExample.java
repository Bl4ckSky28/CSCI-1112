import java.util.*;

public class QueueExample {

    public static void main (String[] argv)
    {
        // We'll use Java's LinkedList as our queue.
        ArrayList<String> taskQueue = new ArrayList<String>();

        // Add some strings.
        taskQueue.add ("Pay bills");
        taskQueue.add ("Clean room");
        taskQueue.add ("Do homework");
        taskQueue.add ("See movie");
        taskQueue.add ("Hang out");
        
        // Now extract in "queue" order using the removeFirst() method in LinkedList.
        System.out.println(taskQueue.toString());
        System.out.println (taskQueue.remove(0));
        System.out.println(taskQueue.toString());
        System.out.println (taskQueue.remove(0));
        System.out.println(taskQueue.toString());
        System.out.println (taskQueue.remove(0));
        System.out.println(taskQueue.toString());
        System.out.println (taskQueue.remove(0));
        System.out.println(taskQueue.toString());
        System.out.println (taskQueue.remove(0));

        System.out.println ("=> Tasks remaining: " + taskQueue.size());
    }

}