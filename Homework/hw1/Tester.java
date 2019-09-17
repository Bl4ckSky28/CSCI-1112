public class Tester {
	public static void main(String[] args) {
		String letters = "ionsomsti";
		String word = "aionsomsti";
		System.out.println(contains(letters, word));
	}

	static boolean contains(String letters, String word) {
		//counts number of occurrences of a letter in letters
        int[] lettersCount = new int[26];
        for (int i=0; i<letters.length(); i++) {
        	int index = letters.charAt(i) - 'a';
        	lettersCount[index] += 1;
        }
        //counts number of occurrences of a letter in word
        int[] wordCount = new int[26];
        for (int i=0; i<word.length(); i++) {
        	int index = word.charAt(i) - 'a';
        	wordCount[index] += 1;
        }
        //compares count in wordCount to lettersCount
        for (int i=0; i<26;i++) {
        	if (wordCount[i] > lettersCount[i])
        		return false;
        }
        return true;
	}
}