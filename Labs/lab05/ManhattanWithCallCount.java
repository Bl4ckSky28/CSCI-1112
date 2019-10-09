
public class ManhattanWithCallCount {
	static int counter = 0;
	static int[][] values;
	static int downcount = 0;
    static int rightcount = 0;
    public static void main (String[] argv)
    {
        // Test case 1: go from (2,2) to (0,0)
        counter = 0;
		int r = 2;
		int c = 2;
		values = new int[r+1][c+1]; 
		int n = countPaths (r, c);
		System.out.println ("r=" + r + " c=" + c + " => n=" + n);
		System.out.println(counter);

        // Test case 2: go from (5,7) to (0,0)
        counter = 0;
		r = 5;
		c = 7;
		values = new int[r+1][c+1];
		n = countPaths (r, c);
		System.out.println ("r=" + r + " c=" + c + " => n=" + n);
		System.out.println(counter);
    }
    
    static int countPaths (int numRows, int numCols)
    {
    	
        // Bottom-out case:
		if ( (numRows == 0) || (numCols == 0) ) {
	    	return 1;
		}

		if (values[numRows-1][numCols] == 0){
			counter++;
			downcount = countPaths(numRows-1, numCols);
			values[numRows-1][numCols] = downcount;
		}
		if (values[numRows][numCols-1] == 0){
			counter++;
			rightcount = countPaths(numRows, numCols-1);
			values[numRows][numCols-1] = rightcount;
		}        

		return downcount + rightcount;
    }
}