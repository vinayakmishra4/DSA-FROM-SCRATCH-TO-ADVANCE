class MissingK
{
    // Approach 1: Using Linear Search
    // public static int kthMissing(int[] arr, int k)
    // {
    //     for(int i = 0; i < arr.length - 1; i++)
    //     {
    //         if(arr[i]<=k)
    //         {
    //             k++;
    //         }
    //         else
    //         {
    //             break;
    //         }
    //     }
    //     return k;
    // }
    // Approach 2: Using Binary Search
    public static int kthMissing(int[] arr, int k)
    {
        int left = 0;
        int right = arr.length - 1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            int missing=arr[mid]-mid-1;
            if(missing < k)
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return right + k + 1;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k: ");
        int k = sc.nextInt();
        int result = kthMissing(arr, k);
        System.out.println("The " + k + "th missing number is: " + result);
    }
}