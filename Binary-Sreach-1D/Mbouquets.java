import java.util.Scanner;

// WAP to find the minimum number of days required to make 'm' bouquets 
// where each bouquet needs 'k' consecutive bloomed flowers
class Mbouquets
{
    // Function to calculate minimum days to make m bouquets
    public static int minDaysBloom(int[] arr, int k, int m)
    {
        int n = arr.length;

        // Case: Not enough flowers available to make m bouquets
        if (n < m * k) {
            return -1; // impossible case
        }

        int low = Integer.MAX_VALUE; // earliest bloom day
        int high = Integer.MIN_VALUE; // latest bloom day

        // Find minimum and maximum bloom day in the array
        for (int day : arr) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1; // store final answer (minimum days)

        // Apply Binary Search between min and max bloom days
        while (low <= high) {
            int mid = low + (high - low) / 2; // mid = possible day

            // Check if we can make m bouquets by 'mid' days
            if (canMakeBouquets(arr, mid, k, m)) {
                ans = mid;      // possible answer found
                high = mid - 1; // try to find smaller number of days
            } else {
                low = mid + 1;  // need more days
            }
        }

        return ans; // minimum days found or -1 if not possible
    }

    // Helper function: check if m bouquets can be made by a given 'day'
    public static boolean canMakeBouquets(int[] arr, int day, int k, int m) {
        int count = 0;      // counts consecutive bloomed flowers
        int bouquets = 0;   // total bouquets made so far

        for (int bloom : arr) {
            if (bloom <= day) { // flower has bloomed
                count++;
                if (count == k) { // enough flowers to make one bouquet
                    bouquets++;
                    count = 0; // reset count for next bouquet
                }
            } else {
                count = 0; // reset if flower not bloomed yet
            }

            // If we already have enough bouquets, return true
            if (bouquets >= m) return true;
        }

        // If loop finishes without enough bouquets, return false
        return false;
    }

    // Main method to take input and display result
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input: number of flowers
        System.out.println("Enter the number of flowers: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input: bloom days of each flower
        System.out.println("Enter the bloom days of flowers: ");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Input: flowers per bouquet
        System.out.println("Enter the number of flowers per bouquet (k): ");
        int k = sc.nextInt();

        // Input: number of bouquets needed
        System.out.println("Enter the number of bouquets needed (m): ");
        int m = sc.nextInt();

        // Compute result using binary search approach
        int result = minDaysBloom(arr, k, m);

        // Output result
        if(result != -1)
        {
            System.out.println("Minimum days to make " + m + " bouquets: " + result);
        }
        else
        {
            System.out.println("Not enough flowers to make " + m + " bouquets.");
        }
    }
}
