// WAP to remove the outermost parentheses of a string.

import java.util.Scanner;

class Outermost
{
    public static String removeOuter(String s)
    {
        StringBuilder result = new StringBuilder();
        int openCount = 0;
        int closeCount = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }

            if (openCount == closeCount) {
                // Append the substring without the outermost parentheses
                result.append(s, start + 1, i);
                start = i + 1; // Move to the next segment
            }
        }

        return result.toString();    
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a valid parentheses string: ");
        String s = sc.nextLine();
        String result = removeOuter(s);
        System.out.println("String after removing outermost parentheses: " + result);
    }
}
