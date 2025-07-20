
import java.util.Scanner;

class Merge_sort
{
    public static void BeforeSort(int arr[])
    {
      for(int num:arr)
      {
        System.out.print(num + " ");
      }
    }
    public static void Merge(int arr[], int start, int mid, int end)
    {
        int i = start;
        int j = mid + 1;
        int k = 0;
        int arr2[] = new int[end - start + 1];

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

        while (i <= mid)
        {
            arr2[k] = arr[i];
            i++;
            k++;
        }

        while (j <= end)
        {
            arr2[k] = arr[j];
            j++;
            k++;
        }
        for(int l = 0; l < arr2.length; l++)
        {
            arr[start + l] = arr2[l];
        }
    }

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
       System.out.println("Enter the size of array");
       int n=sc.nextInt();
       int arr[]=new int[n];
       System.out.println("Enter the elements of array");
       for(int i=0;i<n;i++)
       {
        arr[i]=sc.nextInt();
       }
       System.out.println("Array before sorting");
       BeforeSort(arr);
       System.out.println();
       mergeSort(arr, 0, n - 1);
       System.out.println("Array after sorting");
       AfterSort(arr);
    }  
}
