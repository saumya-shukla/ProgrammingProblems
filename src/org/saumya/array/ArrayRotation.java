package org.saumya.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {

    static void leftRotate(int arr[], int d) {
        for (int i = 0; i < d; i++)
            leftRotateByOne(arr);
    }

    static void leftRotateByOne(int arr[]) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;

    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        ArrayRotation ar = new ArrayRotation();
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        Scanner s = new Scanner(System.in);
        System.out.println("By how many places you need to shift the array");
        int d = s.nextInt();
        leftRotate(arr, d);
        System.out.println("Array after rotation :" + Arrays.toString(arr));


    }
}
