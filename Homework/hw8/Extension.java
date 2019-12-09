/*-----------------------------------------------------------------------------
GWU - CS1112 Data Structures and Algorithms - Fall 2019

This program executes a performance analysis on the BinaryTree and Hashtables.

author: Grayson Buchholz
------------------------------------------------------------------------------*/
public class Extension {

  public static void main(String[] args) {
    Person[] people = PersonLoader.loadPeople();
    int[] profile = new int[1];
	  
    BinaryTree tree = new BinaryTree();

    HashTable table_1 = new HashTable(1000);

    HashTable table_2 = new HashTable(20000);

    HashTable table_3 = new HashTable(100000);
   
    HashTable table_4 = new HashTable(100003);

    // Fills tree and tables with people
    for(Person person : people) {
    	String key = person.getName();
    	int value = person.getAge();
    	tree.insert(key, value);
    	table_1.insert(key, value);
    	table_2.insert(key, value);
    	table_3.insert(key, value);
    	table_4.insert(key, value);
    }
    // Tree
    tree.search("GERALD WORKMAN", profile);
    System.out.println("GERALD WORKMAN | TREE | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    tree.search("JAMES TAYLOR", profile);
    System.out.println("JAMES TAYLOR | TREE | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    tree.search("JEFFERY DORSEY", profile);
    System.out.println("JEFFERY DORSEY | TREE | COMPARISONS MADE = " + profile[0]);
    System.out.println();
    profile[0] = 0;

    // Table(1000)
    table_1.search("GERALD WORKMAN", profile);
    System.out.println("GERALD WORKMAN | TABLE(1000) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_1.search("JAMES TAYLOR", profile);
    System.out.println("JAMES TAYLOR | TABLE(1000) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_1.search("JEFFERY DORSEY", profile);
    System.out.println("JEFFERY DORSEY | TABLE(1000) | COMPARISONS MADE = " + profile[0]);
    System.out.println();
    profile[0] = 0;

    // Table(20000)
    table_2.search("GERALD WORKMAN", profile);
    System.out.println("GERALD WORKMAN | TABLE(20000) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_2.search("JAMES TAYLOR", profile);
    System.out.println("JAMES TAYLOR | TABLE(20000) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_2.search("JEFFERY DORSEY", profile);
    System.out.println("JEFFERY DORSEY | TABLE(20000) | COMPARISONS MADE = " + profile[0]);
    System.out.println();
    profile[0] = 0;

    // Table(100000)
    table_3.search("GERALD WORKMAN", profile);
    System.out.println("GERALD WORKMAN | TABLE(100000) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_3.search("JAMES TAYLOR", profile);
    System.out.println("JAMES TAYLOR | TABLE(100000) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_3.search("JEFFERY DORSEY", profile);
    System.out.println("JEFFERY DORSEY | TABLE(100000) | COMPARISONS MADE = " + profile[0]);
    System.out.println();
    profile[0] = 0;

    // Table(100003)
    table_4.search("GERALD WORKMAN", profile);
    System.out.println("GERALD WORKMAN | TABLE(100003) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_4.search("JAMES TAYLOR", profile);
    System.out.println("JAMES TAYLOR | TABLE(100003) | COMPARISONS MADE = " + profile[0]);
    profile[0] = 0;

    table_4.search("JEFFERY DORSEY", profile);
    System.out.println("JEFFERY DORSEY | TABLE(100003) | COMPARISONS MADE = " + profile[0]);
    System.out.println();
    profile[0] = 0;
  }

}
