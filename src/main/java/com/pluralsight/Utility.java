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
            return false;

        }
    }


    /**
     * Prints the given text to the console gradually, character by character,
     * with a specified delay between each character.
     * @param text  the text to print
     * @param delay the delay in milliseconds between each character
     */

    public static void gradualText(String text, int delay) {
        // Print each character with a delay
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);// Delay in milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

}