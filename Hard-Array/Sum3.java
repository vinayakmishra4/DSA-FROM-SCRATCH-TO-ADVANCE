import java.util.Arrays;

class Sum3 {
    public boolean hasTripletSum(int arr[], int target) {
        int n = arr.length;
        Arrays.sort(arr); // First, sort the array

        // Fix the first element one by one and find the other two using two pointers
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right)
            {
                int currentSum = arr[i] + arr[left] + arr[right];
                if (currentSum == target)
                {
                    return true;
                }
                else if(currentSum < target)
                {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return false; // No triplet found
    }

    public static void main(String[] args)
    {

    }
}
