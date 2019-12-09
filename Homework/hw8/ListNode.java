/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program implements the ListNodes to be used in the HashTable.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class ListNode {

  private final String key;
  private int value;
  private ListNode next;

  public ListNode(String key, int value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }
}
