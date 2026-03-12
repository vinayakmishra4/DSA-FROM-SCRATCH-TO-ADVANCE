// WAP to find out elements using linear sreach 

import java.util.Scanner;

class Linear 
{
   public static boolean  search(int arr[], int n, int x)
   {
       // Iterate through each element in the array
       for(int i=0;i<n;i++)
       {
           // Check if current element matches the target
           if(arr[i]==x)
           {
               // If match found, return true
               return true;
           }
       }
       // If no match found in the entire array, return false
       return false;
   }
   public static void main(String[] args)
   {
       Scanner sc=new Scanner(System.in);
       System.out.println("Size of Array");
       int n=sc.nextInt();
       int arr[]=new int[n];
       System.out.println("Enter the elements of array");
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       System.out.println("Elements");
       int x=sc.nextInt();
       if(search(arr, n, x)) 
       {
         System.out.println("Element is present in array");
       }
       else
       {
         System.out.println("Element is not present in array");
       }
   }    
}
