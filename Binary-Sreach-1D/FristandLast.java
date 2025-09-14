// WAP to find the first and last occurrence of an element in a sorted array using binary search.
/*
 * This program finds the first and last occurrence of a given element in a sorted array using binary search.
 * It uses two modified binary search algorithms:
 *   - One to find the first occurrence (leftmost index) of the target element.
 *   - One to find the last occurrence (rightmost index) of the target element.
 * The main method reads array input from the user, invokes the search, and prints the result.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class FristandLast
{
    // Finds the first and last occurrence of x in arr
    public static ArrayList<Integer> find(int arr[], int x)
    {
        ArrayList<Integer> result = new ArrayList<>();
        // Find the first occurrence index using binary search
        int first = firstOccurrence(arr, x);
        // Find the last occurrence index using binary search
        int last = lastOccurrence(arr, x);
        result.add(first);
        result.add(last);
        return result;
    }

    // Binary search to find the first (leftmost) occurrence of x
    private static int firstOccurrence(int arr[], int x)
    {
        int low = 0, high = arr.length - 1, ans = -1;
        // Standard binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check if mid is the target
            if (arr[mid] == x) {
                ans = mid; // Record the index
                // Move left to see if there is another occurrence before mid
                // (We want the first occurrence, so search in the left half)
                high = mid - 1;
            } else if (arr[mid] < x) {
                // Target is on the right side
                low = mid + 1;
            } else {
                // Target is on the left side
                high = mid - 1;
            }
        }
        return ans;
    }

    // Binary search to find the last (rightmost) occurrence of x
    private static int lastOccurrence(int arr[], int x)
    {
        int low = 0, high = arr.length - 1, ans = -1;
        // Standard binary search loop
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // Check if mid is the target
            if (arr[mid] == x) {
                ans = mid; // Record the index
                // Move right to see if there is another occurrence after mid
                // (We want the last occurrence, so search in the right half)
                low = mid + 1;
            } else if (arr[mid] < x) {
                // Target is on the right side
                low = mid + 1;
            } else {
                // Target is on the left side
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Input the size of the array
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        // Input the elements of the array
        System.out.println("Enter the elements of array:");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        // Input the element to be searched
        System.out.println("Enter the element to be searched:");
        int x = sc.nextInt();
        // Find first and last occurrence of x
        ArrayList<Integer> result = find(arr, x);
        // Output the result
        System.out.println("First and Last occurrence of " + x + " is: " + result);   
     }
}
