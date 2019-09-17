/*-----------------------------------------------------------------------------
GWU CSCI1112 Fall 2019
author: Grayson Buchholz

This program compares an input consisting of a set of letters with a 
dictionary of words and finds the longest word that can be spelled from the set
of input letters.
------------------------------------------------------------------------------*/
public class Countdown {

    // WordGame scans through the set of words and attempts to find words that
    // can be spelled using the set of letters.  Each letter can only be used
    // once.  If a letter repeats, that letter may be used an additional time
    // for each repetition.
    // @param words the set of words to search
    // @param letters the set of letters to unscramble
    // @return the longest word in the set of words that can be spelled using
    //         letters
    public static String WordGame(String[] words, String letters) {
        String word = "";
		boolean contains;
		int lengthCounter = 0;
		// iterates over each word in words and runs contains method on word
        for (int i=0; i<words.length; i++) {
        	// assigns return value of contains method to variable
        	contains = contains (letters, words[i]);
        	if (contains) {
        		// ensures that found word is longest word possible
        		if (words[i].length() > lengthCounter) {
        			word = words[i];
        			// assigns length of word to lengthCounter to be compared
        			lengthCounter = word.length();
				}
        	}
        }

    	return word;
    }

    /// This method compares a word with an unordered set of alphas and 
    /// determines whether the word can be spelled from a subset of the letters
    /// @input letters a randomly ordered set of characters
    /// @input word to check if can be spelled by characters in letters
    static boolean contains(String letters, String word) 
    {
    	letters = clean(letters);
    	word = clean(word);
    	// counts number of occurrences of a letter in letters
        int[] lettersCount = new int[26];
        for (int i=0; i<letters.length(); i++) {
        	int index = letters.charAt(i) - 'a';
        	lettersCount[index] ++;
        }
        // counts number of occurrences of a letter in word
        int[] wordCount = new int[26];
        for (int i=0; i<word.length(); i++) {
        	int index = word.charAt(i) - 'a';
        	wordCount[index] ++;
        }
        // compares count in wordCount to lettersCount
        for (int i=0; i<26;i++) {
        	// If index of wordCount > index of lettersCount, word is not a subset 
        	// of letters
        	if (wordCount[i] > lettersCount[i])
        		return false;
        }
        return true;
    }

    // ------------------------------------------------------------------------
    // UnitTests
    // ------------------------------------------------------------------------
    // The entry point which carries out the unit testing and the individual
    // tests are better suited to their own class; however, for simplicity
    // sake they are inside Countdown.

    /// Entry Point.  The main program executes a set of UnitTests on the 
    /// Countdown WordGame method.
    public static void main (String[] argv)
    {
        // Get the dictionary.
        String[] words = WordTool.getDictionary ();

	if( Test1(words) ) {
	    System.out.println("Test 1 succeeded");
	} else {
	    System.out.println("Test 1 failed");
	}

	if( Test2(words) ) {
	    System.out.println("Test 2 succeeded");
	} else {
	    System.out.println("Test 2 failed");
	}

	if( Test3(words) ) {
	    System.out.println("Test 3 succeeded");
	} else {
	    System.out.println("Test 3 failed");
	}
    }

    /// Unit Test 1
    /// @param words the set of words to search
    /// @return returns true if the test word correctly identified in the set 
    ///         of words; otherwise, returns false 
    public static boolean Test1(String[] words) {
        String letters = "ionsomsti";
        String word = WordGame(words, letters);

	if(word.compareTo("omission") == 0) {
	  return true;
	}
	return false;
    }

    /// Unit Test 2
    /// @param words the set of words to search
    /// @return returns true if the test word correctly identified in the set 
    ///         of words; otherwise, returns false 
    public static boolean Test2(String[] words) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String word = WordGame(words, letters);

	if(word.compareTo("ambidextrous") == 0) {
	  return true;
	}
	return false;
    }

    /// Unit Test 3
    /// @param words the set of words to search
    /// @return returns true if the test word correctly identified in the set 
    ///         of words; otherwise, returns false 
    public static boolean Test3(String[] words) {
        String letters = "igrnatehm";
        String word = WordGame(words, letters);

        if(word.compareTo("nightmare") == 0) {
        	return true;
        }

	return false;
    }

    // ------------------------------------------------------------------------
    // Utilities
    // ------------------------------------------------------------------------
    /// This method trims out all characters that are not alphas and then
    /// converts the string to lowercase.
    /// @param s the string to clean
    /// @return the cleaned string 
    public static String clean(String s)
    {
        return s.replaceAll("[^a-zA-Z]","").toLowerCase();
    }
}
