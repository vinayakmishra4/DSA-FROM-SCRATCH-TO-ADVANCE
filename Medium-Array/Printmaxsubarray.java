import java.util.Arrays;
import java.util.Scanner;

public class Printmaxsubarray 
{
    public static int[] maxSubarraySum(int[] arr)
    {
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;
        int start = 0;
        int tempStart = 0;
        int end = 0;
        
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
            if (sum > maxsum) 
            {
                maxsum = sum;
                start = tempStart;
                end = i;
            }

            if (sum < 0)
            {
                sum = 0;
                tempStart = i + 1;
            }
        }

        // Extract the maximum subarray
        int[] maxSubarray = new int[end - start + 1];
        for (int i = start; i <= end; i++)
        {
            maxSubarray[i - start] = arr[i];
        }
        return maxSubarray;
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
       System.out.println("Print Maximum subarray is "+Arrays.toString(maxSubarraySum(arr)));
    }
    
}
