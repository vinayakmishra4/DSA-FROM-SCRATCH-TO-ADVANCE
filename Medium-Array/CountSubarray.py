# Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k. A subarray is a contiguous non-empty sequence of elements within an array.

def count_subarrays_with_sum_k(arr, k):
    # count of subarrays with sum k
    count = 0
    # dictionary to store the cumulative sum frequencies
    cumulative_sum_freq = {0: 1}  # Initialize with sum 0 occurring
    cumulative_sum = 0
    for num in arr:
        cumulative_sum += num
        # Check if there is a cumulative sum that when subtracted from current sum gives k
        if (cumulative_sum - k) in cumulative_sum_freq:
            count += cumulative_sum_freq[cumulative_sum - k]
        # Update the frequency of the current cumulative sum
        cumulative_sum_freq[cumulative_sum] = cumulative_sum_freq.get(cumulative_sum, 0) + 1
    return count






nums=int(input("Enter the number of elements in the array: "))
print("Enter the elements of the array:")
arr = list(map(int, input().split()))
k=int(input("Enter the value of k: "))
result = count_subarrays_with_sum_k(arr, k)
print("The total number of subarrays whose sum equals k is:", result)