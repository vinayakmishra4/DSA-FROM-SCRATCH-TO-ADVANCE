
import java.util.Scanner;

// Write a program to find the Second largest element in the array
class SecondMaxout
{
  public static int SecondMax(int arr[])
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
      // Initialize second maximum element
      int secondmax=-1;
      // Traverse array elements
      for(int i=0;i<arr.length;i++)
      {
        // Check if current element is greater than secondmax and less than max
        if(arr[i]>secondmax && arr[i]!=max)
        {
            // Update secondmax
            secondmax=arr[i];
        }
      }
      return secondmax;
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
       System.out.println("SecondMaximum element of array is "+SecondMax(arr)); 
  }  
}
