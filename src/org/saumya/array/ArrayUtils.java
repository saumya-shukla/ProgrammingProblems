package org.saumya.array;

/**
 * This class implements some commonly used functionalities needed when dealing with integer arrays.
 *
 * @author Shukla, Saumya
 */
public class ArrayUtils {

    public static long sum(int a[]) {
        int n = a.length;
        long sum = 0;
        for (int x : a) {
            sum = sum + x;
        }
        return sum;
    }

    public static int max(int a[]) {
        int max = a[0];
        for (int x : a) {
            if (x > max) {
                max = x;
            }
        }
        return max;
    }

    public static int min(int a[]) {
        int min = a[0];
        for (int x : a) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }

    public static int secondMax(int arr[]) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array size must at least be 2 to find the second maximum element");
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int current : arr) {
            if (current > firstMax) {
                secondMax = firstMax;
                firstMax = current;
            } else if (current > secondMax && current != firstMax) {
                secondMax = current;
            }
        }
        return secondMax;
    }

    public static int secondMin(int arr[]) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Array size must at least be 2 to find the second minimum element");
        }

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int current : arr) {
            if (current < firstMin) {
                secondMin = firstMin;
                firstMin = current;
            } else if (current < secondMin && current != firstMin) {
                secondMin = current;
            }
        }
        return secondMin;
    }

    public static boolean isIncreasingSeq(int a[]) {
        boolean b = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                b = false;
            }
        }
        return b;
    }

    public static boolean isDecreasingSeq(int a[]) {
        boolean b = true;
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] < a[i + 1]) {
                b = false;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, 5, 4, 3};
        System.out.println("Sum: " + sum(arr));
        System.out.println("Max: " + max(arr));
        System.out.println("Min: " + min(arr));
        System.out.println("Second max: " + secondMax(arr));
        System.out.println("Second min: " + secondMin(arr));
        System.out.println("Is increasing sequence ? " + isIncreasingSeq(arr));
        System.out.println("Is decreasing sequence ? " + isDecreasingSeq(arr));
    }
}
