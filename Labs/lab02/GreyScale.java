import java.awt.*;
import java.awt.image.*;

public class GreyScale {

    static ImageTool imTool = new ImageTool ();

    public static void main (String[] argv)
    {
        // Read in an image and display.
        Image image = imTool.readImageFile ("statue.jpg");
        imTool.showImage (image, "original");

        // Convert to grey scale and display.
        Image greyImage = toGreyScale (image);
        imTool.showImage (greyImage, "grey-scale");
    }
    
    static Image toGreyScale (Image image)
    {
        // Extract pixels and size.
        int[][][] pixels = imTool.imageToPixels (image);
        int numRows = pixels.length;
        int numCols = pixels[0].length;

        // Make array of exactly the same size.
        int[][][] greyPixels = new int [numRows][numCols][4];

        // iterates over elements in array
        for(int i=0; i<numRows; i++) {
            for(int j=0; j<numCols; j++) {
                int average = 0;
                for(int k=1; k<4; k++) {
                    // assigns alpha from pixels and assigns it to greyPixels 
                    greyPixels[i][j][0] = pixels[i][j][0];
                    // average of RGB values
                    average += pixels[i][j][k] / 3;
                }
                // assigns average to corresponding elements in greyPixels
                for(int k=1; k<4; k++) {
                    greyPixels[i][j][k] = average;
                }
            }
        }

        Image greyImage = imTool.pixelsToImage (greyPixels);
        return greyImage;
    }

}