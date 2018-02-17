 package org.saumya.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRightRotation {
    static void reverseArray(int arr[], int start,
                             int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    static void rightRotate(int arr[], int k) {

        reverseArray(arr, 0, arr.length - 1);
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, arr.length - 1);

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        System.out.println(" by how many times you want to right rotate an array ");
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        rightRotate(arr, k);
        System.out.println("Array after right rotation :" + Arrays.toString(arr));


    }


}
