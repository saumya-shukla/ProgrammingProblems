package org.saumya.array;

/**
 * This class returns the rotation count of a given array i.e. sorted and rotated
 *
 * @author Shukla, Saumya
 */
public class RotationCount {

    static int countRotation(int arr[]) {

        int min = arr[0];
        int min_index = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (min > arr[i]) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12};


        System.out.println(" Array is rotated "+countRotation(arr)+" number of times.");
    }


}




