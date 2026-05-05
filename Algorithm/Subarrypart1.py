# WAP to Number of Subarrays with Sum K
# using silding window 

def longest_subarray_with_sum_k(arr, k):
    left = 0
    current_sum = 0
    max_length = 0

    for right in range(len(arr)):
        current_sum += arr[right]

        # shrink window if sum > k
        while current_sum > k and left <= right:
            current_sum -= arr[left]
            left += 1

        # check if sum == k
        if current_sum == k:
            max_length = max(max_length, right - left + 1)

    return max_length

n = int(input("Enter the number of elements in the array: "))
arr = []
print("Enter the elements of the array:")
for _ in range(n):
    arr.append(int(input()))
k = int(input("Enter the value of K: "))
result = longest_subarray_with_sum_k(arr, k)
print("The length of the longest subarray with sum K is:", result)