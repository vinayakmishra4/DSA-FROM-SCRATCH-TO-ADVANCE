import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// WAP to find the longest subarray with sum k

class Subarrypart1 
{
    /**
     * This method finds the length of the longest subarray with sum equal to k.
     * 
     * Logic:
     * 1. We maintain a prefix sum (`sum`) while iterating through the array.
     * 2. A hashmap (`map`) stores the first index where each prefix sum appears.
     * 3. If the current prefix sum equals k, it means the subarray from index 0 to i sums to k.
     * 4. If (sum - k) exists in the map, it means there's a subarray ending at index i which sums to k.
     * 5. We take the maximum length found among all valid subarrays.
     */
    public int longestSubarray(int[] arr, int k) 
    {
        int maxLen = 0; // Initialize max length of subarray to 0
        int sum = 0; // Initialize prefix sum to 0
        Map<Integer, Integer> map = new HashMap<>(); // Map to store prefix sum and its earliest index
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Update prefix sum by adding current element
            
            if (sum == k) {
                maxLen = i + 1; // If prefix sum equals k, update max length to current index + 1
            }
            
            map.putIfAbsent(sum, i); // Store the first occurrence of this prefix sum if not already present
            
            if (map.containsKey(sum - k)) {
                // If (sum - k) exists, there is a subarray summing to k ending at i
                maxLen = Math.max(maxLen, i - map.get(sum - k)); // Update max length if longer subarray found
            }
        }
        
        return maxLen; // Return the maximum length found
    }
    
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Size of Array one");
       int n=sc.nextInt();
       int a[]=new int[n];
       System.out.println("Enter the elements of array");
       for(int i=0;i<n;i++)
       {
        a[i]=sc.nextInt();
       }
       
       System.out.println("Enter the value of k");
       int k = sc.nextInt();

       Subarrypart1 obj = new Subarrypart1();
       int result = obj.longestSubarray(a, k);
       System.out.println("Length of longest subarray with sum " + k + " is: " + result);
    }
}
