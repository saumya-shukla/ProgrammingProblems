package org.saumya.search;

/**
 * This class implements linear search to find an element in an array and return its index.
 * In case of multiple occurrences of key in the array, it returns the leftmost key occurrence index.
 * In case the key does not exist, it returns -1.
 *
 * @author Shukla, Saumya
 */
public class LinearSearch {

    public static int linearSearch(int a[], int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 5, 8, 13, 19};

        int singleKeyIndex = linearSearch(arr, 13);
        System.out.println(singleKeyIndex);

        int multipleKeyIndex = linearSearch(arr, 5);
        System.out.println(multipleKeyIndex);

        int notFoundKeyIndex = linearSearch(arr, 7);
        System.out.println(notFoundKeyIndex);
    }
}
