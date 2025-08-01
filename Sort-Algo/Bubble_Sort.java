import java.util.Scanner;

public class Bubble_Sort
{
  // Method to display the array before sorting
  public static void BeforeSort(int arr[])
  {
     for(int num:arr)
     {
       System.out.print(num + " ");
     }
  }

  // Method to perform Bubble Sort on the array
  public static void Bubble(int arr[])
  {
     int n = arr.length;
     boolean swaped;
     
     // Outer loop to traverse through all elements
     for(int i = 0; i < n - 1; i++)
     {
        swaped = false;
        
        // Inner loop for pairwise comparison and swapping
        for(int j = 0; j < n - i - 1; j++)
        {
            // Swap if the current element is greater than the next
            if(arr[j] > arr[j + 1])
            {
              swap(arr, j, j + 1);
              swaped = true;
            }
        }
        
        // If no elements were swapped in inner loop, the array is sorted
        if(!swaped)
        {
          break;
        }
     }
  }

  // Method to display the array after sorting
  public static void AfterSort(int arr[])
  {
     for(int num:arr)
     {
       System.out.print(num + " ");
     }
  }

  // Utility method to swap two elements in the array
  public static void swap(int arr[], int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // Main method to take user input and perform sorting
  public static void main(String[] args)
  {
     Scanner sc = new Scanner(System.in);

     System.out.println("Enter the size of array");
     int n = sc.nextInt(); // Read array size
     int arr[] = new int[n]; // Declare array of given size

     System.out.println("Enter the number of elements in arr");
     for(int i = 0; i < n; i++)
     {
       arr[i] = sc.nextInt(); // Read array elements
     }

     System.out.println("Before sorting");
     BeforeSort(arr); // Display original array
     System.out.println();

     Bubble(arr); // Sort the array using Bubble Sort

     System.out.println("After sorting");
     AfterSort(arr); // Display sorted array
  } 
}
