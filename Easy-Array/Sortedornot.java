import java.util.Scanner;

class Sortedornot
{
    public static boolean isSorted(int[] arr)
    {

        // Traverse through all array elements
        for (int i = 0; i < arr.length - 1; i++)
        {
            // Check if there is any element smaller than its next element
            if(arr[i]>arr[i+1])
            {
                return false;
            }
            // If any element found smaller than its next element, then array is not sorted
            else
            {
               break;
            }
        }
        return true;
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
       if(isSorted(arr))
       {
         System.out.println("Array is sorted");
       }
       else
       {
         System.out.println("Array is not sorted");
       }
    }
}