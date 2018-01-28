package org.saumya.recursion;

/**
 * This class computes the exponentiation of a to the power of n
 *
 * @author Shukla, Saumya
 */
public class Exponentiation {

    public static int iterativePower(int a, int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res = res * a;
        }
        return res;
    }

    public static int recursivePower(int a, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return a;
        } else {
            if (n % 2 == 0) {
                int temp = recursivePower(a, n / 2);
                return temp * temp;
            } else {
                int temp = recursivePower(a, (n - 1) / 2);
                return a * temp * temp;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(iterativePower(5, 3));
        System.out.println(recursivePower(5, 3));

        System.out.println(iterativePower(7, 6));
        System.out.println(recursivePower(7, 6));
    }
}
