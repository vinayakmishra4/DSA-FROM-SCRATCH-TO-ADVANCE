// WAP to find the Largest element of Array
import java.util.Scanner;

class Maxout
{
   public static int Maximum(int arr[])
   {
       // Initialize maximum element
      int max=-1;
      // Traverse array elements
      for(int i=0;i<arr.length;i++)
      {
        // Check if current element is greater than max
        if(arr[i]>max)
        {
            // Update max
            max=arr[i];
        }
      }
      // Return max element of array
      return max;
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
        System.out.println("Maximum element of array is "+Maximum(arr));
   }    
}
