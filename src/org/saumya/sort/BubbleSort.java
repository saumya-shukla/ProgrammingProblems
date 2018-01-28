package org.saumya.sort;

import java.util.Arrays;

/**
 * This class implements the bubble sort algorithm to sort an array of integers
 * Note that bubble sort is an in-place sorting algorithm
 *
 * @author Shukla, Saumya
 */
public class BubbleSort {

    public static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {11, 6, 2, 9, 7};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {9, 8, 7, 6, 5, 4};
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}

