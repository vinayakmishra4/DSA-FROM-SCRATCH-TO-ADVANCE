import java.util.Scanner;

// WAP to find the Kth element in a two sorted array using binary search
public class Kthelement
{
    // Method to find the Kth element in the merged sorted array
    public int kthElement(int a[], int b[], int k)
    {
        int n1=a.length;  // Length of first array
        int n2=b.length;  // Length of second array
        
        // Ensure that the first array is the smaller one to optimize the binary search
        // This reduces the search space since we do binary search on the smaller array
        if(n1>n2)
        {
            return kthElement(b,a,k);
        }
        
        // low and high represent the range of elements we can pick from array 'a'
        // low is the minimum number of elements we can pick from 'a' to reach k elements total
        // high is the maximum number of elements we can pick from 'a' which is either k or size of 'a'
        int low=Math.max(0,k-n2);
        int high=Math.min(k,n1);
        
        // Binary search to find the right partition of arrays a and b
        while(low<=high)
        {
            // cut1 is the number of elements taken from array 'a'
            // Using bitwise shift (divide by 2) to find mid point
            int cut1=(low+high)>>1;
            
            // cut2 is the remaining elements needed from array 'b' to make total k elements
            int cut2=k-cut1;
            
            // l1 is the left element just before the partition in 'a'
            // If cut1 is 0, it means no elements are taken from 'a', so assign MIN_VALUE to handle edge case
            int l1=(cut1==0)?Integer.MIN_VALUE:a[cut1-1];
            
            // l2 is the left element just before the partition in 'b'
            // If cut2 is 0, no elements taken from 'b', assign MIN_VALUE to handle edge case
            int l2=(cut2==0)?Integer.MIN_VALUE:b[cut2-1];
            
            // r1 is the right element just after the partition in 'a'
            // If cut1 equals size of 'a', no elements on right side, assign MAX_VALUE to handle edge case
            int r1=(cut1==n1)?Integer.MAX_VALUE:a[cut1];
            
            // r2 is the right element just after the partition in 'b'
            // If cut2 equals size of 'b', no elements on right side, assign MAX_VALUE to handle edge case
            int r2=(cut2==n2)?Integer.MAX_VALUE:b[cut2];
            
            // Check if current partition is valid:
            // All elements on left side of merged array should be less than or equal to all elements on right side
            if(l1<=r2 && l2<=r1)
            {
                // The Kth element is the maximum of left partition elements, since left partition contains k elements
                return Math.max(l1,l2); 
            }
            // If l1 is greater than r2, it means we have taken too many elements from 'a'
            // So we need to move the partition cut1 to the left (reduce high)
            else if(l1>r2)
            {
                high=cut1-1;
            }
            else
            {
                // Otherwise, we have taken too few elements from 'a', move partition to the right (increase low)
                low=cut1+1;
            }
        }
        // If no valid partition found (should not happen with valid inputs), return 1 as fallback
        return 1;
    }
    
    public static void main(String[] args)
    {
      Scanner sc=new Scanner(System.in);
      
      // Taking input for first array
      System.out.println("Enter size of first array:");
      int n1=sc.nextInt();
      int[] a=new int[n1];
      System.out.println("Enter elements of first array:"); 
      for(int i=0;i<n1;i++)
      {
          a[i]=sc.nextInt();
      }
      
      // Taking input for second array
      System.out.println("Enter size of second array:");
      int n2=sc.nextInt();
      int[] b=new int[n2];
      System.out.println("Enter elements of second array:");
      for(int i=0;i<n2;i++)
      {
          b[i]=sc.nextInt();
      }
      
      // Taking input for k (the position of element to find in merged sorted array)
      System.out.println("Enter the value of k:");
      int k=sc.nextInt();
      
      Kthelement obj=new Kthelement();
      
      // Calling the method to find the Kth element
      int result=obj.kthElement(a,b,k);
      
      // Printing the result
      System.out.println("The Kth element in the merged sorted array is: "+result);   
    }
}
