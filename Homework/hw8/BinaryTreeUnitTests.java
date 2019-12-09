/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program performs unit testing on the BinaryTree class.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class BinaryTreeUnitTests {
  /**
   * tests methods in BinaryTree implementation
   * @param args
   */
  public static void main(String[] args) {
  	if(testInsert()) 
  		System.out.println("testInsert: succeeded");
  	else
  		System.out.println("testInsert: failed");
    if(testSearch()) 
      System.out.println("testSearch: succeeded");
    else
      System.out.println("testSearch: failed");
  }
  // ------------------------------------------------------------------------
  /// Validates that insert works correctly
  static boolean testInsert() {
    BinaryTree tree = new BinaryTree();
    int[] profile = new int[1];

    // Implement insert method
    boolean insert = tree.insert("a", 0);

    // Validates that insert works as expected
    if(!insert)
      return false;

    // Validates that insert works with multiple items
    boolean newInsert = tree.insert("b", 1);
    if(!insert || !newInsert)
      return false;

    // Validates that values are in binaryTree
    if(tree.search("a", profile) != 0 || tree.search("b", profile) != 1)
      return false;

    // Validates that value is overwritten if same key is present
    tree.insert("a", 3);
    if(tree.search("a", profile) != 3)
      return false;

    // Validates that profile is as expected
    if(profile[0] <= 0)
      return false;

    return true;
  }
  // ------------------------------------------------------------------------
  /// Validates that search works correctly
  static boolean testSearch() {
    BinaryTree tree = new BinaryTree();
    int[] profile = new int[1];

    // Implment insert method
    tree.insert("a", 1);
    tree.insert("b", 2);
    tree.insert("c", 3);
    tree.insert("d", 4);
    tree.insert("e", 5);

    // Validates that search works correctly for every key in tree
    if(tree.search("a", profile) != 1)
      return false;
    if(tree.search("b", profile) != 2)
      return false;
    if(tree.search("c", profile) != 3)
      return false;
    if(tree.search("d", profile) != 4)
      return false;
    if(tree.search("e", profile) != 5)
      return false;

    // Validates that search works if a key has been overwritten
    tree.insert("a", 3);
    if(tree.search("a", profile) != 3)
      return false;

    // Validates that search returns -1 if value is not found
    if(tree.search("f", profile) != -1)
      return false;

    // Validates that profile is as expected
    if(profile[0] <= 0)
      return false;

    return true;
  }
}
