// Program to find the Split Array Largest Sum using Binary Search
// The goal: Split the array into k subarrays such that the largest subarray sum is minimized.

import java.util.Scanner;

class SplitArray
{
    // Function to compute the minimized largest subarray sum
    public int splitArray(int[] arr, int k)
    {
        // 'left' will store the largest element in the array (minimum possible largest sum)
        // 'right' will store the sum of all elements (maximum possible largest sum)
        int left = 0;
        int right = 0;

        // Calculate initial binary search range
        for (int num : arr)
        {
            left = Math.max(left, num); // At least one subarray must contain this max element
            right += num;               // If we take the whole array as one subarray
        }

        // Binary search between 'left' and 'right'
        while (left < right)
        {
            // Midpoint of current search range
            int mid = left + (right - left) / 2;

            // If we can split the array into <= k subarrays such that
            // each subarray's sum <= mid, then try a smaller value
            if (canSplit(arr, k, mid))
            {
                right = mid; // Try to minimize the largest sum
            }
            else
            {
                // Otherwise, mid is too small — increase it
                left = mid + 1;
            }
        }

        // When left == right, we’ve found the smallest possible largest subarray sum
        return left;
    }

    // Helper function to check if we can split array into <= k subarrays with each sum <= maxSum
    private boolean canSplit(int[] arr, int k, int maxSum)
    {
        int currentSum = 0; // Current subarray sum
        int subarrays = 1;  // Count of subarrays formed (start with one)

        for (int num : arr)
        {
            currentSum += num;

            // If adding this element exceeds maxSum, start a new subarray
            if (currentSum > maxSum)
            {
                subarrays++;    // New subarray formed
                currentSum = num; // Reset current sum to current element

                // If subarrays exceed k, it means mid is too small
                if (subarrays > k)
                {
                    return false;
                }
            }
        }

        // If we can split into <= k subarrays successfully
        return true;
    }

    // Main method for user input and program execution
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array:");
        int n = sc.nextInt(); // Number of elements

        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter number of subarrays:");
        int k = sc.nextInt();

        // Optional input validation
        if (k > n)
        {
            System.out.println("Error: Number of subarrays cannot exceed array size.");
            return;
        }

        // Create object and compute result
        SplitArray sa = new SplitArray();
        int result = sa.splitArray(arr, k);

        // Output the minimized largest subarray sum
        System.out.println("The largest sum among the subarrays is: " + result);
    }
}
