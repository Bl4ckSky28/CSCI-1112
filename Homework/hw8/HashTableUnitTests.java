/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program performs unit testing on the HashTable class.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class HashTableUnitTests {
  /**
   * tests methods in HashTable implementation
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
  	if(testContains())
  		System.out.println("testContains: succeeded");
  	else
  		System.out.println("testContains: failed");
  }
  // ------------------------------------------------------------------------
  /// Validates that insert works correctly
  static boolean testInsert() {
  	HashTable table = new HashTable(20);
  	int[] profile = new int[1];

   	// Implement insert method
   	boolean insert = table.insert("a", 2);

   	// Validate that insert works as expected
   	if(!insert)
   		return false;

   	// Validate that insert works with multiple items
   	boolean newInsert = table.insert("b", 3);
   	if(!insert || !newInsert)
   		return false;

   	// Validate that values are in hashTable
   	if(table.search("a", profile) != 2 || table.search("b", profile) != 3)
   		return false;

   	// Validates that value is overwritten if same key is present
   	table.insert("a", 3);
   	if(table.search("a", profile) != 3)
   		return false;

   	// Validates that profile is as expected
   	if(profile[0] <= 0)
   		return false;

   	return true;
  }
  // ------------------------------------------------------------------------
  /// Validates that search works correctly
  static boolean testSearch() {
  	HashTable table = new HashTable(20);
  	int[] profile = new int[1];

  	// Implment insert method
  	table.insert("a", 1);
  	table.insert("b", 2);
  	table.insert("c", 3);
  	table.insert("d", 4);
  	table.insert("e", 5);

  	// Validates that search works correctly for every key in table
  	if(table.search("a", profile) != 1)
  		return false;
  	if(table.search("b", profile) != 2)
  		return false;
  	if(table.search("c", profile) != 3)
  		return false;
  	if(table.search("d", profile) != 4)
  		return false;
  	if(table.search("e", profile) != 5)
  		return false;

  	// Validates that search works if a key has been overwritten
  	table.insert("a", 3);
  	if(table.search("a", profile) != 3)
  		return false;

  	// Validates that profile is as expected
   	if(profile[0] <= 0)
   		return false;

    return true;
  }
  // ------------------------------------------------------------------------
  /// Validates that contains works correctly
  static boolean testContains() {
  	HashTable table = new HashTable(20);

  	// Implement insert method
  	table.insert("a", 2);

  	// Validates that contains works as expected
  	if(!table.contains("a"))
  		return false;

  	// Validates that contains works with multiple keys
  	table.insert("b", 3);
  	table.insert("c", 4);
  	if(!table.contains("b") || !table.contains("c"))
  		return false;

  	return true;
  }
}
