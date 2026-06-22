// WAP to find the upper bound in array using binary search
import java.util.Scanner;
public class UpperBound
{
    // Function to find the upper bound index using binary search
    public static int upperBound(int[] arr, int target)
    {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int ans=n; // Default to arr.length if no suitable element is found
        while (low<=high)
        {
            int mid=(low+high)/2;
            // If current element is greater than target, it may be an upper bound
            if(arr[mid]>target)
            {
                ans=mid;         // Update answer
                high=mid-1;    // Look for a smaller index on the left
            }
            else
            {
                low=mid+1;     // Target is greater or equal, search right half
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        // Input array size
        System.out.print("Enter the size of the array: ");
        int n=sc.nextInt();
        // Input array elements (assume sorted)
        int[] arr=new int[n];
        System.out.print("Enter "+n+" sorted elements: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        // Input target value to find upper bound
        System.out.print("Enter the target value: ");
        int target=sc.nextInt();
        // Call upperBound function
        int ubIndex=upperBound(arr,target);
        // Display the result
        if(ubIndex<n)
        {
            System.out.println("Upper bound of "+target+" is at index: "+ubIndex+" (Element: "+arr[ubIndex]+")");
        }
        else
        {
            System.out.println("No upper bound found. All elements are less than or equal to "+target);
        }
    }    
}
