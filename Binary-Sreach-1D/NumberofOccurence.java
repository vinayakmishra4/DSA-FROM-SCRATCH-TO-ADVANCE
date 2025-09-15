
/*
 * This program finds the number of occurrences of a given element (target) in a sorted array.
 * It uses a modified binary search to efficiently find the first and last occurrence of the target,
 * then calculates the total count by taking the difference of their indices.
 */

import java.util.Scanner;

public class NumberofOccurence
{
    /**
     * Returns the number of times target occurs in the sorted array arr.
     * It finds the first and last occurrence using binary search helper methods,
     * then computes the count as last - first + 1.
     */
    public static int countFreq(int[] arr, int target)
    {
        int n = arr.length;
        // Find the index of first occurrence of target
        int first = firstOccurence(arr, target, n);
        // If target is not found, return 0
        if (first == -1)
        {
            return 0; 
        }
        // Find the index of last occurrence of target
        int last = lastOccurence(arr, target, n);
        // The count is the difference of indices plus one
        return last - first + 1;
    }
    /**
     * Returns the index of the first occurrence of target in arr using a modified binary search.
     * If the target is not found, returns -1.
     * It narrows the search to the left half upon finding the target to find the first index.
     */
    public static int firstOccurence(int[] arr, int target, int n)
    {
        int start = 0;
        int end = n - 1;
        int result = -1; // Stores the index of first occurrence if found
        while (start <= end)
        {
            int mid = start + (end - start) / 2; // Calculate mid index
            if (arr[mid] == target)
            {
                result = mid; // Update result and search left part for earlier occurrence
                end = mid - 1;
            }
            else if (arr[mid] < target)
            {
                start = mid + 1; // Search right part
            }
            else
            {
                end = mid - 1; // Search left part
            }
        }
        return result;
    }

    /**
     * Returns the index of the last occurrence of target in arr using a modified binary search.
     * If the target is not found, returns -1.
     * It narrows the search to the right half upon finding the target to find the last index.
     */
    public static int lastOccurence(int[] arr, int target, int n)
    {
        int start = 0;
        int end = n - 1;
        int result = -1; // Stores the index of last occurrence if found
        while (start <= end)
        {
            int mid = start + (end - start) / 2; // Calculate mid index
            if (arr[mid] == target)
            {
                result = mid; // Update result and search right part for later occurrence
                start = mid + 1;
            }
            else if (arr[mid] < target)
            {
                start = mid + 1; // Search right part
            }
            else
            {
                end = mid - 1; // Search left part
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Prompt user for the size of the array
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        // Prompt user to enter array elements in sorted order
        System.out.println("Enter the elements of array in sorted order: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        // Prompt user for the target element to search for
        System.out.print("Enter the target element to find its occurrences: ");
        int target = sc.nextInt();
        // Compute the number of occurrences using countFreq
        int count = countFreq(arr, target);
        // Display the result to the user
        System.out.println("The number of occurrences of " + target + " is: " + count);
    }
}
