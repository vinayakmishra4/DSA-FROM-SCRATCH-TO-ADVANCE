/*
 * This program takes a sentence from the user and reverses the order of its words.
 * Example: "I love Java" → "Java love I"
 */
// Program to reverse the words in a given string
import java.util.Scanner;

class Reversewords
{
    /**
     * Reverses the order of words in the given string.
     * @param s Input string containing words separated by spaces
     * @return String with words reversed
     */
    public static String reWords(String s)
    {
        // Trim leading/trailing spaces and split by one or more spaces
        String[] words = s.trim().split("\\s+");
        // StringBuilder to construct the reversed sentence efficiently
        StringBuilder revstring = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            // Append the current word in reverse order
            revstring.append(words[i]);
            // Add a space between words (but not after the last word)
            if (i > 0)
                revstring.append(" ");
        }

        return revstring.toString();
    }
    public static void main(String[] args)
    {
        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // Call method to reverse the words
        String result = Reversewords.reWords(input);

        // Display reversed result
        System.out.println("Reversed words: " + result);
    }
}
