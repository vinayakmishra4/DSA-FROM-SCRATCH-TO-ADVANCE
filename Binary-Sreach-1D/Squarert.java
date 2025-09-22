import java.util.*;
// Class to find the floor value of the square root of a number using binary search
class Sqaurert
{
     public static int floorSqrt(int n)
     {
        // 'low' represents the lower bound of the search space
        int low = 0;
        // 'high' represents the upper bound of the search space
        int high = n;
        // 'ans' will store the floor value of the square root found so far
        int ans = -1;
        while (low <= high)
        {
           // 'mid' is the midpoint of the current search space and a candidate for the square root
           int mid = low + (high - low) / 2;
           int sqr = mid * mid;
           // If mid*mid equals n, we have found the exact square root
           if (sqr == n)
           {
              return mid;
           }
           // If mid*mid is less than n, mid can be a potential answer, search in the right half
           else if (sqr < n)
           {
              ans = mid;
              low = mid + 1;
           }
           // If mid*mid is greater than n, discard the right half and search in the left half
           else
           {
              high = mid - 1;
           }
        }
        // Return the floor value of the square root
        return ans;
     }
     public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        // Prompt user to enter a number
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        // Call the floorSqrt function to compute the square root
        int result = floorSqrt(n);
        // Output the result to the user
        System.out.println("The square root of " + n + " is: " + result);
     }
}