package org.saumya.recursion;

/**
 * This class computes the nth fibonacci number, eg 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55...
 * The basic recursion is defined as F(n) = F(n-1) + F(n-2)
 * Base cases: F(0) = 0 and F(1) = 1
 *
 * @author Shukla, Saumya
 */
public class Fibonacci {

    public static int recursiveFibonacci(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static int iterativeFibonacci(int n) {
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    public static void main(String[] args) {
        System.out.println(recursiveFibonacci(10));
        System.out.println(iterativeFibonacci(10));

        System.out.println(recursiveFibonacci(13));
        System.out.println(iterativeFibonacci(13));
    }
}
