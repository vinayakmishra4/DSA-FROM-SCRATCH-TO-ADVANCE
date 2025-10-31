// WAP to find out the painter allocation problem using binary search
import java.util.Scanner;


class Painterallocation
{
    public int minTime(int[] arr, int k)
    {
        int max = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++)
        {
            sum += arr[i];
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        int start = max;
        int end = sum;
        int result = -1;
        while(start<=end)
        {
            int mid = start + (end - start)/2;
            if(isPossible(arr, k, mid))
            {
                result = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }
        return result;   
    }
    public boolean isPossible(int[] arr, int k, int mid)
    {
        int painterCount = 1;
        int timeSum = 0;
        for(int i=0;i<arr.length;i++)
        {
            timeSum += arr[i];
            if(timeSum>mid)
            {
                painterCount++;
                timeSum = arr[i];
                if(painterCount>k)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String []args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of boards:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the lengths of the boards:");
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of painters:");
        int k = sc.nextInt();
        Painterallocation pa = new Painterallocation();
        int result = pa.minTime(arr, k);
        System.out.println("The minimum time to paint all boards is: " + result);
    }   
}