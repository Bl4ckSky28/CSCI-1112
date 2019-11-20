// Ex: Think through how one could use the stack directly,
// instead of first removing non-letters. Why is it difficult?

import java.util.*;

public class Palindrome2 {

    public static void main (String[] argv) {
        // Oldest known recorded palindrome.
        String str = "Evil did I dwell; lewd I did live";
        System.out.println ( str + " " + checkPalindrome(str) );

        // Oldest reference.
        str = "Madam, I'm Adam";
        System.out.println ( str + " " + checkPalindrome(str) );

        // One of the most famous.
        str = "A man, a plan, a canal: Panama";
        System.out.println ( str + " " + checkPalindrome(str) );

        // Not a palindrome, but a palingram:
        str = "He was, was he?";
        System.out.println ( str + " " + checkPalindrome(str) );
    }
    

    static String checkPalindrome (String str)
    {
        char[] letters = str.toCharArray();

        Stack<Character> stack = new Stack<Character>();

        int mid = letters.length / 2;

        for(int i=0; i < mid; i++)
            if(Character.isLetter(letters[i]))
                stack.push(letters[i]);

        if(letters.length % 2 > 0)
            mid += 1;

        for(int i=mid; i < letters.length; i++) {
            char ch = stack.pop();
            if(ch != letters[i] && Character.isLetter(letters[i]))
                return "is not a palindrome";
        }
        return "is a palindrome";
    }

}