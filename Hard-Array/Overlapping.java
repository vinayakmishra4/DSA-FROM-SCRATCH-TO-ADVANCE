import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Overlapping {

    // Method to merge overlapping intervals
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Sort the intervals based on the starting point of each interval
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> list = new ArrayList<>();
        // Start with the first interval
        int[] cur = Arrays.copyOf(arr[0], 2);

        for (int i = 1; i < arr.length; i++) {
            // If the current interval overlaps with the previous, merge them
            if (arr[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], arr[i][1]); // Extend the end point if necessary
            } else {
                // If no overlap, add the current interval to the result and update cur
                list.add(cur);
                cur = Arrays.copyOf(arr[i], 2); // Set cur to the new interval
            }
        }

        // Add the last merged interval
        list.add(cur);

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of intervals from the user
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];

        // Get the intervals from the user
        System.out.println("Enter the intervals (start and end) one by one:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start of interval " + (i+1) + ": ");
            intervals[i][0] = scanner.nextInt();
            System.out.print("Enter end of interval " + (i+1) + ": ");
            intervals[i][1] = scanner.nextInt();
        }

        // Create an instance of Overlapping class and merge the intervals
        Overlapping obj = new Overlapping();
        ArrayList<int[]> mergedIntervals = obj.mergeOverlap(intervals);

        // Print the merged intervals
        System.out.println("\nMerged intervals are:");
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
