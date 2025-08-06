import java.util.Scanner; // Import Scanner class for user input

// Main class named Insertion_Sort
public class Insertion_Sort 
{
    // Method to print array before sorting
    public static void BeforeSort(int arr[])
    {
        // Enhanced for loop to print all elements of the array
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
    }

    // Method that performs insertion sort on the array
    public static void Insertion(int arr[])
    {
        // Start from the second element (index 1), as a single element is already "sorted"
        for(int i = 1; i < arr.length; i++)
        {
            int temp = arr[i]; // Take the current element in temp
            int j = i - 1;     // Set j to the index before i

            // Move elements of arr[0..i-1], that are greater than temp, one position ahead
            while(j >= 0 && arr[j] > temp)
            {
                arr[j + 1] = arr[j]; // Shift the larger element one position to the right
                j--;                 // Move to the previous index
            }

            arr[j + 1] = temp; // Place temp at its correct position
        }
    }

    // Method to print array after sorting
    public static void AfterSort(int arr[])
    {
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
    }

    // Main method - entry point of the program
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // Create Scanner object to read input

        // Ask user to enter the size of the array
        System.out.println("Enter the size of array");
        int n = sc.nextInt(); // Read size from user

        int arr[] = new int[n]; // Create array of size n

        // Ask user to enter array elements
        System.out.println("Enter the number of elements in arr");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt(); // Read each element
        }

        // Display array before sorting
        System.out.println("Before sorting");
        BeforeSort(arr);

        System.out.println(); // Move to next line

        // Call method to sort the array using insertion sort
        Insertion(arr);

        // Display array after sorting
        System.out.println("After sorting");
        AfterSort(arr);
    }
}
