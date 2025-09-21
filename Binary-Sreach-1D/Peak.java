// WAP to find a peak element in an array. An array element is a peak if it is NOT smaller than its neighbors.
// This implementation uses binary search to efficiently find a peak element in O(log n) time.

import  java.util.Scanner;
public class Peak
{
    /**
     * Finds a peak element in the given array using binary search.
     * A peak element is defined as one that is not smaller than its neighbors.
     * Time Complexity: O(log n)
     *
     * @param arr The input array of integers
     * @return The value of a peak element
     */
    public static int peakElement(int[] arr) {
        // Initialize start and end pointers to exclude the first and last elements initially,
        // because they are handled separately at the end.
        int start =1;
        int end = arr.length-2;
        int n = arr.length;
        
        // Base case: If the array contains only one element, that element is the peak.
        if(n==1){
            return 0;
        }
        
        // Use binary search to find a peak element in the subarray from index 1 to n-2.
        while(start<=end){
            // Calculate mid to avoid potential overflow.
            int mid = start + (end-start)/2;
            
            // Check if the mid element is greater than its neighbors.
            // If yes, mid is a peak element.
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            
            // If the mid element is greater than its left neighbor,
            // it means the peak lies on the right side of mid.
            if(arr[mid]>arr[mid-1]){ // search in right
                start = mid+1;
            }else{ 
                // Otherwise, the peak lies on the left side of mid.
                end = mid-1;
            }
        }
        // After the loop ends, check if the last element is greater than its previous element.
        // If yes, the last element is a peak.
        if(arr[n-1]>arr[n-2]){
            return n-1;
        }
        // Check if the first element is greater than its next element.
        // If yes, the first element is a peak.
        if(arr[0]>arr[1]){
            return 0;
        }
        // If no peak is found (which theoretically shouldn't happen), return -1.
        return -1;
    }
    public static void main(String[] args)
    {
        // Create a Scanner object for input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt(); // Read the size of the array
        int[] arr = new int[n]; // Declare the array
        System.out.println("Enter the elements of array:");
        // Read the elements of the array from user input
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        // Call the peakElement function to find a peak
        int result = peakElement(arr);
        // Output the result
        System.out.println("The peak element in the array is: " + result);
        sc.close(); // Close scanner to prevent resource leak
    }
}
