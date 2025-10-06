// WAP to find the minimum capacity of ship to ship all packages within D days.

import java.util.Scanner;

class Shippment
{
    // Using Binary Search
    public static int leastWeightCapacity(int[] arr, int n, int d)
    {
        int left = 0, right = 0;
        for(int i=0; i<n; i++)
        {
            left = Math.max(left, arr[i]);
            right += arr[i];
        }
        int ans = right;
        while(left <= right)
        {
            int mid = left + (right - left) / 2;
            int days = 1, currentWeight = 0;
            for(int i=0; i<n; i++)
            {
                if(currentWeight + arr[i] > mid)
                {
                    days++;
                    currentWeight = arr[i];
                }
                else
                {
                    currentWeight += arr[i];
                }
            }
            if(days <= d)
            {
                ans = mid;
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of packages: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the weights of packages: ");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of days: ");
        int d = sc.nextInt();
        System.out.println("The least weight capacity of ship to ship all packages within " + d + " days is: " + leastWeightCapacity(arr, n, d));
        sc.close();    
    }   
}
