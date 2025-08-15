import java.util.HashMap;
import java.util.Scanner;

public class CountSubarray {

    // Optimized method to count subarrays whose sum equals k using prefix sum
    public int cntSubarrays(int[] arr, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case: sum of 0 occurs once

        for (int num : arr) {
            prefixSum += num;

            // If (prefixSum - k) exists, there is a subarray ending here with sum = k
            count += map.getOrDefault(prefixSum - k, 0);

            // Add/update current prefix sum in the map
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum k: ");
        int k = sc.nextInt();

        CountSubarray cs = new CountSubarray();
        int result = cs.cntSubarrays(arr, k);

        System.out.println("Number of subarrays with sum " + k + " is: " + result);

        sc.close();
    }
}