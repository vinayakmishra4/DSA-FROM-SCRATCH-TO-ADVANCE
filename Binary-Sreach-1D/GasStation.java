import java.util.*;

// Program to find the minimum of the maximum distance between gas stations
// after adding up to K more gas stations optimally.
// This uses a binary search approach over possible maximum distances.
class GasStation {
    
    // Function to compute the minimized maximum distance
    public double minMaxDist(int[] stations, int K) {
        Arrays.sort(stations); // Ensure stations are sorted

        int n = stations.length;
        double left = 0.0;  // Minimum possible distance
        double right = stations[n - 1] - stations[0]; // Maximum possible distance (entire range)
        double epsilon = 1e-6; // Precision for floating-point comparison

        // Binary search on the answer space (possible maximum distances)
        while (right - left > epsilon) {
            double mid = (left + right) / 2.0;
            
            // If we can achieve mid as the maximum distance with K additions, move left
            if (canAchieve(stations, K, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;        
    }

    // Helper function to check if we can achieve 'maxDist' as the maximum gap
    // by adding at most K new stations
    private boolean canAchieve(int[] stations, int K, double maxDist) {
        int requiredStations = 0;
        
        // Count how many additional stations are needed for each gap
        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            
            // Number of extra stations needed in this gap
            requiredStations += (int) (gap / maxDist);
            
            if (requiredStations > K) return false; // Too many stations required
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of gas stations: ");
        int n = sc.nextInt();
        int[] stations = new int[n];
        
        System.out.println("Enter the positions of gas stations (unsorted allowed): ");
        for (int i = 0; i < n; i++) {
            stations[i] = sc.nextInt();
        }
        
        System.out.print("Enter number of additional gas stations (K): ");
        int K = sc.nextInt();
        
        GasStation gs = new GasStation();
        double result = gs.minMaxDist(stations, K);
        
        System.out.printf("Minimum possible maximum distance after adding %d stations: %.6f\n", K, result);
    }
}