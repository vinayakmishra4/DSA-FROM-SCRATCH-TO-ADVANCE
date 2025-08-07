// WAP to rearrange the element of array with positive and negative numbers
import java.util.ArrayList;
import java.util.Scanner;

public class RearrangeArray
{
    // Function to print the array before rearranging
    public static void before(ArrayList arr)
    {
        // Print each element separated by space
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+" ");
        }
    }

    // Function to rearrange the array such that positive and negative numbers are placed alternately
    public static void rearrange(ArrayList<Integer> arr)
    { 
        // Create two ArrayLists to store positive and negative numbers separately
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> n = new ArrayList<>();
        
        // Separate the elements into positive and negative lists
        for(int i : arr){
            if(i >= 0){
                p.add(i); // Add positive number
            }
            else{
                n.add(i); // Add negative number
            }
        }
        // Clear the original array to refill in rearranged order
        arr.clear();
        
        int i = 0;
        // Add positive and negative numbers alternately as long as both lists have elements
        for(; i < p.size() && i < n.size(); i++){
            arr.add(p.get(i)); // Add next positive
            arr.add(n.get(i)); // Add next negative
        }
        // If any positive numbers are left, add them to the end
        while(i < p.size()){
            arr.add(p.get(i));
            i++;
        }
        // If any negative numbers are left, add them to the end
        while(i < n.size()){
            arr.add(n.get(i));
            i++;
        }
    }

    // Function to print the array after rearranging
    public static void after(ArrayList arr)
    {
        // Print each element separated by space
        for(int i=0;i<arr.size();i++)
        {
            System.out.print(arr.get(i)+" ");
        }
    }

    // Main method to execute the program
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt(); // Read the size of the array
        int list[] = new int[n];
        System.out.println("Enter the elements of array:");
        // Read the array elements from the user
        for(int i = 0; i < n; i++)
        {
            list[i] = sc.nextInt();
        }
        // Convert the array to an ArrayList for easier manipulation
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < list.length; i++)
        {
            arr.add(list[i]);
        }
        // Display the array before rearranging
        System.out.println("Before Rearranging:");
        before(arr);
        System.out.println();
        // Rearrange the array
        rearrange(arr);
        // Display the array after rearranging
        System.out.println("After Rearranging:");
        after(arr);
    }
}
