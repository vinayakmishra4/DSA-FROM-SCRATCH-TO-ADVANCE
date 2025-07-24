import java.util.Scanner;

class RotateLeft
{
   public static int[] rotateLeft(int[] arr, int right)
   {
      // Create a temp array to hold the last 'right' elements
      int temp[] = new int[right];
      int n = arr.length;
      for(int i = 0; i < right; i++)
      {
         temp[i] = arr[n - right + i];
      }
      // Shift the remaining elements of arr to the right by 'right' positions
      for(int i = n - right - 1; i >= 0; i--)
      {
         arr[i + right] = arr[i];
      }
      // Copy the temp elements to the beginning of arr
      for(int i = 0; i < right; i++)
      {
         arr[i] = temp[i];
      }
      return arr;
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
       System.out.println("Enter the number of positions to rotate");
       int right=sc.nextInt();
       int result[]=rotateLeft(arr,right);
       System.out.println("Array after rotation");
       for(int i=0;i<n;i++)
       {
        System.out.print(result[i]+" ");
       }
   }    
}
