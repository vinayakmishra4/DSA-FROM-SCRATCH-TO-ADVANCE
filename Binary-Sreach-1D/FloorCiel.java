// Binary Search in 1D Array to find Floor and Ceiling of a number
//
// Floor: The floor of a number x in a sorted array is the greatest element in the array
//        which is less than or equal to x. If such element doesn't exist, floor is undefined (here, returned as -1).
// Ceiling: The ceiling of a number x in a sorted array is the smallest element in the array
//          which is greater than or equal to x. If such element doesn't exist, ceiling is undefined (here, returned as -1).

import java.util.Scanner;

public class FloorCiel
{
    /**
     * Finds the floor index of x in a sorted array.
     * Floor: Greatest element <= x.
     * Returns index of floor, or -1 if no such element exists.
     * 
     * @param arr Sorted input array
     * @param x   Value to find floor for
     * @return    Index of floor element, or -1 if not found
     */
    public static int findFloor(int[] arr, int x)
    {
        int n = arr.length;
        int low = 0;             // Start index of search range
        int high = n - 1;        // End index of search range
        int floor = -1;          // Store index of floor (initialized as not found)
        // Binary search to find floor
        while (low <= high)
        {
            // mid is the middle index between low and high
            int mid = (low + high) / 2;
            // If middle element is less than or equal to x, it could be the floor
            if (arr[mid] <= x)
            {
                floor = mid;     // Update floor index to current mid
                low = mid + 1;   // Move right to search for a closer (greater) floor
            }
            else
            {
                high = mid - 1;  // Move left to search for smaller elements
            }
            // At each step, low and high are updated to narrow the search space
        }
        return floor;
    }

    /**
     * Finds the ceiling index of x in a sorted array.
     * Ceiling: Smallest element >= x.
     * Returns index of ceiling, or -1 if no such element exists.
     *
     * @param arr Sorted input array
     * @param x   Value to find ceiling for
     * @return    Index of ceiling element, or -1 if not found
     */
    public static int findCeil(int[] arr, int x)
    {
        int n = arr.length;
        int low = 0;             // Start index of search range
        int high = n - 1;        // End index of search range
        int ceil = -1;           // Store index of ceiling (initialized as not found)
        // Binary search to find ceiling
        while (low <= high)
        {
            // mid is the middle index between low and high
            int mid = (low + high) / 2;
            // If middle element is greater than or equal to x, it could be the ceiling
            if (arr[mid] >= x)
            {
                ceil = mid;      // Update ceiling index to current mid
                high = mid - 1;  // Move left to search for a closer (smaller) ceiling
            }
            else
            {
                low = mid + 1;   // Move right to search for greater elements
            }
            // At each step, low and high are updated to narrow the search space
        }
        return ceil;
    }

    /**
     * Main method to demonstrate finding floor and ceiling in a sorted array.
     * Steps:
     * 1. Input: Read array size, elements (sorted), and the number x from user.
     * 2. Process: Use binary search to find floor and ceiling indices for x.
     * 3. Output: Print the floor and ceiling values if they exist, else indicate absence.
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Step 1: Input
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array in sorted order: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt(); // Read array elements
        }
        System.out.println("Enter the element to find floor and ceiling: ");
        int x = sc.nextInt();      // Read the value to find floor/ceiling for

        // Step 2: Process (find floor and ceiling indices)
        int floorIndex = findFloor(arr, x);
        int ceilIndex = findCeil(arr, x);

        // Step 3: Output (print results)
        if (floorIndex != -1)
        {
            System.out.println("Floor of " + x + " is: " + arr[floorIndex]);
        }
        else
        {
            System.out.println("Floor doesn't exist");
        }
        if (ceilIndex != -1)
        {
            System.out.println("Ceiling of " + x + " is: " + arr[ceilIndex]);
        }
        else
        {
            System.out.println("Ceiling doesn't exist");
        }
    }
}
