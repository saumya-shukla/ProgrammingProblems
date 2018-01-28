package org.saumya.search;

/**
 * This class implements both recursive and non recursive versions of binary search to find an
 * element (key) in an array and return its index.
 *
 * In case of multiple occurrences of key in the array, it returns the leftmost key occurrence index.
 * In case the key does not exist, it returns -1.
 *
 * @author Shukla, Saumya
 */
public class BinarySearch {

    public static int iterativeBinarySearch(int a[], int key) {
        int l = 0;
        int h = a.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int a[], int key) {
        return recursiveBinarySearch(a, key, 0, a.length - 1);
    }

    private static int recursiveBinarySearch(int[] a, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (a[mid] == key) {
            return mid;
        } else if (a[mid] < key) {
            return recursiveBinarySearch(a, key, mid + 1, high);
        } else {
            return recursiveBinarySearch(a, key, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 5, 8, 13, 19};

        int singleKeyIndex1 = iterativeBinarySearch(arr, 8);
        System.out.println(singleKeyIndex1);

        int multipleKeyIndex1 = iterativeBinarySearch(arr, 5);
        System.out.println(multipleKeyIndex1);

        int notFoundKeyIndex1 = iterativeBinarySearch(arr, 6);
        System.out.println(notFoundKeyIndex1);

        int singleKeyIndex2 = recursiveBinarySearch(arr, 8);
        System.out.println(singleKeyIndex2);

        int multipleKeyIndex2 = recursiveBinarySearch(arr, 5);
        System.out.println(multipleKeyIndex2);

        int notFoundKeyIndex2 = recursiveBinarySearch(arr, 6);
        System.out.println(notFoundKeyIndex2);
    }
}
