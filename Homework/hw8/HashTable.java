/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program implements the HashTable data structure. 

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class HashTable {

  private final ListNode[] buckets;
  private final int numBuckets;
  /**
   * constructor for the HashTable
   */
  public HashTable(int numBuckets) {
    this.numBuckets = numBuckets;
    this.buckets = new ListNode[numBuckets];
  }
  /**
   * Inserts a key-value pair into the HashTable
   * @param key the key to insert
   * @param value the value to insert corresponding to key
   * @return true if a key-value pair was inserted into the HashTable; otherwise,
   * returns false
   */
  public boolean insert(String key, int value) {
    // Obtain hashCode for the key
    int entry = Math.abs(hash(key));
    // Key is invalid
    if(key == null || key == "") {
      System.out.println("Key invalid");
      return false;
    // Checks if key exists in table
    } else if(contains(key)) {
      buckets[entry].setValue(value);
      return true; 
    // Key does not exist in table
    } else if(buckets[entry] == null) {
      buckets[entry] = new ListNode(key, value);
      return true;
    } else {
      buckets[entry].setNext(new ListNode(key, value));
      return true;
    }
  }
  /**
   * Searches the HashTable for the given key and returns its value
   * @param key the desired key to be found
   * @param profile the number of comparison made during search
   * @return an integer representing the value of the key; -1 if key
   * is not found
   */
  public int search(String key, int[] profile) {
    profile[0] += 1; 
    // Linear search of HashTable
    for(int i=0; i<numBuckets; i++) {
      profile[0] += 1;
      if(buckets[i] != null) {
        if(buckets[i].getKey().equals(key))
          return buckets[i].getValue();
      }
    }
    return -1;
  }

  /**
   * Generates hashCode for key
   * @param key the key
   * @return an integer representing the hashCode of the key
   */ 
  private int hash(String key) {
    return key.hashCode() % numBuckets;
  }

  /**
   * Determines if a key exists in the HashTable
   * @param key the key
   * @return true if the key is found in the Hashtable; otherwise,
   * returns false
   */
  public boolean contains(String key) {
    for(int i=0; i<numBuckets; i++) {
      if(buckets[i] != null) {
        if(buckets[i].getKey().equals(key))
          return true;
      }
    }
    return false;
  }
}
