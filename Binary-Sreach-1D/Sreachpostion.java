/*
 * Program: Search Insert Position using Binary Search
 * This program finds the index at which a target value K 
 * should be inserted in a sorted array so that the array remains sorted.
 * If K already exists in the array, it returns the index of K.
 */
import java.util.Scanner;
public class Sreachpostion
{
    // Method to find the index to insert K using Binary Search
    public static int searchInsertK(int arr[], int k)
    {
        // Initialize the search boundaries
        int low = 0;
        int high = arr.length - 1;
        while (low <= high)
        {
            // Calculate the middle index to avoid overflow
            int mid = low + (high - low) / 2;
            // If K is found at mid, return the index
            if (arr[mid] == k)
            {
                return mid;
            }
            // If the middle element is smaller than K, search the right half
            else if (arr[mid] < k)
            {
                low = mid + 1;
            }
            // If the middle element is greater than K, search the left half
            else
            {
                high = mid - 1;
            }
        }
        // If not found, low will be the correct position to insert K
        return low; // Return the position where K can be inserted
    }
    public static void main(String[] args)
    {
        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        // Ask user for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        // Create an array of given size
        int arr[] = new int[n];
        // Take array elements as input (must be sorted)
        System.out.println("Enter the elements of the array in sorted order:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        // Ask user for the target value K
        System.out.print("Enter the value of K to search: ");
        int k = sc.nextInt();
        // Call the method to find the position of K
        int position = searchInsertK(arr, k);
        // Print the result
        System.out.println("The position to insert K is: " + position);
    }
}
