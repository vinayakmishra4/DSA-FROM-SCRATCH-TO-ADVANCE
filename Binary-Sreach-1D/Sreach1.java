import java.util.Scanner;

// WAP to find the target value in array using Binary Search
class Search1
{

    // Binary Search method
    public static int search(int[] arr, int key)
    {
        int st = 0, end = arr.length - 1;
        while (st <= end)
        {
            int mid = st + (end - st) / 2;
            if (arr[mid] == key)
            {
                return mid;
            }
            // Right half is sorted
            if (arr[mid] <= arr[end])
            {
                if (key > arr[mid] && key <= arr[end])
                {
                    st = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            } 
            // Left half is sorted
            else
            {
                if (key >= arr[st] && key < arr[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    st = mid + 1;
                }
            }
        }
        return -1;
    }
    // Main method with user input
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // Step 1: Take array size input
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Step 2: Take sorted array input
        System.out.println("Enter " + size + " sorted elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 3: Take the key (target) input
        System.out.print("Enter the value to search: ");
        int key = sc.nextInt();

        // Step 4: Call the search method
        int result = search(arr, key);

        // Step 5: Output the result
        if (result != -1) {
            System.out.println("Key found at index: " + result);
        } else {
            System.out.println("Key not found in the array.");
        }

        sc.close(); // Close the scanner
    }
}