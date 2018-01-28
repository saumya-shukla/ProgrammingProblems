package org.saumya.sort;

import java.util.Arrays;

/**
 * This class implements the quick sort algorithm to sort an array of integers
 * Note that insertion sort is an in-place sorting algorithm
 *
 * @author Shukla, Saumya
 */
public class QuickSort {

    public static void quickSort(int arr[]) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    private static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int arr1[] = {10, 80, 30, 90, 50, 70, 20};
        quickSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {9, 8, 7, 6, 5, 4};
        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
