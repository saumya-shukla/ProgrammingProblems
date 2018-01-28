package org.saumya.sort;

import java.util.Arrays;

/**
 * This class implements the selection sort algorithm to sort an array of integers
 * Note that insertion sort is an in-place sorting algorithm
 *
 * @author Shukla, Saumya
 */
public class SelectionSort {

    public static void selectionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }

                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {9, 2, 6, 3, 7, 11};
        selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int arr2[] = {10, 80, 30, 90, 50, 70, 20};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}