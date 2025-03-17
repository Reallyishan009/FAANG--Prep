/*
 * Your function takes an integer (prod) and 
 * returns an array/tuple (check the function signature/sample tests for the return type in your language):
if F(n) * F(n+1) = prod:
If you do not find two consecutive F(n) verifying F(n) * F(n+1) = prod:
(F(n), F(n+1), false)
where F(n) is the smallest one such as F(n) * F(n+1) > prod.
 */


 public class ProdFib { // must be public for Codewars	

    public static long[] productFib(long prod) {
        long a = 0, b = 1;
        
        while (a * b < prod) {
            long temp = b;
            b = a + b;
            a = temp;
        }
        
        return new long[]{a, b, (a * b == prod) ? 1 : 0}; // Convert boolean to long (1 = true, 0 = false)
    }

    public static void main(String[] args) {
        long[] result = productFib(714); // Expected: [21, 34, 1]
        System.out.println(java.util.Arrays.toString(result));

        result = productFib(800); // Expected: [34, 55, 0]
        System.out.println(java.util.Arrays.toString(result));
    }
}
