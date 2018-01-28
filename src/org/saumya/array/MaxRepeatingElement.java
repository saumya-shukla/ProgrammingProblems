package org.saumya.array;

import java.util.HashMap;
import java.util.Map;

/**
 * This class finds the maximum repeating element in an array
 * In case, each element occurs only once, it returns null
 * In case, there are multiple elements having same no of occurrences which is more than 1, then it may return any of these elements
 *
 * @author Shukla, Saumya
 */
public class MaxRepeatingElement {

    public static Integer maxRepeating(int arr[]) {
        Map<Integer, Integer> elementCounterMap = new HashMap<Integer, Integer>();
        for (int x : arr) {
            elementCounterMap.put(x, elementCounterMap.getOrDefault(x, 0) + 1);
        }

        Integer maxRepeatingElement = null;
        int maxRepeatingElementCount = 0;

        for (int element : elementCounterMap.keySet()) {
            int elementCount = elementCounterMap.get(element);
            if (elementCount > 1) {
                if (elementCount > maxRepeatingElementCount) {
                    maxRepeatingElementCount = elementCount;
                    maxRepeatingElement = element;
                }
            }
        }

        return maxRepeatingElement;
    }

    public static void main(String[] args) {

        int[] arr = {4, 4, 4, 2, 2};
        System.out.println(maxRepeating(arr));
    }


}
