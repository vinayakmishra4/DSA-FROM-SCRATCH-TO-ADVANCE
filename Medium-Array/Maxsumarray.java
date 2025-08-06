import java.util.ArrayList;
import java.util.Scanner;

public class Maxsumarray {

    public static ArrayList<Integer> maxSubarraySum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        int start = 0, end = 0, tempStart = 0;

        for (int i = 1; i < arr.length; i++) {
            if (currentSum < 0) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Build result subarray
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> maxSubarray = maxSubarraySum(arr);
        int maxSum = maxSubarray.stream().mapToInt(Integer::intValue).sum();

        System.out.println("Maximum sum of subarray is: " + maxSum);
        System.out.print("Subarray with maximum sum: ");
        for (int num : maxSubarray) {
            System.out.print(num + " ");
        }
    }
}
