import java.util.Scanner;

public class Quick_Sort 
{
     public static void BeforeSort(int arr[])
    {
      for(int num:arr)
      {
        System.out.print(num + " ");
      }
    }
    // Function to perform Quick Sort
    public static void quickSort(int[] arr, int low, int high) 
    {
        if (low < high) 
        {
            // Partition the array
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    // Function to partition the array
    public static int partition(int[] arr, int low, int high) 
    {
        int pivot = arr[high];  // pivot
        int i = low - 1;        // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                swap(arr,i,j);
            }
        }
        // swap arr[i+1] and arr[high] (or pivot)
        swap(arr, i + 1,high);
        return i + 1;
    }
    
    public static void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void AfterSort(int arr[])
    {
      for(int num:arr)
      {
        System.out.print(num + " ");
      }
    }
    // Main method to run and test the sort
    public static void main(String[] args) 
    {
      Scanner sc=new Scanner(System.in);
      System.err.println("Enter Size of array");
      int n=sc.nextInt();
      int[] arr = new int[n];
      System.out.println("Enter elements of array");
      for (int i = 0; i < n; i++)
      {
         arr[i] = sc.nextInt();
      }
      System.out.println("Array before sorting");
      BeforeSort(arr);
      System.out.println();
      quickSort(arr, 0, n - 1);
      System.out.println("Array after sorting");
      AfterSort(arr);

    }
}
