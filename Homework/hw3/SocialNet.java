/*-----------------------------------------------------------------------------
GWU CSCI1112 Fall 2019
author: Grayson Buchholz

This class encapsulates the logic necessary to work with referential copies of
array, sorting algorithms, recursion, and the implicit costs involved with
algorithms in general.
-----------------------------------------------------------------------------*/
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
import java.util.*;
import java.text.*;

public class SocialNet {
    //------------------------------------------------------------------------- 
    // Base Problems
    //------------------------------------------------------------------------- 
    /// A referential copy (shallow copy of each row) and not an element-wise 
    /// copy (deep copy).  We are sorting elements with respect to the original
    /// data rather than generating a new set of data.
    /// @param posts data containing the rows to reference
    /// @return the shallow copy of rows
    public static int[][] createView(int[][] posts) {
        int[][] view = new int [posts.length][];
        // Shallow copy of view
        for (int i=0; i<posts.length; i++) {
            view[i] = posts[i];
        }
        return view;
    }
 
    //------------------------------------------------------------------------- 
    /// Compute the differential between "ups" (at index 1) and "downs" 
    /// (at index 2). The differential is not maintained in the data but is a 
    /// virtual field derived by the calculation performed here
    public static int differential(int[] post) {
        return post[1] - post[2];
    }

    //------------------------------------------------------------------------- 
    /// Performs a comparison between two posts that is equivalent to a less
    /// than operation so that a sort can use this function to order posts.
    /// The less than criteria is an evaluation between the differentials of
    /// two posts.
    /// @param post1 a post record that is used as the "left" operand for a
    ///        less than comparison 
    /// @param post2 a post record that is used as the "right" operand for a
    ///        less than comparison 
    /// @return returns true if the computed differential for post1 is less than
    ///         the computed differential for post2; otherwise, returns false 
    ///         (false implies that differential for post1 is greater than or
    ///         equal to post2)
    public static boolean lessThan(int[] post1, int[] post2) {
        // Comparison test
        if (differential(post1) < differential(post2)) {
            return true;
        }
        return false;
    }
    //------------------------------------------------------------------------- 
    /// Swaps references to posts.  Note that this is a "shallow" swap and not 
    /// a "deep" swap
    /// @param view A shallow copy of a set of posts 
    /// @param i the index of the first reference to swap
    /// @param j the index of the second reference to swap
    public static void swapPosts(int[][] view, int i, int j) {
        int[] temp = view[i];
        view[i] = view[j];
        view[j] = temp;
    }

    //------------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to posts in descending order 
    /// subject to the differential between ups and downs using one of
    /// the iterative sorts we discussed in class, i.e. selection, bubble, or 
    /// insertion sort
    /// @param view A shallow copy of a set of posts 
    /// @return a set of profile information containing a count of 
    ///         0: allocations, 1:comparisons, and 2: swaps
    public static int[] iterativeSort(int[][] view) {
        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        int[] profile = new int[3];
        // Variables for profile
        int allocs = 0;
        int comparisons = 0;
        int swaps = 0;
        
        // Stop at n-1
        for (int i=0; i<view.length-1; i++) {
            // Find the ith largest and swap
            int[] largest = view[i];
            // Count allocations
            allocs++;
            int pos = i;
            // Look from i+1 and up
            for (int j=i+1; j<view.length; j++) {
                if(lessThan(largest, view[j])) {
                    largest = view[j];
                    pos = j;
                }
                // Count comparisons
                comparisons++;
            }
            // Swap into position i
            swapPosts(view, i, pos);
            // Count swaps
            swaps++;
        }

        // Assign counts to profile
        profile[0] = allocs;
        profile[1] = comparisons;
        profile[2] = swaps;

        return profile;
        
    }

    //------------------------------------------------------------------------- 
    // Extension Problems
    //------------------------------------------------------------------------- 
    /// Sorts (shallow) a set of references to posts in descending order 
    /// subject to the differential between ups and downs using a recursive
    /// approach, i.e. quicksort.
    /// @param view A shallow copy of a set of posts 
    /// @return a set of profile information containing a count of 
    ///         0: allocations, 1:comparisons, and 2: swaps

    static int allocs = 0;
    static int comparisons = 0;
    static int swaps = 0;

    public static int[] recursiveSort(int[][] view) {
        // profile[0:allocs (ignore profile), 1:comparisons, 2:swaps]
        int[] profile = new int[3];

        quickSortRecursive(view, 0, view.length-1);

        profile[0] = allocs;
        profile[1] = comparisons;
        profile[2] = swaps;

        return profile;
    }

    static void quickSortRecursive (int[][] view, int left, int right) {
        if (left < right) {
            // Partition to find the "right place" for the leftmost element.
            int partitionPosition = quickSortPartition (view, left, right);
            // Recurse on the left side:
            quickSortRecursive (view, left, partitionPosition-1);
            // Recurse on the right side:
            quickSortRecursive (view, partitionPosition+1, right);
        }
        // Else: left==right so we're done.
    }

    static int quickSortPartition (int[][] view, int left, int right) {
        if (left == right)
            return left;
        int[] partitionElement = view[right];
        // Count number of allocations
        allocs++;
        int currentSwapPosition = right;
        // Examine everything between left and right-1 inclusive.
        for(int i=right-1; i>=left; i--) {
            
            if(lessThan(view[i], partitionElement)) {
                currentSwapPosition--;
                // Shift swap position rightwards:
                swapPosts(view, currentSwapPosition, i);
                // Count number of swaps
                swaps++;
            }
            // Count number of comparisons
            comparisons++;
        }
        // Last one:
        swapPosts(view, currentSwapPosition, right);
        // Count number of swaps
        swaps++;
        return currentSwapPosition;
            
    }

}


