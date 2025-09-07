import java.util.Scanner;

public class CountInversion
{
    // Brute force approach (commented out):
    // Counts inversions by checking every pair (i, j) where i < j and arr[i] > arr[j].
    // Time complexity: O(n^2)
    // static int inversionCount(int arr[])
    // {
    //     int count = 0;
    //     for(int i=0; i<arr.length-1; i++)
    //     {
    //         for(int j=i+1; j<arr.length; j++)
    //         {
    //             if(arr[i] > arr[j])
    //             {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }
    
    // Optimized Approach using Merge Sort:
    // This function initiates the merge sort and returns the total inversion count.
    static int inversionCount(int arr[])
    {
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    // Recursive merge sort function that sorts the array and counts inversions.
    // It divides the array into two halves, counts inversions in each half,
    // and counts inversions during merge step.
    static int mergeSort(int arr[], int left, int right)
    {
        int mid, count = 0;
        if(right > left)
        {
            mid = (left + right) / 2;
            // Count inversions in left half
            count += mergeSort(arr, left, mid);
            // Count inversions in right half
            count += mergeSort(arr, mid + 1, right);
            // Count split inversions during merge
            count += merge(arr, left, mid + 1, right);
        }
        return count;
    }
    
    // Merge function merges two sorted subarrays and counts inversions caused by elements in right subarray
    // that are smaller than elements in left subarray.
    // Parameters:
    //   arr[] - original array containing two sorted subarrays
    //   left - starting index of left subarray
    //   mid - starting index of right subarray
    //   right - ending index of right subarray
    static int merge(int arr[], int left, int mid, int right)
    {
        int count = 0;
        // n1 is size of left subarray
        int n1 = mid - left;
        // n2 is size of right subarray
        int n2 = right - mid + 1;
        
        // Temporary arrays to hold the left and right subarrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        
        // Copy elements to left subarray L[]
        for(int i=0; i<n1; i++)
        {   
            L[i] = arr[left + i];
        }
        // Copy elements to right subarray R[]
        for(int j=0; j<n2; j++)
        {
            R[j] = arr[mid + j];
        }
        
        int i=0, j=0, k=left;
        // Merge the two sorted subarrays back into arr[]
        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j])
            {
                // If element in left subarray is smaller or equal,
                // no inversion, copy it to arr
                arr[k++] = L[i++];
            }
            else
            {
                // Element in right subarray is smaller than element in left subarray,
                // so all remaining elements in L[i..n1-1] form inversions with R[j]
                arr[k++] = R[j++];
                count += (n1 - i); // Count inversions
            }
        }
        // Copy remaining elements of left subarray if any
        while(i < n1)
        {
            arr[k++] = L[i++];
        }
        // Copy remaining elements of right subarray if any
        while(j < n2)
        {
            arr[k++] = R[j++];
        }
        return count;
    }        
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array:");
        for(int i=0; i<n; i++)
        {
            arr[i] = sc.nextInt();    
        }
        // Print the total number of inversions in the array
        System.out.println("The number of inversions are: " + inversionCount(arr));
    }
}
