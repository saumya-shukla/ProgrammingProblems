package org.saumya.sort;

import java.util.Arrays;

/**
 * This class implements the merge sort algorithm to sort an array of integers
 *
 * @author Shukla, Saumya
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int arr[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int arr[], int low, int mid, int high) {
        int leftSubArraySize = mid - low + 1;
        int rightSubArraySize = high - mid;

        int[] left = new int[leftSubArraySize];
        int[] right = new int[rightSubArraySize];

        for (int i = 0; i < leftSubArraySize; i++) {
            left[i] = arr[low + i];
        }
        for (int j = 0; j < rightSubArraySize; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = low;
        while (i < leftSubArraySize && j < rightSubArraySize) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < leftSubArraySize) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < rightSubArraySize) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int arr1[] = {9, 2, 6, 3, 7, 11};
        mergeSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int arr2[] = {10, 80, 30, 90, 50, 70, 20};
        mergeSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
