import java.util.Arrays;
public class Palindrome2 {

    public static void main (String[] argv)
    {
        String str = "redder";
        char[] letters = str.toCharArray();
        System.out.println ( str + " " + checkPalindrome(letters,0,letters.length-1) );

        str = "river";
        letters = str.toCharArray();
        System.out.println ( str + " " + checkPalindrome(letters,0,letters.length-1) );

        str = "neveroddoreven";
        letters = str.toCharArray();
        System.out.println ( str + " " + checkPalindrome(letters,0,letters.length-1) );
    }
    

    static String checkPalindrome (char[] A, int first, int last)
    {
        if (A.length == 0 || A.length == 1)
            return "is a palindrome";
        if (A[first] != A[last])
            return "is not a palindrome";
        if(first < last + 1)
            return checkPalindrome(A, first+1, last-1);
        return "is a palindrome";
    }

}