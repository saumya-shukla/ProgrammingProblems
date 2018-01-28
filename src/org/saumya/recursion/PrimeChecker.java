package org.saumya.recursion;

/**
 * This class checks if a given number is prime or not
 *
 * @author Shukla, Saumya
 */
public class PrimeChecker {

    public static boolean isPrime(int n) {
        int m = n / 2;
        for (int i = 2; i <= m; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeRecursive(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        return isPrimeRecursive(n, 2);
    }

    private static boolean isPrimeRecursive(int n, int current) {
        if (current > Math.sqrt(n)) {
            return true;
        }
        if (n % current == 0) {
            return false;
        }
        return isPrimeRecursive(n, current + 1);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(513));
        System.out.println(isPrimeRecursive(513));

        System.out.println(isPrime(7));
        System.out.println(isPrimeRecursive(7));

        System.out.println(isPrime(9));
        System.out.println(isPrimeRecursive(9));
    }
}
