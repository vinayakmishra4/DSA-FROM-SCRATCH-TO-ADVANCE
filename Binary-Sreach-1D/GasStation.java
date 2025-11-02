// WAP to find the starting gas station index from where a vehicle can complete a circular tour
class GasStation
{
    public double minMaxDist(int[] stations, int K) 
    {
        int n = stations.length;
        int left = 0, right = stations[n - 1] - stations[0];

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canCompleteTour(stations, K, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;        
    }
    private boolean canCompleteTour(int[] stations, int K, int maxDist) {
        int n = stations.length;
        int count = 1;
        int lastPos = stations[0];

        for (int i = 1; i < n; i++) {
            if (stations[i] - lastPos > maxDist) {
                count++;
                lastPos = stations[i - 1];
                if (count > K) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of gas stations: ");
        int n = sc.nextInt();
        int[] stations = new int[n];
        System.out.println("Enter the positions of gas stations: ");
        for(int i = 0; i < n; i++)
        {
            stations[i] = sc.nextInt();
        }
        System.out.println("Enter number of vehicles: ");
        int K = sc.nextInt();
        GasStation gs = new GasStation();
        double result = gs.minMaxDist(stations, K);
        System.out.println("Minimum of the maximum distance: " + result);    
    }
}