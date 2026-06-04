import java.util.Scanner;

public class Maxproduct
{
   public static int maxProduct(int[] arr)
   {
        //brute force approach
        // int n=arr.length;
        // int max=arr[0];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=i;j<n;j++)
        //     {
        //         int product=1;
        //         for(int k=i;k<=j;k++)
        //         {
        //             product=product*arr[k];
        //         }
        //         if(product>max)
        //         {
        //             max=product;
        //         }
        //     }
        // }
        // return max;
        //optimal approach
        int n=arr.length;
        int max=arr[0];
        int min=arr[0];
        int result=arr[0];
        for(int i=1;i<n;i++)
        {
            if(arr[i]<0)
            {
                int temp=max;
                max=min;
                min=temp;      
           }
           max=Math.max(arr[i],max*arr[i]);
           min=Math.min(arr[i],min*arr[i]);
           result=Math.max(result,max);
        } 
        return result;
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
        int maxProduct=maxProduct(arr);
        System.out.println("The maximum product subarray is: "+maxProduct);    
    }   
}
