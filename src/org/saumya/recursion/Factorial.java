package org.saumya.recursion;

/**
 * This class computes the nth factorial, defined as F(n) = 1 X 2 X ... X n
 * The basic recursion is defined as F(n) = n X F(n-1)
 * Base cases: F(0) = 1
 *
 * @author Shukla, Saumya
 */
public class Factorial {
    public static int iterativeFactorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return (n * recursiveFactorial(n - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(iterativeFactorial(5));
        System.out.println(recursiveFactorial(5));

        System.out.println(iterativeFactorial(11));
        System.out.println(recursiveFactorial(11));
    }
}
