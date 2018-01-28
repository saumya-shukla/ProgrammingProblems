package org.saumya.recursion;

/**
 * This class sums all the digits of a given number
 *
 * @author Shukla, Saumya
 */
public class DigitsSum {

    public static int sumDigitsIterative(int n) {
        int sumDigits = 0;
        while (n > 0) {
            sumDigits += n % 10;
            n = n / 10;
        }
        return sumDigits;
    }

    public static int sumDigitsRecursive(int n) {
        if (n == 0) {
            return 0;
        } else {
            return sumDigitsRecursive(n / 10) + (n % 10);
        }
    }

    public static void main(String[] args) {
        System.out.println(sumDigitsIterative(513));
        System.out.println(sumDigitsRecursive(513));
    }
}
