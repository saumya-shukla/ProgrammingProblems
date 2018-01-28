package org.saumya.recursion;

/**
 * This class reverses a given number using iteration as well as recursion
 *
 * @author Shukla, Saumya
 */
public class NumberReverser {

    public static int reverse(int a) {
        int reverse = 0;
        while (a != 0) {
            reverse = reverse * 10;
            reverse = reverse + (a % 10);
            a = a / 10;
        }
        return reverse;
    }

    public static int reverseRec(int a) {
        return reverseRec(a, 0);
    }

    private static int reverseRec(int n, int rev) {
        if (n == 0) {
            return rev;
        } else {
            return reverseRec(n / 10, rev * 10 + (n % 10));
        }
    }

    public static void main(String[] args) {
        System.out.println("Reverse(2345): " + reverse(2345));
        System.out.println("Reverse using recursion(2345): " + reverse(2345));
    }
}
