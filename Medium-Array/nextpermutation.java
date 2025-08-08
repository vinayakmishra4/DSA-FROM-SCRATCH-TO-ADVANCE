import java.util.Scanner;

class nextpermutation
{
    // Function to find the next lexicographical permutation of the array
    public static void nextPermutation(int[] arr)
    {
        int n = arr.length;
        
        // Step 1: Find the rightmost index 'i' such that arr[i] < arr[i+1]
        // This identifies the "pivot" point where the array stops increasing from the right
        int i = n - 2;
        while(i >= 0 && arr[i + 1] <= arr[i])
        {
            i--;
        }
        
        // If such an index 'i' is found (i >= 0), it means the array is not the highest permutation
        if(i >= 0)
        {
            // Step 2: Find the rightmost element 'j' greater than arr[i]
            int j = n - 1;
            while(arr[j] <= arr[i])
            {
                j--;
            }
            // Step 3: Swap arr[i] and arr[j]
            swap(arr, i, j);
        }
        
        // Step 4: Reverse the sub-array from i+1 till the end to get the next smallest lexicographical permutation
        reverse(arr, i + 1, n - 1);
    }
    
    // Utility method to swap two elements in the array
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;    
    }
    
    // Utility method to reverse a portion of the array from 'start' to 'end'
    public static void reverse(int[] arr, int start, int end)
    {
        while (start < end) 
        {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Size of the array");
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements of the array");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Next Permutation:");
        nextPermutation(arr);
        
        // Print the resulting array after applying nextPermutation
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
    }
}