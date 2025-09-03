import java.util.ArrayList;
import java.util.Scanner;

class MissingandRepated
{
    ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = arr.length;

        // Step 1: Use an auxiliary array to mark visited elements
        // If arr[i] is marked, it means that element is repeating
        boolean[] visited = new boolean[n + 1]; // size n+1 to include all elements from 1 to n

        int repeating = -1;
        int missing = -1;

        // Step 2: Traverse the array and mark the elements as visited
        for (int i = 0; i < n; i++) {
            if (visited[arr[i]]) {
                repeating = arr[i]; // If already visited, it's the repeating element
            } else {
                visited[arr[i]] = true; // Mark as visited
            }
        }

        // Step 3: Find the missing element
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                missing = i; // The first unvisited number is the missing one
                break;
            }
        }

        // Step 4: Add results to the ArrayList
        result.add(repeating);
        result.add(missing);

        return result;
    }
    public static void  main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of array");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();

        }
        MissingandRepated obj=new MissingandRepated();
        ArrayList<Integer> res=obj.findTwoElement(arr);
        System.out.println("The repeating element is "+res.get(0));
        System.out.println("The missing element is "+res.get(1));
    }
}
