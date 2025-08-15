import java.util.Scanner;

public class CountSubarray
{
    // Method to count subarrays whose sum is equal to k
    public int cntSubarrays(int[] arr, int k)
    {
        int count = 0;          // Initialize counter for subarrays
        int n = arr.length;     // Get the size of the array

        // Outer loop to fix the starting point of subarray
        for (int i = 0; i < n; i++)
        {
            int sum = 0;        // Initialize sum for the current subarray

            // Inner loop to extend the subarray from index i to j
            for (int j = i; j < n; j++)
            {
                sum += arr[j];  // Add current element to sum

                // Check if the sum equals k
                if (sum == k)
                {
                    count++;    // Increment count if sum matches k
                }
            }
        }

        return count;           // Return total count of subarrays
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);  // Scanner to take user input

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Input target sum k
        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        // Create object and call method to count subarrays
        CountSubarray cs = new CountSubarray();
        int result = cs.cntSubarrays(arr, k);

        // Output the result
        System.out.println("Number of subarrays with sum " + k + " is: " + result);

        sc.close();  // Close scanner
    }
}