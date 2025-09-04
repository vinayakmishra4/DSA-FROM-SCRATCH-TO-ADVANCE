import java.util.Scanner;

public class CountInversion
{
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
    // Optimized Approach using Merge Sort
    static int inversionCount(int arr[])
    {
        return mergeSort(arr, 0, arr.length - 1);
    }
    static int mergeSort(int arr[], int left, int right)
    {
        int mid, count = 0;
        if(right > left)
        {
            mid = (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid + 1, right);
        }
        return count;
    }
    static int merge(int arr[], int left, int mid, int right)
    {
        int count = 0;
        int n1 = mid - left;
        int n2 = right - mid + 1;
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0; i<n1; i++)
        {   
            L[i] = arr[left + i];
        }
        for(int j=0; j<n2; j++)
        {
            R[j] = arr[mid + j];
        }
        int i=0, j=0, k=left;
        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j])
            {
                arr[k++] = L[i++];
            }
            else
            {
                arr[k++] = R[j++];
                count += (n1 - i); // Count inversions
            }
        }
        while(i < n1)
        {
            arr[k++] = L[i++];
        }
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
        System.out.println("The number of inversions are: " + inversionCount(arr));
    }
}
