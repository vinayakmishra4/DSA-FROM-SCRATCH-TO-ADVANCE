import java.util.Scanner;

class Nsqaure
{
    public static int nthRoot(int n, int m)
    {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            double val = Math.pow(mid, n);
            if (val == m)
                return mid;
            else if (val < m)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1; 
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of m and n");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = nthRoot(n, m);
        if (result != -1)
            System.out.println("The " + n + "th root of " + m + " is: " + result);
        else
            System.out.println(m + " does not have an integer " + n + "th root.");    
    }
}
