import java.util.*;

public class ShortestQueue {

    public static void main (String[] argv) {
        // Four experiments with random-Queue using 100,1000,10000 and 100,000 customers.
		randomQueue (100, 1, 0.8, 0.4);
		randomQueue (1000, 1, 0.8, 0.4);
		randomQueue (10000, 1, 0.8, 0.4);
		randomQueue (100000, 1, 0.8, 0.4);

        // Four experiments with shortest-Queue using 100,1000,10000 and 100,000 customers.
        shortestQueue (100, 1, 0.8, 0.4);
		shortestQueue (1000, 1, 0.8, 0.4);
		shortestQueue (10000, 1, 0.8, 0.4);
		shortestQueue (100000, 1, 0.8, 0.4);
    }



    static void randomQueue (int numTimeSteps, double arrivalRate, double server1Rate, double server2Rate) {
        // Create two queues.
		LinkedList<Integer> queue1 = new LinkedList<Integer>();
		LinkedList<Integer> queue2 = new LinkedList<Integer>();

        // Statistics that we'll track.
		double sumOfWaitTimes = 0;
		int numCustServed = 0;

        // Repeat for numTimeSteps steps.

		for (int n=0; n<numTimeSteps; n++) {

	    	// See if arrival occurs and if so, which queue it should join.
	    	if (UniformRandom.uniform() < arrivalRate) {
			// Now choose a queue randomly (flip a coin).
				if (UniformRandom.uniform() > 0.5) {
                	// We'll store the time-stamp for each customer.
		    		queue1.add (n); 
				} else {
		    		queue2.add (n);
				}
	    	}

	    	// See if anyone completes in queue 1.
	    	if ( (! queue1.isEmpty()) && (UniformRandom.uniform() < server1Rate) ) {
				int arrivalTime = queue1.remove();
				sumOfWaitTimes += (n - arrivalTime);
				numCustServed ++;
	    	}	    

	   		// See if anyone completes in queue 2.
	    	if ( (! queue2.isEmpty()) && (UniformRandom.uniform() < server2Rate) ) {
				int arrivalTime = queue2.remove();
				sumOfWaitTimes += (n - arrivalTime);
				numCustServed ++;
	    	}	    

		} //end-for

		double avgWaitTime = sumOfWaitTimes / numCustServed;
		System.out.println ("Random queue stats:#time steps=" + numTimeSteps);
		System.out.println ("  Average wait time: " + avgWaitTime);
		System.out.println ("  Num left in system: " + (queue1.size() + queue2.size()) );
    }



    static void shortestQueue (int numTimeSteps, double arrivalRate, double server1Rate, double server2Rate) {
        // Create the two queues.
		LinkedList<Integer> queue1 = new LinkedList<Integer>();
		LinkedList<Integer> queue2 = new LinkedList<Integer>();

        // Stats.
		double sumOfWaitTimes = 0;
		int numCustServed = 0;

        // Repeat for given number of time steps.
		for (int n=0; n<numTimeSteps; n++) {

	    	// See if arrival occurs.
	    	if (UniformRandom.uniform() < arrivalRate) {
				// Now choose shortest queue.
				if (queue1.size() > queue2.size()) {
		   			queue2.add (n);
				} else {
		    		queue1.add (n);
				}
	    	}

	    	// See if anyone completes in queue 1.
	    	if ( (! queue1.isEmpty()) && (UniformRandom.uniform() < server1Rate) ) {
				int arrivalTime = queue1.remove();
				sumOfWaitTimes += (n - arrivalTime);
				numCustServed ++;
	    	}	    

	    	// See if anyone completes in queue 2.
	    	if ( (! queue2.isEmpty()) && (UniformRandom.uniform() < server2Rate) ) {
				int arrivalTime = queue2.remove();
				sumOfWaitTimes += (n - arrivalTime);
				numCustServed ++;
	    	}	    
		} //end-for

		double avgWaitTime = sumOfWaitTimes / numCustServed;
		System.out.println ("Shortest queue stats:#time steps=" + numTimeSteps);
		System.out.println ("  Average wait time: " + avgWaitTime);
		System.out.println ("  Num left in system: " + (queue1.size() + queue2.size()) );
    }

}