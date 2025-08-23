import java.util.HashMap;
import java.util.Scanner;

class Largestsum0
{
    /**
     * This class contains a method to find the length of the largest subarray 
     * with sum equal to 0 in a given integer array.
     */
    public static int maxLength(int arr[])
    {
        /**
         * Uses a HashMap to store prefix sums and their first occurrence index.
         * For each element, maintain the running sum.
         * If the sum is zero, the subarray from 0 to i has sum 0.
         * If the sum has been seen before, the subarray between previous index+1 and i has sum 0.
         * Keep track of the maximum such length.
         */
        HashMap<Integer, Integer> map = new java.util.HashMap<>();
        int maxLen = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                // Subarray from 0 to i has sum 0
                maxLen = i + 1;
            }
            if (map.containsKey(sum)) {
                // Subarray from map.get(sum)+1 to i has sum 0
                int prevIndex = map.get(sum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store first occurrence of this sum
                map.put(sum, i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        // Prompt user to enter the size of the array
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        // Prompt user to enter the elements of the array
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();    
        }
        // Call maxLength method to find the largest subarray with sum zero
        int result=maxLength(arr);
        // Print the result
        System.out.println("The length of largest subarray with sum 0 is: "+result);
    }
}