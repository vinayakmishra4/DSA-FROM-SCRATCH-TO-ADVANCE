import java.util.Arrays;
import java.util.Scanner;

class Sum3 {
    /**
     * This method checks if there exists a triplet in the array
     * that adds up to the target value.
     */
    public boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        Arrays.sort(arr); // Sort array to apply two-pointer technique

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];

                if (currentSum == target) {
                    // Triplet found
                    System.out.println("Triplet found: " + arr[i] + ", " + arr[left] + ", " + arr[right]);
                    return true;
                } else if (currentSum < target) {
                    left++; // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }

        // No triplet found
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create scanner object

        // Ask user for size of array
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        // Input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input target sum
        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        // Create object and call method
        Sum3 obj = new Sum3();
        boolean found = obj.hasTripletSum(arr, target);

        // Final result
        if (!found) {
            System.out.println("No triplet found that sums to " + target);
        }

        scanner.close(); // Close scanner to avoid resource leak
    }
}
