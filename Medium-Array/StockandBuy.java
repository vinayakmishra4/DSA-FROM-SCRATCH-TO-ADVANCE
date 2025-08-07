// WAP to buy and sell stocks 
import java.util.Scanner;
public class StockandBuy
{
    public static int stockBuySell(int arr[]) 
    {
        // for single transtation 
        // int min=Integer.MAX_VALUE;
        // int profit=0;
        // for(int i=0;i<arr.length;i++)
        // {
        //     if(arr[i]<min)
        //     {
        //         min=arr[i];
        //     }
        //     else
        //     {
        //         profit=Math.max(profit,arr[i]-min);
        //     }
        // }
        // return profit;
        // for multiple transaction
        int profit = 0;
        for (int i = 1; i < arr.length; i++)
        {
            if (arr[i] > arr[i - 1]) 
            {
                profit += arr[i] - arr[i - 1]; // Buy at i-1, sell at i
            }
        }
        return profit;
    }
    public static void main(String[] args)
    {
       // Create a Scanner object to take input from the user
       Scanner sc=new Scanner(System.in);
       System.out.println("Size of Array");
       // Read the size of the array
       int n=sc.nextInt();
       int arr[]=new int[n];
       System.out.println("Enter the elements of array");
       // Read the elements of the array
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       System.out.println("Maximum Profit is "+stockBuySell(arr));
    }
}
