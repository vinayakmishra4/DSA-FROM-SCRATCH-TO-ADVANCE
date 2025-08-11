// WAP to find the longest Subsequence

import java.util.HashSet;
import java.util.Scanner;

class LongestSubsequnence
{
    public static int longestConsecutive(int[] arr) 
    {
        HashSet<Integer> numSet = new HashSet<>();
        int longest = 0;

        // Add all numbers to the set
        for (int num : arr) {
            numSet.add(num);
        }

        // Iterate through each number
        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int streak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    streak++;
                }

                longest = Math.max(longest, streak);
            }
        }

        return longest;     
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        // Take array size as input
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        // Take array elements as input
        System.out.println("Enter the elements of array:");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
    }
}