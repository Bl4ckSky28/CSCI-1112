/*-----------------------------------------------------------------------------
GWU CSCI1112 Fall 2019
author: Grayson Buchholz

This class encapsulates the logic necessary to perform simple steganography 
cyphering.
------------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;

public class Steganography {

    //------------------------------------------------------------------------- 
    // Base Problems
    //------------------------------------------------------------------------- 
    /// Performs a deep copy of the input pixels and returns the copy
    /// @param px the pixels from an image to copy
    /// @return the deep copy of the pixels that were copied
    public static int[][][] copy(int[][][] px) {
    	int numRows = px.length;
    	int numCols = px[0].length;
    	int numPillars = px[0][0].length;
        // Creates new copy array
    	int[][][] copy = new int[numRows][numCols][numPillars];
        // Iterates over each pixel in array and copies it
        for (int i=0; i<numRows; i++) {
        	for (int j=0; j<numCols; j++) {
        		for (int k=0; k<numPillars; k++) {
        			copy[i][j][k] = px[i][j][k];
        		} 
        	}
        }
        return copy;
    }

    //------------------------------------------------------------------------- 
    /// Computes the error in the individual color channels (RGB only) between 
    /// a pixel in the key image and a pixel in the cypher image.
    /// @param keyPixel An array containing ARGB values that represents a pixel
    ///        in the key image    
    /// @param cypherPixel An array containing ARGB values that represents a 
    ///        pixel in the cypher image
    /// @return An array containing the error (positive values only) between 
    ///         the RGB channels of the input pixels. 
    public static int[] colorError( int[] keyPixel, int[] cypherPixel ) {
        int[] error = new int [keyPixel.length-1];
        for (int i=0; i<keyPixel.length-1; i++) {
            // Assigns absolute value of the difference between the cypherPixel and keyPixel
        	error[i] = Math.abs(cypherPixel[i + 1] - keyPixel[i + 1]);  
        }
		return error;
    }

    //------------------------------------------------------------------------- 
    /// Computes the RGB error based on the position of a character in the 
    /// alphabet.  The error is represented using the same value in each
    /// cell of the array.
    /// @param chpos The characters ordinal position in the alphabet
    /// @return an array of three values that represents the error to introduce
    ///         into to a color 
    public static int[] positionToError( int chpos ) {
        int[] errorValues = new int [3];
        // Fills errorValues with correct values
        for (int i=0; i<3; i++) {
        	errorValues[i] = chpos + 1;
        }
        return errorValues;
    }

    //------------------------------------------------------------------------- 
    /// Computes the ordinal position of a character based on the error uniform
    /// represented in all cells in an input array of three values.
    /// @param error An array of RGB values (Note that this excludes the alpha 
    ///        channel).  
    /// @return The ordinal position of a character in the alphabet based on
    ///         the amount of error in the input 
    public static int errorToPosition( int[] error ) {
        int position = 0;
        // Computes position based on error
        for (int i=0; i<error[0]; i++) {
        	position ++;
        }
        return position - 1;
    }

    //------------------------------------------------------------------------- 
    /// Encrypts a string of characters into a copy of the key image
    /// @input s the string of characters to encrypt
    /// @input pxKey the image to encrypt the string into
    /// @return the encrypted image
    public static int[][][] encrypt(String s, int[][][] pxKey) {
        // Creates deep copy of pxKey
        int[][][] cypherImage = copy(pxKey);
        // Array of errorvalues where each position in array corresponds to letter in s
        int[][] errorValues = new int [s.length()][3];

        // Fills errorValues with correct errorValues based on position of characters 
        for(int i=0; i<s.length(); i++) {
            // Computers ordinal position of characters
            int asciiValue = s.charAt(i) - 'A';
            int[] positionError = positionToError(asciiValue);
            errorValues[i] = positionError;
        }
        
        int rowIndex = 0;
        int columnIndex = 0;

        // Changes pixel in cypherImage by corresponding errorValue
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<3; j++) {
                cypherImage[rowIndex][columnIndex][j+1] -= errorValues[i][j];
            }
            rowIndex += 10;
            // Every 10th pixel in every 10th row
            if(pxKey.length - rowIndex < 10) {
                rowIndex = 0;
                columnIndex += 10;
            }
            
        }
        return cypherImage;
    }


    //------------------------------------------------------------------------- 
    /// Decrypts a string of characters encoded into an image by comparing
    /// pixels in the cypher with the key image
    /// @input pxCypher the encrypted image containing the message
    /// @input pxKey the key image that was used for the encryption
    /// @return the decrypted string of characters
    public static String decrypt(int[][][] pxCypher, int[][][] pxKey) {
        String word = "";
        // Arrays to hold RGB value of pixels
        int[] keyPixel = new int [3];
        int[] cypherPixel = new int [3];

        // Holds RGB value of error
        int[] colorError = new int[3];

        int rowIndex = 0;
        int columnIndex = 0;

        while (true) {
            for(int j=0; j<3; j++) {
                keyPixel[j] = pxKey[rowIndex][columnIndex][j+1];
                cypherPixel[j] = pxCypher[rowIndex][columnIndex][j+1];    
            }
            // Every 10th pixel in every 10th row
            rowIndex += 10;
            if (pxKey.length - rowIndex < 10) {
                rowIndex = 0;
                columnIndex += 10;
            }
                
            
            colorError = colorError(keyPixel, cypherPixel);
            // Creates string with decrypted message
            int position = errorToPosition(colorError);
            if (position >= 0) {
                word += Character.toString((char)(position + 'A'));
            } else {
                // Break if end of message is reached
                break;
            }
        }
        return word;
    }

    //------------------------------------------------------------------------- 
    // Extension Problems
    //------------------------------------------------------------------------- 
    /// Computes the RGB error based on the position of a character in the 
    /// alphabet.  The error is spread across each cell in the array.
    /// @param chpos The characters ordinal position in the alphabet
    /// @return an array of three values that represents the error to introduce
    ///         into to a color 
    public static int[] positionToError2( int chpos ) {
        int[] errorValues = new int [3];
        // Populates errorValues with correct values
        for(int i=0; i<=chpos; i++) {
            if (i % 3 == 0) {
                errorValues[0] += 1;
            } else if (i % 2 == 1) {
                errorValues[1] += 1;
            } else {
                errorValues[2] += 1;
            }
        }
        return errorValues;
    }

    //------------------------------------------------------------------------- 
    /// Computes the ordinal position of a character based on the error spread
    /// across different cells in an input array of three values.
    /// @param error An array of RGB values (Note that this excludes the alpha 
    ///        channel).  
    /// @return The ordinal position of a character in the alphabet based on
    ///         the amount of error in the input 
    public static int errorToPosition2( int[] error ) {
        // Sum of elements in array
        int sum = 0;
        for (int element : error) {
            sum += element;
        }
        return sum - 1;
    }

    //------------------------------------------------------------------------- 
    /// Encrypts a string of characters into a copy of the key image
    /// @input s the string of characters to encrypt
    /// @input pxKey the image to encrypt the string into
    /// @return the encrypted image
    public static int[][][] encrypt2(String s, int[][][] pxKey) {
        int[][][] cypherImage = copy(pxKey);
        int[][] errorValues = new int [s.length()][3];
        for(int i=0; i<s.length(); i++) {
            int asciiValue = s.charAt(i) - 65;
            int[] positionError = positionToError2(asciiValue);
            errorValues[i] = positionError;
        }
        
        int rowIndex = 0;
        int columnIndex = 0;
        float average = 0;
        for (int i=0; i<s.length(); i++) {
            for (int j=0; j<3; j++) {
                // Color channel comparison
                average = cypherImage[rowIndex][columnIndex][j+1] / 3;
                if (average > 127.5) {
                    cypherImage[rowIndex][columnIndex][j+1] += errorValues[i][j];
                } else {
                    cypherImage[rowIndex][columnIndex][j+1] -= errorValues[i][j];
                }
            }
            rowIndex += 10;

            if(pxKey.length - rowIndex < 10) {
                rowIndex = 0;
                columnIndex += 10;
            }
            
        }

        return cypherImage;
    }

    //------------------------------------------------------------------------- 
    /// Decrypts a string of characters encoded into an image by comparing
    /// pixels in the cypher with the key image
    /// @input pxCypher the encrypted image containing the message
    /// @input pxKey the key image that was used for the encryption
    /// @return the decrypted string of characters
    public static String decrypt2(int[][][] pxCypher, int[][][] pxKey) {
        String word = "";
        int[] keyPixel = new int [3];
        int[] cypherPixel = new int [3];
        int[] colorError = new int[3];

        int rowIndex = 0;
        int columnIndex = 0;
        while (true) {
            for(int j=0; j<3; j++) {
                keyPixel[j] = pxKey[rowIndex][columnIndex][j+1];
                cypherPixel[j] = pxCypher[rowIndex][columnIndex][j+1];    
            }
            rowIndex += 10;

            if (pxKey.length - rowIndex < 10) {
                rowIndex = 0;
                columnIndex += 10;
            }
                
            
            colorError = colorError(keyPixel, cypherPixel);
            //this was changed
            int position = errorToPosition2(colorError);
            if (position >= 0) {
                word += Character.toString((char)(position + 65));
            } else {
                break;
            }
        }
        return word;
    }
}
