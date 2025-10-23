// WAP to find Split Array Largest Sum using Binary Search

import java.util.Scanner;

class SplitArray
{
    public int splitArray(int[] arr, int k)
    {
        int left = 0;
        int right = 0;
        for (int num : arr)
        {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right)
        {
            int mid = left + (right - left) / 2;
            if (canSplit(arr, k, mid))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean canSplit(int[] arr, int k, int maxSum)
    {
        int currentSum = 0;
        int subarrays = 1;
        for (int num : arr)
        {
            currentSum += num;
            if (currentSum > maxSum)
            {
                subarrays++;
                currentSum = num;
                if (subarrays > k)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter number of subarrays:");
        int k = sc.nextInt();
        SplitArray sa = new SplitArray();
        int result = sa.splitArray(arr, k); 
        System.out.println("The largest sum among the subarrays is: " + result);
    }
}