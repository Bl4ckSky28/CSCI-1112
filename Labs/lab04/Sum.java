public class Sum {

    public static void main (String[] argv)
    {
        int n = 3;
        int S = sum (n);
        System.out.println ("Sum 1 + ... + " + n + " = " + S);
        
        n = 10;
        S = sum (n);
        System.out.println ("Sum 1 + ... + " + n + " = " + S);
    }
    
    static int sum(int n) {
        if (n <= 1)
            return n;
        return n + sum(n-1);
    }
}