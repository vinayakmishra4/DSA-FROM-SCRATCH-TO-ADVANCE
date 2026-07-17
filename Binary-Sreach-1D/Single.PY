// WAP to find out the single element in a sorted array where every element appears twice except for one.

import  java.util.*;

class Single
{
    public static int single(int[] arr)
    {
        int n=arr.length;
        int low=0;
        int high=n-2;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==arr[mid^1])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return arr[low]; 
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int result=single(arr);
        System.out.println("The single element in the array is: "+result);
        sc.close();    
    }
}