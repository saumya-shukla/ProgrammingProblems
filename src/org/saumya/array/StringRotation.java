package org.saumya.array;

/**
 * This class checks if a string can be obtained by rotating another string 2 places
 *
 * @author Shukla, Saumya
 */

public class StringRotation {


    static boolean isRotated(String str1, String str2) {
        String anticlock = "";
        String clock = "";
        if (str1.length() != str2.length()) {
            return false;

        } else {
            anticlock = anticlock +
                    str2.substring(str2.length() - 2, str2.length()) +
                    str2.substring(0, str2.length() - 2);
            clock = clock +
                    str2.substring(2) +
                    str2.substring(0, 2);
            return (str1.equals(clock) || str1.equals(anticlock));

        }
    }

    public static void main(String[] args) {
        String str1 = "coding";
        String str2 = "dingco";

        if (isRotated(str1, str2))
            System.out.println("String are rotations of each other");
        else {
            System.out.println("Strings are not rotations of each other");
        }
    }

}
