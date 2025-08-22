// WAP to sum 4 numbers using array.

import java.util.ArrayList;
import java.util.Scanner;

class Sum4
{
    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length;
        if (n < 4) return result;

        java.util.Arrays.sort(arr);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue; // Skip duplicates for the first number

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue; // Skip duplicates for the second number

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];

                    if (sum == target) {
                        result.add(new ArrayList<>(java.util.Arrays.asList(arr[i], arr[j], arr[left], arr[right])));

                        while (left < right && arr[left] == arr[left + 1]) left++; // Skip duplicates for the third number
                        while (left < right && arr[right] == arr[right - 1]) right--; // Skip duplicates for the fourth number

                        left++;
                        right--;
                    }
                    else if (sum < target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt(); 
        }
        System.out.println("Enter the target sum:");
        int target = sc.nextInt();
        ArrayList<ArrayList<Integer>> result = fourSum(arr, target);
        if (result.isEmpty())
        {
            System.out.println("No quadruplets found.");
        }
        else
        {
            System.out.println("Quadruplets that sum to " + target + ":");
            for (ArrayList<Integer> quadruplet : result) 
            {
                System.out.println(quadruplet);    
            }
        }
    }
}
