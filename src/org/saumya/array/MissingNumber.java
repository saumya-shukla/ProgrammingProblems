package org.saumya.array;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list.
 * This class finds the missing integer.
 *
 * @author Shukla, Saumya
 */
public class MissingNumber {

    /**
     * Get the expected sum of numbers = n * (n+1) /2
     * Then, subtract from above the sum of all the numbers to get the missing number.
     */
    public static int missingNumber(int arr[]) {
        int n = arr.length;
        int total = (n + 1) * (n + 2) / 2;
        for (int x : arr) {
            total -= x;
        }
        return total;
    }

    /**
     * XOR all the array elements, let the result of XOR be X1
     * XOR all numbers from 1 to n, let XOR be X2
     * XOR of X1 and X2 gives the missing number
     */
    public static int missingNumberUsingXOR(int a[]) {
        int n = a.length;
        int x1 = a[0];
        int x2 = 1;

        for (int i = 1; i < n; i++) {
            x1 = x1 ^ a[i];
        }

        for (int i = 2; i <= n + 1; i++) {
            x2 = x2 ^ i;
        }

        return (x1 ^ x2);
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 6, 7};
        System.out.println("Missing number is: " + missingNumber(arr));
        System.out.println("Missing number is: " + missingNumberUsingXOR(arr));
    }
}


