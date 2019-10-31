public class DoublyLinkedListExample3 {

    public static void main (String[] argv) {
        DoublyLinkedIntList oddGuys = new DoublyLinkedIntList();
        oddGuys.add (1);
        oddGuys.add (3);
        oddGuys.add (5);
        oddGuys.add (7);

        oddGuys.printList();
        System.out.println ("Element at position 3: " + oddGuys.get(3));
        boolean isThere = oddGuys.contains (5);
        System.out.println ("isThere = " + isThere);
    }

}