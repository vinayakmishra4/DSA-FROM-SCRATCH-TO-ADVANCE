// WAP to find out elements using linear sreach 

import java.util.Scanner;

class Linear 
{
   public static boolean  search(int arr[], int n, int x)
   {
       for(int i=0;i<n;i++)
       {
        if(arr[i]==x)
        {
           return true;
        }
       }
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
