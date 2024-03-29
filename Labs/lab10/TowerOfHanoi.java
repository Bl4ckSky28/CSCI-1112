public class TowerOfHanoi {

    public static void main (String[] argv) {
        // A 3-disk puzzle:
        System.out.println ("3-Disk solution: ");
        solveHanoi (2, 0, 1);

        // A 4-disk puzzle:
        System.out.println ("4-Disk solution: ");
        solveHanoi (3, 0, 1);
    }

    static void solveHanoi (int n, int i, int j) {
	   // Bottom-out.
	   if (n == 0) {
            // The smallest disk.
            move (0, i, j);
            return;
	   }

	   int k = other (i, j);
	   solveHanoi (n-1, i, k);    // Step 1.
	   move (n, i, j);            // Step 2.
	   solveHanoi (n-1, k, j);    // Step 3.
    }

    static void move (int n, int i, int j) {
        // For now, we'll merely print out the move.
        System.out.println ("=> Move disk #" + n + " from tower " + i + " to tower " + j);
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

}