// WAP to find the minimum speed at which Koko can eat all bananas in k hours
import java.util.Scanner;

public class KokoEatingBananas
{
    // Method to check if Koko can finish all bananas at speed 's' within 'k' hours
    public static boolean canFinish(int[] arr, int k, int s)
    {
        int totalHours = 0;  // Total hours Koko spends eating
        
        // Calculate total hours needed to eat all piles at speed s
        for (int pile : arr) {
            // Hours needed for current pile = ceiling of (pile / speed)
            // Because Koko can't eat partial bananas per hour, partial pile counts as full hour
            totalHours += (int) Math.ceil((double) pile / s);  
            
            // If total hours exceed available hours k, no need to continue
            if (totalHours > k) {  
                return false;  // Koko can't finish at speed s
            }
        }
        // If total hours is within k, Koko can finish
        return totalHours <= k;  
    }

    // Method to find minimum eating speed to finish all bananas within k hours
    public static int kokoEat(int[] arr, int k)
    {
        int low = 1;  // Minimum possible speed (at least 1 banana per hour)
        int high = 0; // Initialize maximum speed to 0 (will update)
        
        // Find the maximum pile size (Koko can't eat faster than largest pile)
        for (int pile : arr)
        {
            high = Math.max(high, pile);
        }

        int result = high; // Initialize result with maximum possible speed
        
        // Binary search between low and high to find the minimum valid speed
        while(low <= high)
        {
            int mid = (low + high) / 2;  // Middle speed to test
            
            // Check if Koko can finish at this speed mid
            if (canFinish(arr, k, mid))
            {
                result = mid;       // mid speed works, record it
                high = mid - 1;     // Try to find a smaller speed that also works
            }
            else
            {
                low = mid + 1;      // mid speed too slow, try faster speeds
            }
        }
        
        return result;  // Minimum speed found
    }   

    // Main method - handles input/output
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Input number of piles
        System.out.println("Enter the number of piles:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input bananas in each pile
        System.out.println("Enter the number of bananas in each pile:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();    
        }

        // Input total hours Koko has to finish eating
        System.out.println("Enter the number of hours Koko has to finish:");
        int k = sc.nextInt();

        // Calculate minimum speed to finish all bananas in k hours
        int result = kokoEat(arr, k);

        // Output the result
        System.out.println("The minimum eating speed of Koko to finish all the bananas in " + k + " hours is: " + result); 
        
        sc.close();
    }
}
