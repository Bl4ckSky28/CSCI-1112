public class PangramCheck {

    public static void main (String[] argv)
    {
        // Pangram: a sentence with at least one occurence of each letter 'a' to 'z'.

        String[] pangramWords = {"two", "driven", "jocks", "help", "fax", "my", "big", "quiz"};
        boolean isPangram = checkPangram (pangramWords);
        System.out.println ("isPangram=" + isPangram);

        String[] pangram2 = {"two", "driven", "jocks", "help", "fax", "my", "big"};
        isPangram = checkPangram (pangram2);
        System.out.println ("isPangram=" + isPangram);
    }


    public static boolean checkPangram (String[] words)
    {
        int start = (int) 'a';
        int end = (int) 'z';
        //initializes boolean array with 26 spaces
        boolean[] alphabet = new boolean[26];

        //two for-loops are used to iterate over each letter in each word
        for (int i=0; i<words.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                // checks if character in word is in alphabet a-z by comparing decimal value of characters at index
                if ('a' <= words[i].charAt(j) && 'z' >= words[i].charAt(j)) {
                    // subtracts decimal value of 'a' from index to correspond to value in array
                    int index = words[i].charAt(j) - 'a';
                    // changes corresponding value in array to true
                    alphabet[index] = true;
                }
            }
        }

        //for-each loop that iterates over each value in array to check if words are a pangram
        for (boolean newIndex : alphabet) {
            // Checks if each value in newIndex is true
            if(!newIndex) {
                return false;
            }
        }
        return true;
    }
}