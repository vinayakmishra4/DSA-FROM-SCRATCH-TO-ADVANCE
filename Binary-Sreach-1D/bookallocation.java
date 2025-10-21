/*
 * Book Allocation Problem
 * ------------------------
 * Given an array where each element represents the number of pages in a book and an integer k (number of students),
 * the goal is to allocate books among students such that:
 *   1. Each student gets at least one book.
 *   2. Books are allocated in contiguous order.
 *   3. The maximum number of pages assigned to a student is minimized.
 *
 * Approach:
 * ----------
 * - Use Binary Search to find the minimum possible maximum pages a student can get.
 * - The search range is between the maximum pages in a single book and the sum of all pages.
 * - For each mid value in this range, check if it’s possible to allocate books to students
 *   such that no student gets more than mid pages.
 *
 * isPossible() function:
 * ------------------------
 * - Iterates through all books.
 * - Keeps a running sum of pages for the current student.
 * - If adding the next book exceeds mid, assign it to the next student.
 * - If students required exceed k, return false.
 *
 * The function returns the minimum number of pages that achieves valid allocation.
 */
import java.util.Scanner;

// WAP of book allocation problem using binary search
class bookallocation
{
    // Function to find the minimum number of pages that can be allocated to a student
    // Uses binary search between the largest book and the sum of all pages
    public int findPages(int[] arr, int k)
    {
          int start = 0;
            int end = 0;
            // Calculate the total number of pages (sum of all elements)
            for(int i=0;i<arr.length;i++)
            {
                end += arr[i];
            }
            int result = -1;
            // Apply binary search to minimize the maximum pages
            while(start <= end)
            {
                int mid = start + (end - start) / 2;
                if(isPossible(arr, k, mid))
                {
                    // If it is possible to allocate with mid as the maximum limit,
                    // store result and try for a smaller value (move left)
                    result = mid;
                    end = mid - 1;
                }
                else
                {
                    // Otherwise, try a larger value (move right)
                    start = mid + 1;
                }
            }
            return result;      
    }
    // Helper function to check if it is possible to allocate books
    // so that no student gets more than 'mid' pages
    public boolean isPossible(int[] arr, int k, int mid)
    {
        int studentCount = 1;
        int pageSum = 0;
        // Assign books to students sequentially and track the total pages
        for(int i=0;i<arr.length;i++)
        {
            if(pageSum + arr[i] <= mid)
            {
                pageSum += arr[i];
            }
            else
            {
                studentCount++;
                // If the number of students required exceeds k or
                // a single book has more pages than mid, return false
                if(studentCount > k || arr[i] > mid)
                {
                    return false;
                }
                pageSum = arr[i];
            }
        }
        return true;
    }
    // Driver code to take input and execute the algorithm
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter number of pages in each book:");
        for(int i=0;i<n;i++)    
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter number of students:");
        int k = sc.nextInt();
        bookallocation ba = new bookallocation();
        int result = ba.findPages(arr, k);
        System.out.println("Minimum number of pages allocated to a student: " + result);
    }
}