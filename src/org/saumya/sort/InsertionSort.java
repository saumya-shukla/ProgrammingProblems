package org.saumya.sort;

import java.util.Arrays;

/**
 * This class implements the insertion sort algorithm to sort an array of integers
 * Note that insertion sort is an in-place sorting algorithm
 *
 * @author Shukla, Saumya
 */
public class InsertionSort {

    public static void insertionSort(int a[]) {
        int i, j, key;
        for (i = 1; i < a.length; i++) {
            key = a[i];
            j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int arr1[] = {9, 2, 7, 11, 6, 3};
        insertionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {9, 8, 7, 6, 5, 4};
        insertionSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
