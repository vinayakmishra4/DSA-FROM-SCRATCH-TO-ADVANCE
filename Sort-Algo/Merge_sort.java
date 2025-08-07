// Java program to implement Merge Sort algorithm
import java.util.Scanner;

class Merge_sort
{
    // Method to print the array before sorting
    public static void BeforeSort(int arr[])
    {
      for(int num:arr)
      {
        System.out.print(num + " ");
      }
    }
    // Method to merge two sorted halves of the array
    public static void Merge(int arr[], int start, int mid, int end)
    {
        // Temporary array to store merged sorted values
        int i = start;
        int j = mid + 1;
        int k = 0;
        int arr2[] = new int[end - start + 1];

        // Merge elements from both halves in sorted order
        while (i <= mid && j <= end)
        {
            if (arr[i] <= arr[j])
            {
                arr2[k] = arr[i];
                i++;
                k++;
            }
            else
            {
                arr2[k] = arr[j];
                j++;
                k++;
            }
        }

        // Copy remaining elements from the left half (if any)
        while (i <= mid)
        {
            arr2[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining elements from the right half (if any)
        while (j <= end)
        {
            arr2[k] = arr[j];
            j++;
            k++;
        }
        // Copy the sorted elements back into the original array
        for(int l = 0; l < arr2.length; l++)
        {
            arr[start + l] = arr2[l];
        }
    }

    // Recursive method to divide the array and call merge
    public static void mergeSort(int arr[], int start, int end)
    {
        if (start < end)
        {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            Merge(arr, start, mid, end);
        }
    }
    // Method to print the array after sorting
    public static void AfterSort(int arr[])
    {
      for(int num:arr)
      {
        System.out.print(num + " ");
      }
    }

    public static void main(String[] args)
    {
       Scanner sc=new Scanner(System.in);
       // Take input from the user for array size and elements
       System.out.println("Enter the size of array");
       int n=sc.nextInt();
       int arr[]=new int[n];
       System.out.println("Enter the elements of array");
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       // Display array before sorting
       System.out.println("Array before sorting");
       BeforeSort(arr);
       System.out.println();
       // Perform merge sort on the array
       mergeSort(arr, 0, n - 1);
       // Display array after sorting
       System.out.println("Array after sorting");
       AfterSort(arr);
    }  
}
