package org.saumya.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * This class checks if there are duplicates in a given array
 *
 * @author Shukla, Saumya
 */
public class DuplicatesFinder {

    /**
     * Time complexity: O(n*n)
     */
    public static boolean duplicatesExist(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Time complexity: O(n * log n)
     */
    public static boolean duplicatesExistUsingSort(int a[]) {
        Arrays.sort(a);
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == a[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Time complexity: O(n)
     */
    public static boolean duplicatesExistUsingSet(int a[]) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < a.length - 1; i++) {
            if (set.contains(a[i])) {
                return true;
            } else {
                set.add(a[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 2, 6, 3};
        System.out.println(duplicatesExist(array));
        System.out.println(duplicatesExistUsingSort(array));
        System.out.println(duplicatesExistUsingSet(array));
    }
}
