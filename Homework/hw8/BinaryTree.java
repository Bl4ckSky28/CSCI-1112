/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program implements the BinaryTree data structure. 

author: Grayson Buchholz
------------------------------------------------------------------------------*/
import java.util.List;
import java.util.ArrayList;

public class BinaryTree {

  private TreeNode root;
  /**
   * Simplification of recursiveInsert
   * @param key the key to insert
   * @param value the value to insert corresponding to key
   * @return true if a key-value pair was inserted into the BinaryTree; otherwise,
   * returns false
   */
  public boolean insert(String key, int value) {
    // Checks to see if key is invalid
    if(key == null || key == "")
      return false;
    // Calls recursiveInsert and assigns it to the root of the tree
    root = recursiveInsert(root, key, value);
    balanceTree();
    return true;
  }
  /**
   * Inserts a key-value pair into the BinaryTree
   * @param node the root node of the BinaryTree
   * @param key the key to insert
   * @param value the value to insert corresponding to key
   * @return TreeNode that is inserted
   */
  public TreeNode recursiveInsert(TreeNode node, String key, int value) {
    // Base case: the tree is empty
    if(node == null) {
      node = new TreeNode(key, value);
      return node;
    }
    // Go right
    if(node.getKey().compareTo(key) < 0)
      node.setRightChild(recursiveInsert(node.getRightChild(), key, value));
    // Go left
    else if(node.getKey().compareTo(key) > 0)
      node.setLeftChild(recursiveInsert(node.getLeftChild(), key, value));
    // Checks if key already exists in tree
    else if(node.getKey().equals(key))
      node.setValue(value);
    else
      return node;

    return node;
  }
  /**
   * Simplification of recursiveSearch
   * @param key the desired key to be found
   * @param profile the number of comparisons made during search
   * @return an integer representing the value of the key; -1 if key
   * is not found
   */
  public int search(String key, int[] profile) {
    // Calls recursive search and assigns it to node
    TreeNode node = recursiveSearch(root, key, profile);
    // Key is not present in BinaryTree
    if(node == null)
      return -1;
    return node.getValue();
  }
  /**
   * Simplification of recursiveSearch
   * @param root the root of the BinaryTree
   * @param key the desired key to be found
   * @param profile the number of comparisons made during search
   * @return a TreeNode representing the node to be found
   */
  public TreeNode recursiveSearch(TreeNode root, String key, int[] profile) {
    // Base case: tree is empty or root is key
    if(root == null || root.getKey().equals(key)) {
      profile[0] += 1;
      return root;
    }
    // Go left
    if(root.getKey().compareTo(key) > 0) {
      profile[0] += 1;
      return recursiveSearch(root.getLeftChild(), key, profile);
    }
    profile[0] += 1;
    // Go right
    return recursiveSearch(root.getRightChild(), key, profile);
  }
  /**
   * This algorithm focuses on correctness
   * and is not the most efficient algorithm
   * available. Please look up different
   * algorithms that solve the balancing problem.
   */
  private void balanceTree() {
    List<TreeNode> nodes = new ArrayList<TreeNode>();
    //Sorts tree from given root
    populateList(root, nodes);
    //Return null if root has no children
    if(nodes.size() == 0) return;

    this.root = balanceTreeHelper(nodes, 0, nodes.size() - 1);
  }

  private TreeNode balanceTreeHelper(List<TreeNode> nodes, int start, int end) {
    int mid = (start + end) / 2;
    TreeNode node = nodes.get(mid);
    if(start == end){
      node.setLeftChild(null);
      node.setRightChild(null);
      return node;
    }
    //Recursively balance tree on left and right children using
    //middle node as root
    if(!(mid - 1 < start)) {
      node.setLeftChild(balanceTreeHelper(nodes, start, mid - 1));
    } else {
      node.setLeftChild(null);
    }

    if(!(mid + 1 > end)) {
      node.setRightChild(balanceTreeHelper(nodes, mid + 1, end));
    } else {
      node.setRightChild(null);
    }

    return node;
  }

  private void populateList(TreeNode node, List<TreeNode> list) {
    if(node == null) return;
    populateList(node.getLeftChild(), list);
    list.add(node);
    populateList(node.getRightChild(), list);
  }
}
