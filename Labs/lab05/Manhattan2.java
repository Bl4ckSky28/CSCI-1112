 
public class Manhattan2 {
    static int counter;
    public static void main (String[] argv)
    {
        // Test case 1:
        counter = 1;
        int r = 1, c = 1;
        int n = countPaths (r, c, "[1,1]");
        System.out.println ("r=" + r + " c=" + c + " => n=" + n);

        // Test case 2:
        counter = 1;
        r = 2;
        c = 2;
        n = countPaths (r, c, "[2,2]");

        System.out.println ("r=" + r + " c=" + c + " => n=" + n);
    }

    static int countPaths (int numRows, int numCols, String partialPath)
    {
        // Bottom out case: this is more complicated now.
        if (numRows == 0) {
            // Make the path across the columns.
            String finalStr = partialPath;
            for (int c=numCols-1; c>=0; c--) {
                finalStr += " -> [0," + c + "]";
            }
            System.out.print("Path #" + counter + ": ");
            System.out.println (finalStr);
            counter++;
            return 1;
        }
        else if (numCols == 0) {
            // Make the path down rows.
            String finalStr = partialPath;
            for (int r=numRows-1; r>=0; r--) {
                finalStr += " -> [" + r + ",0]";
            }
            System.out.print("Path #" + counter + ": ");
            System.out.println (finalStr);
            counter++;
            return 1;
        }
        
        

    
        // Otherwise, reduce problem size.

        // Downwards.
        String downpathStr = partialPath + " -> " + "[" + (numRows-1) + "," + numCols + "]";
        int downCount = countPaths (numRows-1, numCols, downpathStr);

        // Rightwards.
        String rightpathStr = partialPath + " -> " + "[" + (numRows) + "," + (numCols-1) + "]";
        int rightCount = countPaths (numRows, numCols-1, rightpathStr);

        // Add the two.
        return (downCount + rightCount);
    }
}