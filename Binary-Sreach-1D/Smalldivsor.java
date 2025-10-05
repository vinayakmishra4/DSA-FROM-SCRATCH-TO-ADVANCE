import java.util.Scanner;

/*
 * This program finds the smallest divisor of an array such that the sum of the 
 * division results (rounded up) is less than or equal to a given integer k.
 * It uses a binary search approach to efficiently determine the smallest divisor.
 * 
 * The problem can be thought of as minimizing the divisor to keep the sum of 
 * ceil(arr[i]/divisor) for all elements within the limit k.
 */

class Smalldivsor
{
    // Function to find the smallest divisor such that the sum of division results <= k
    public static int smallestDivisor(int[] arr, int k)
    {    
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;

        // Find the maximum element in the array to set the upper bound of binary search
        for(int i=0; i<n; i++)
        {
            maxi = Math.max(maxi, arr[i]);
        }

        // If the number of elements is greater than k, it's impossible to get sum <= k
        if(n > k) return -1;

        int low = 1;       // Minimum possible divisor
        int high = maxi;   // Maximum possible divisor (max element in array)
        
        // Binary search to find the smallest divisor
        while(low <= high)
        {
            int mid = (low + high) / 2;    
            int s = totalSum(arr, mid);  // Calculate sum of ceil(arr[i]/mid) for all i

            if(s <= k)
            {
                // If sum is within limit k, try to find smaller divisor on left side
                high = mid - 1;
            }
            else
            {
                // If sum exceeds k, increase divisor to reduce sum
                low = mid + 1;
            }
        }
        // low is the smallest divisor found that satisfies the condition
        return low;
    }
    
    // Helper function to calculate the sum of ceil(arr[i]/div) for all elements
    public static int totalSum(int[] arr, int div)
    {
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
        {
            // Use Math.ceil to round up the division result to the nearest integer
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements of the array
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Input the value of k
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();

        // Calculate the smallest divisor using the function
        int ans = smallestDivisor(arr, k);

        // Output the result
        System.out.println("The smallest divisor is: " + ans);
    }
}