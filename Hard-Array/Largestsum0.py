# WAP to find the Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

# brute froce approach
def longest_zero_sum_bruteforce(arr):
    # Get the length of the array
    n = len(arr)
    
    # Variable to store the maximum length of subarray with sum = 0
    max_length = 0

    # First loop: choose the starting index of subarray
    for i in range(n):
        # Second loop: choose the ending index of subarray
        for j in range(i, n):
            # Initialize sum for the current subarray
            sub_sum = 0
            # Third loop: calculate sum of elements from index i to j
            for k in range(i, j + 1):
                sub_sum += arr[k]

            # Check if the current subarray sum is zero
            if sub_sum == 0:
                # Update max_length if this subarray is longer
                max_length = max(max_length, j - i + 1)

    # Return the length of the longest subarray with sum = 0
    return max_length

nums=int(input("Enter the number of the elements :-"))
arr=[]
print("Enter the elements :-")
for i in range(nums):
    i=int(input())
    arr.append(arr[i])
result=longest_zero_sum_bruteforce(arr)
print("Longest length of the Array with sum zero = ",result)


    