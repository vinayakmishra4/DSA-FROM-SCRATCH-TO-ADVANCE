import java.util.Scanner;

class Selection_Sort
{
  // Method to print the array before sorting
  public static void BeforeSort(int arr[])
  {
     for(int num : arr)
     {
       System.out.print(num + " ");
     }
  }

  // Method to perform Selection Sort on the array
  public static void Selection(int arr[])
  {
    // Loop through each element in the array except the last one
    for(int i = 0; i < arr.length - 1; i++)
    {
      // Assume the current position i holds the minimum value
      int min = i;

      // Find the minimum element in the unsorted part of the array
      for(int j = i + 1; j < arr.length; j++)
      {
        if(arr[j] < arr[min])
        {
           // Update min if a smaller element is found
           min = j;
        }
      }

      // Swap the found minimum element with the element at index i
      swap(arr, i, min);
    }
  }

  // Method to print the array after sorting
  public static void AfterSort(int arr[])
  {
     for(int num : arr)
     {
       System.out.print(num + " ");
     }
  }

  // Helper method to swap two elements in the array at indices i and j
  public static void swap(int arr[], int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String []args)
  {
     Scanner sc = new Scanner(System.in);

     // Ask the user to enter the size of the array
     System.out.println("Enter the size of array");
     int n = sc.nextInt();

     int arr[] = new int[n];

     // Ask the user to enter the elements of the array
     System.out.println("Enter the number of elements in arr");
     for(int i = 0; i < n; i++)
     {
       arr[i] = sc.nextInt();
     }

     // Display the array before sorting
     System.out.println("Before sorting");
     BeforeSort(arr);
     System.out.println();

     // Perform selection sort on the array
     Selection(arr);

     // Display the array after sorting
     System.out.println("After sorting");
     AfterSort(arr);
  }
}