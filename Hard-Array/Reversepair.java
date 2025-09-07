import java.util.Scanner;

public class Reversepair
{
    /**
     * Counts the number of reverse pairs in the array.
     * A reverse pair is defined as indices (i, j) such that i < j and arr[i] > 2*arr[j].
     * This method initializes the recursive merge sort based counting.
     *
     * @param arr The input array
     * @return The number of reverse pairs in arr
     */
    public int countRevPairs(int[] arr)
    {
        // Start the modified merge sort on the entire array
        return mergeSort(arr,0,arr.length-1);
    }
    
    /**
     * Recursively sorts the array and counts reverse pairs using merge sort.
     * The array is divided into two halves, reverse pairs are counted in both halves and across them.
     *
     * @param arr The input array
     * @param start Starting index of the subarray
     * @param end Ending index of the subarray
     * @return Number of reverse pairs in arr[start...end]
     */
    private int mergeSort(int[] arr,int start,int end){
        int reversePairs = 0;
        if(start < end){
            // Find the middle index to split the array
            int mid = start + (end - start)/2;
            // Count reverse pairs in left half
            reversePairs += mergeSort(arr,start,mid);
            // Count reverse pairs in right half
            reversePairs += mergeSort(arr,mid+1,end);
            // Count reverse pairs where one element is in left and other in right half, and merge
            reversePairs += merge(arr,start,mid,end);
        }
        return reversePairs;
    }
    
    /**
     * Merges two sorted subarrays arr[start...mid] and arr[mid+1...end], and counts reverse pairs across them.
     * The key step is counting pairs (i, j) with i in left and j in right, such that arr[i] > 2*arr[j].
     *
     * @param arr The input array
     * @param start Starting index of the first subarray
     * @param mid Ending index of the first subarray
     * @param end Ending index of the second subarray
     * @return Number of reverse pairs across the two subarrays
     */
    private int merge(int[] arr,int start,int mid,int end){
        int count = 0, i = start, j = mid+1, k = 0;
        // Count reverse pairs such that arr[i] > 2*arr[j]
        // For each i in left, find all j in right such that arr[i] > 2*arr[j]
        // Since both halves are sorted, we can use two pointers
        while(i <= mid && j <= end){
            // The key condition: If arr[i] > 2*arr[j], then all elements from i to mid will also satisfy this, so add (mid - i + 1)
            if(arr[i] > 2* arr[j]){
                count += mid- i + 1;
                j++;
            }
            else{
                i++;
            }
        }
        // Now merge the two sorted halves into a temporary array
        int[] temp = new int[end-start+1];
        i = start; j = mid+1;
        while(i <= mid && j <= end){
            if(arr[i] <= arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // Copy any remaining elements from left half
        while(i <= mid){
            temp[k] = arr[i];
            i++;
            k++;
        }
        // Copy any remaining elements from right half
        while(j <= end){
            temp[k] = arr[j];
            j++;
            k++;
        }
        // Copy the sorted elements back to the original array
        for(k = start; k <= end; k++){
            arr[k] = temp[k-start];
        }
        return count;
    }

    public static void main(String[] args)
    {
        // Create scanner object for input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        // Read the size of the array from user
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array:");
        // Read the array elements from user
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();   
        }
        // Create an instance of Reversepair and call countRevPairs
        Reversepair obj = new Reversepair();
        int result = obj.countRevPairs(arr);
        // Output the result
        System.out.println("The number of reverse pairs in the array is: " + result);
    }
}
