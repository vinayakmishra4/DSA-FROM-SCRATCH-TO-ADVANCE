

/**
 * This program demonstrates the implementation of the binary search algorithm in Java.
 * Binary search is an efficient algorithm for finding an element in a sorted array.
 * It works by repeatedly dividing the search interval in half.
 * If the value of the search key is less than the item in the middle of the interval,
 * the search continues on the lower half. Otherwise, it continues on the upper half.
 * The process continues until the value is found or the interval is empty.
 */
import java.util.Scanner;

public class Sreach
{
    public int binarysearch(int[] arr, int k)
    {
        // Initialize the left and right pointers to the start and end of the array
        int left = 0;
        int right = arr.length - 1;
        // Continue searching while the search interval is valid
        while (left <= right)
        {
            // Calculate the middle index to avoid integer overflow
            int mid = left + (right - left) / 2;
            // Check if the middle element is the target
            if (arr[mid] == k)
            {
                // Target found, return its index
                return mid;
            }
            // If the middle element is less than the target, search the right half
            else if (arr[mid] < k)
            {
                left = mid + 1;
            }
            // If the middle element is greater than the target, search the left half
            else
            {
                right = mid - 1;
            }
        }
        // Target not found, return -1
        return -1;
    }
    public static void main(String[] args)
    {
        // Create a Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        // Read the size of the array
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array in sorted order:");
        // Read the array elements (assumed to be sorted)
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();  
        }
        System.out.println("Enter the element to be searched:");
        // Read the element to search for
        int k = sc.nextInt();
        // Create an object of Sreach class and call binarysearch
        Sreach ob = new Sreach();
        int result = ob.binarysearch(arr, k);
        // Print the result based on the return value
        if (result == -1)
        {
            System.out.println("Element not found in the array.");
        }
        else
        {
            System.out.println("Element found at index: " + result);
        }
    }   
}
