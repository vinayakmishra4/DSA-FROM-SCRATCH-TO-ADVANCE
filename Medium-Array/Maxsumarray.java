
import java.util.Scanner;

class Maxsumarray
{
    public static int maxSubarraySum(int[] arr)
    {
        // Brute froce 
        //   int maxsum = Integer.MIN_VALUE;
        //   for (int i = 0; i < arr.length; i++)
        //   {
        //     for(int j=0;j<arr.length;j++)
        //     {
        //         int sum=0;
        //         for(int k=i;k<=j;k++)
        //         {
        //             sum+=arr[k];
        //         }
        //         maxsum=Math.max(sum,maxsum);
        //     }
        //   }
        //   return maxsum;
        // better approach
        // int maxsum = Integer.MIN_VALUE;
        // for (int i = 0; i < arr.length; i++)
        // {
        //   int sum=0;
        //   for(int j=0;j<arr.length;j++)
        //   {
        //      sum=sum+arr[j];
        //     maxsum=Math.max(sum,maxsum);
        //   }
        // }
        // return maxsum;
        // Optimal approach
        long sum=0;
        long maxsum=Long.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum>=maxsum)
            {
                maxsum=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        }
        return (int)maxsum;
    }
    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Size of the array");
       int n=sc.nextInt();
       int[] arr=new int[n];
       System.out.println("Enter the elements of the array");
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       System.out.println("Maximum sum of subarray is "+maxSubarraySum(arr));
    }

}