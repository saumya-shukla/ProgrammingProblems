package org.saumya.array;
//this class implements program to reverse an array or string
//example--input--{1,2,3,4,5,6} output--{6,5,4,3,2,1}

import java.util.Arrays;


public class ReversingArrayOrString {

    static void reverseArray(int arr[], int start, int end) {
        int temp;

        if (start >= end)
            return;
        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);

    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println("Array before reversing :" + Arrays.toString(arr));
        reverseArray(arr, 0, arr.length - 1);
        System.out.println("Ärray after revrsing :" + Arrays.toString(arr));

    }
}
