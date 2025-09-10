// WAP to find the lower bound in array using binary sreach
import java.util.Scanner;

public class Lowerbound {

    // Function to find the lower bound index using binary search
    public static int lowerBound(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length; // Default to arr.length if no suitable element is found

        while (low <= high)
        {
            int mid = (low + high) / 2;
            // If current element is greater than or equal to target, it may be a lower bound
            if (arr[mid] >= target)
            {
                ans = mid;         // Update answer
                high = mid - 1;    // Look for a smaller index on the left
            }
            else
            {
                low = mid + 1;     // Target is greater, search right half
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        // Input array elements (assume sorted)
        int[] arr = new int[n];
        System.out.print("Enter " + n + " sorted elements: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Input target value to find lower bound
        System.out.print("Enter the target value: ");
        int target = sc.nextInt();

        // Call lowerBound function
        int lbIndex = lowerBound(arr, target);

        // Display the result
        if (lbIndex < n)
        {
            System.out.println("Lower bound of " + target + " is at index: " + lbIndex + " (Element: " + arr[lbIndex] + ")");
        }
        else
        {
            System.out.println("No lower bound found. All elements are smaller than " + target);
        }
    }
}
