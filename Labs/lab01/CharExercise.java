import java.util.*;

public class CharExercise {

    public static void main (String[] argv)
    {
        char[] letters = {'f', 'a', 'c', 'e', 't', 'i', 'o', 'u', 's'};

        String s = "facetious";
        char[] letters2 = s.toCharArray ();

        char[] letters3 = new char [4];
        letters3[0] = 'f';
        letters3[1] = 'a';
        letters3[2] = 'c';
        letters3[3] = 'e';

        if ( checkEqual (letters, letters2) ) {
            System.out.println ( Arrays.toString(letters) + " = " + Arrays.toString(letters2) );
        }
        else {
            System.out.println ( Arrays.toString(letters) + " != " + Arrays.toString(letters2) );
        }

        if ( checkEqual (letters, letters3) ) {
            System.out.println ( Arrays.toString(letters) + " = " + Arrays.toString(letters3) );
        }
        else {
            System.out.println ( Arrays.toString(letters) + " != " + Arrays.toString(letters3) );
        }

    }

    public static boolean checkEqual (char[] array1, char[] array2) {
        // Checks if both arrays are of equal length
        if (array1.length != array2.length) {
            return false;
        }
        // Iterates over each value in array
        for (int i=0; i<array1.length; i++) {
            // Compares if given value in array is equal
            if(array1[i] != array2[i]) {
                return false;
            }           
        }
        return true;
    }
}
