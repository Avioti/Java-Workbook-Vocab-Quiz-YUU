package com.pluralsight;

public class Utility {

    /**
     * Validates if the provided string can be parsed as an integer.
     * If not, it prints an error message.
     *
     * @param str the string to validate
     */
    public static void isNumber(String str) {
        try {

            Integer.parseInt(str);

        } catch (Exception e) {
            System.out.println();

            System.out.println("Error: Please enter a valid number.");



        }
    }

    /**
     * Checks if the provided string can be parsed as an integer.
     *
     * @param str the string to check
     * @return true if the string is a valid integer, false otherwise
     */

    public static boolean ifNumber(String str) {
        try {

            Integer.parseInt(str);
            return true;

        } catch (Exception e) {
            System.out.println("Error: Please enter a valid number.");
            return false;

        }
    }

    public static void isANumber(String str) {
        try {

            Integer.parseInt(str);

        } catch (Exception e) {
            System.out.println();

            System.out.println("Error: Please enter a valid number.");
        }}

}