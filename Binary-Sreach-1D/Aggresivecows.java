/*
 * Problem: Aggressive Cows (Binary Search on Answer)
 * ---------------------------------------------
 * Given N stalls (positions) and K cows, the task is to place the cows in the stalls
 * such that the minimum distance between any two cows is maximized.
 * 
 * Approach:
 * 1. Sort the stall positions to arrange them in increasing order.
 * 2. Use Binary Search on the answer (distance between cows).
 *    - left = 1 (minimum possible distance)
 *    - right = max(stalls) - min(stalls) (maximum possible distance)
 * 3. Check for each mid distance if it's possible to place all K cows with at least mid distance apart.
 * 4. If it's possible, increase the distance (move left pointer to mid+1) to try for a larger distance.
 *    Otherwise, decrease the distance (move right pointer to mid-1).
 * 5. The largest valid distance found is the answer.
 * 
 * Example:
 * Stalls: [1, 2, 8, 4, 9], Cows: 3
 * Sorted Stalls: [1, 2, 4, 8, 9]
 * Answer: 3 (Cows at 1, 4, and 8)
 */
import java.util.Arrays;
import java.util.Scanner;

class Aggresivecows
{
    // This method returns the largest minimum distance between any two cows
    // using binary search on the distance between stalls.
    public int aggressiveCows(int[] stalls, int k)
    {
        int n = stalls.length;
        Arrays.sort(stalls);
        int left = 1;
        int right = stalls[n - 1] - stalls[0];
        int ans = -1;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (isPossible(stalls, n, k, mid))
            {
                ans = mid;
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return ans;
    }
    // Helper method to check if it is possible to place K cows
    // in the stalls with at least 'mid' distance apart.
    public boolean isPossible(int[] stalls, int n, int k, int mid)
    {
        int count = 1;
        int lastPos = stalls[0];
        for (int i = 1; i < n; i++)
        {
            if (stalls[i] - lastPos >= mid)
            {
                count++;
                if (count == k)
                {
                    return true;
                }
                lastPos = stalls[i];
            }
        }
        return false;
    }
    // Main method to take input from the user and print the result.
    // It reads number of stalls, stall positions, number of cows,
    // and prints the largest minimum distance.
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of stalls:");
        int n = sc.nextInt();
        int[] stalls = new int[n];
        System.out.println("Enter stall positions:");
        for (int i = 0; i < n; i++)
        {
            stalls[i] = sc.nextInt();
        }
        System.out.println("Enter number of cows:");
        int k = sc.nextInt();
        Aggresivecows obj = new Aggresivecows();
        int result = obj.aggressiveCows(stalls, k);
        System.out.println("The largest minimum distance is: " + result);
    }
}