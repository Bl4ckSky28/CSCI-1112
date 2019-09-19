
public class ArrayCopy {

    public static void main (String[] argv)
    {
        int[][] A = {
            {1},
            {2, 1},
            {3, 2, 1},
            {4, 3, 2, 1},
            {5, 4, 3, 2, 1}
        };
        print (A);

        int[][] B = copy (A);
        print (B);
    }

    static void print (int[][] X)
    {
        for (int i=0; i<X.length; i++) {
            for (int j=0; j < X[i].length; j++) {
                System.out.print (" " + X[i][j]);
            }
            System.out.println ();
        }
    }
    
    static int[][] copy (int[][] array) {
        int[][] copy = new int[array.length][];
        // copies pointers into new array
        for (int i=0; i<array.length; i++) {
                copy[i] = array[i];
            
        }
        return array;
    }
    
}