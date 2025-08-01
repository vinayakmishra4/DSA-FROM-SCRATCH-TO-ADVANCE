// WAP to find the two elements in array that add up to a given sum is equal to target.

// This program checks whether any two numbers in an array sum up to a given target value.
import java.util.Scanner;

class Twosum
{
    // Method to check if there exists a pair of elements in the array whose sum equals the target.
    boolean twoSum(int arr[], int target) 
    {
        // Loop through each element in the array
        for(int i=0;i<arr.length;i++)
        {
            // Loop through the rest of the array to find a pair
            for(int j=i+1;j<arr.length;j++)
            {
                // Check if the sum of the current pair equals the target
                if(arr[i]+arr[j]==target)
                {
                    return true;
                }
            }
        }
        return false;
    }
    // Main method to take user input and invoke the twoSum method
    public static void main(String[] args)
    {
        // Create a Scanner object to take input from the user
       Scanner sc=new Scanner(System.in);
       System.out.println("Size of Array");
       // Read the size of the array
       int n=sc.nextInt();
       int arr[]=new int[n];
       System.out.println("Enter the elements of array");
       // Read the elements of the array
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       System.out.println("Enter the target sum");
       // Read the target sum
       int target=sc.nextInt();
       // Create an instance of Twosum class
       Twosum ts=new Twosum();
       // Check if there are two elements that add up to the target
       if(ts.twoSum(arr,target))
       {
        System.out.println("Two elements in array that add up to a given sum is equal to target");
       }
       else
       {
        System.out.println("No two elements in array that add up to a given sum is equal to target");
        }
    }
}