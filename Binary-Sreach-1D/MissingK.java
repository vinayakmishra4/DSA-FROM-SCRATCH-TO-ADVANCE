import java.util.Scanner;

class MissingK
{
    // Approach 2: Using Binary Search to find the kth missing positive number
    public static int kthMissing(int[] arr, int k)
    {
        int left = 0;
        int right = arr.length - 1;

        // Perform binary search to find how many numbers are missing before a certain index
        while(left <= right)
        {
            int mid = (left + right) / 2;

            // Calculate how many numbers are missing up to index mid
            // Formula: arr[mid] - (mid + 1)
            int missing = arr[mid] - mid - 1;

            // If missing numbers till this point are less than k,
            // it means kth missing is on the right half
            if(missing < k)
            {
                left = mid + 1;
            }
            // Else, it is on the left half
            else
            {
                right = mid - 1;
            }
        }

        // After the loop, left is the number of elements <= kth missing number
        // Final answer = left + k
        return left + k;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input: size of the array
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();

        // Declare the array
        int[] arr = new int[n];

        // Input: array elements (must be strictly increasing positive integers)
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Input: value of k (which missing number to find)
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();

        // Call the function and store result
        int result = kthMissing(arr, k);

        // Output the result
        System.out.println("The " + k + "th missing number is: " + result);
    }
}
