import java.util.HashMap; // Importing HashMap for storing prefix xor frequencies
import java.util.Scanner; // Importing Scanner for user input

/**
 * Class to find the number of subarrays with a given XOR value.
 */
class Subarraywithxor
{
    /**
     * This method returns the count of subarrays whose XOR is equal to k.
     *
     * @param arr The input array of integers.
     * @param k The target XOR value.
     * @return The number of subarrays with XOR equal to k.
     */
    public long subarrayXor(int arr[], int k)
    {
        long count = 0; // To store the final count of subarrays
        int xor = 0; // To store the prefix xor up to the current index
        // HashMap to store the frequency of prefix xors
        HashMap<Integer,Integer> map = new java.util.HashMap<>();
        // Initialize map with xor 0 having frequency 1, to handle subarrays starting from index 0
        map.put(0,1);
        // Iterate through the array
        for(int i = 0; i < arr.length; i++)
        {
            xor = xor ^ arr[i]; // Update the prefix xor up to index i
            int x = xor ^ k; // Find the prefix xor that would give xor=k for some subarray ending at i
            // If this prefix xor exists in the map, it means there are subarrays ending at i with xor=k
            if(map.containsKey(x))
            {
                count += map.get(x); // Add the number of such subarrays to the count
            }
            // Update the frequency of the current prefix xor in the map
            map.put(xor, map.getOrDefault(xor,0) + 1);
        }
        return count; // Return the total number of subarrays with xor=k
    }

    /**
     * Main method to take input from user and print the number of subarrays with given xor.
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // Scanner for reading input
        System.out.println("Enter the size of array");
        int n = sc.nextInt(); // Read size of array
        int arr[] = new int[n]; // Declare array of size n
        System.out.println("Enter the elements of array");
        // Read array elements from user
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k");
        int k = sc.nextInt(); // Read the desired xor value
        Subarraywithxor obj = new Subarraywithxor(); // Create an object of the class
        long result = obj.subarrayXor(arr, k); // Call the method to get result
        System.out.println("The number of subarrays with given xor is: " + result); // Print result
    }
}