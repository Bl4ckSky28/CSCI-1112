import java.util.*;

public class TowerOfHanoi2 {

    // stacks[0], stacks[1] and stacks[2] are the three stacks.
    static Stack<Integer>[] towers;
    static int moves;

    public static void main (String[] argv) {
        // A 3-disk puzzle:
        System.out.println ("3-Disk solution: ");
        moves = 0;
        solveHanoi (2, 0, 1);
        System.out.println("Total number of moves: " + moves);
        // A 4-disk puzzle:
        System.out.println ("4-Disk solution: ");
        moves = 0;
        solveHanoi (3, 0, 1);
        System.out.println("Total number of moves: " + moves);
    }


    static void solveHanoi (int n, int i, int j) {
        // Create the three stacks. 
        towers = new Stack [3];
        for (int k=0; k<3; k++) {
	       towers[k] = new Stack<Integer>();
        }

        // Put disks 0,...,n on stack 0.
        for (int k=n; k>=0; k--) {
	       towers[0].add (k);
        }

        // Print the initial stack.
        //printTowers ();

        // Now solve recursively. Note: this is the method below.
        solveHanoiRecursive (n, i, j);
    }
    

    static void solveHanoiRecursive (int n, int i, int j) {
        // Bottom-out.
        if (n == 0) {
	        move (0, i, j);
            return;
        }
        int k = other (i, j);
        solveHanoiRecursive (n-1, i, k);   // Step 1.
        move (n, i, j);                    // Step 2.
        solveHanoiRecursive (n-1, k, j);   // Step 3.
    }


    static void move (int n, int i, int j) {
        // Pull out the top disk on stack i.
        int topVal = towers[i].pop();
        // Put it on stack j.
        towers[j].push (topVal);
        // Print status.
        //System.out.println ("Towers after moving " + n + " from tower " + i + " to tower " + j);
        //printTowers ();
        moves++;
    }


    static int other (int i, int j) {
        // Given two towers, return the third.
        if ( (i == 0) && (j == 1) ) {
            return 2;
        }
        else if ( (i == 1) && (j == 0) ) {
            return 2;
        }
        else if ( (i == 1) && (j == 2) ) {
            return 0;
        }
        else if ( (i == 2) && (j == 1) ) {
            return 0;
        }
        else if ( (i == 0) && (j == 2) ) {
            return 1;
        }
        else if ( (i == 2) && (j == 0) ) {
            return 1;
        }

        // We shouldn't reach here.
        return -1;
    }


    static void printTowers () {
        for (int i=0; i<towers.length; i++) {
            System.out.print ("Tower " + i + ": ");
                if ( ! towers[i].isEmpty() ) {
                    for (Integer I: towers[i]) {
                        System.out.print (" " + I);
                    }
                }
            System.out.println ();
        }
    }
}