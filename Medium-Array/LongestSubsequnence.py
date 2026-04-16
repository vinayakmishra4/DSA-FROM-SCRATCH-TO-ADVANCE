# WAP to find the longest Subsequence

def longestConsecutive(arr):
        n = len(arr)
        # If the array is empty
        if n == 0:
            return 0 

        # Initialize the longest sequence length
        longest = 1 
        st = set()

        # Put all the array elements into the set
        for i in range(n):
            st.add(arr[i])

        # Traverse the set to find the longest sequence
        for it in st:
            # Check if 'it' is a starting number of a sequence
            if it - 1 not in st:
                # Initialize the count of the current sequence
                cnt = 1 
                # Starting element of the sequence
                x = it 

                # Find consecutive numbers in the set
                while x + 1 in st:
                    # Move to the next element in the sequence
                    x = x + 1 
                    # Increment the count of the sequence
                    cnt = cnt + 1 
                # Update the longest sequence length
                longest = max(longest, cnt)
        return longest

arr = []
n = int(input("Enter the number of elements in the array: "))
for i in range(n):
    element = int(input("Enter element: "))
    arr.append(element)
longest = longestConsecutive(arr)
print("The length of the longest increasing subsequence is: ", longest)