// Program to print the largest elements (leaders) in the array first

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class LeaderArray
{
    // Method to find leader elements in the array
    static ArrayList<Integer> leaders(int arr[])
    {
        ArrayList<Integer> list = new ArrayList<Integer>(); // Stores leader elements
        int n = arr.length;
        
        // Start from the last element because the last element is always a leader
        int max = arr[n - 1];
        list.add(max); // Adding last element as the first leader
        
        // Traverse the array from second last to first
        for(int i = n - 2; i >= 0; i--)
        {
            // If the current element is greater than the maximum element found so far,
            // then it is also a leader
            if(arr[i] > max)
            {
                list.add(arr[i]); // Add leader to the list
                max = arr[i];     // Update max to the current element
            }
        }
        
        // Since we traversed from right to left, leaders are stored in reverse order
        Collections.reverse(list);
        return list; // Return the list of leaders in correct order
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        // Take array size as input
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        
        int arr[] = new int[n];
        
        // Take array elements as input
        System.out.println("Enter the elements of array:");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        
        // Call the leaders method to get leader elements
        ArrayList<Integer> list = leaders(arr);
        
        // Print the leaders
        System.out.println("Largest element(s) in the array first (leaders):");
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i) + " ");
        }
    }
}