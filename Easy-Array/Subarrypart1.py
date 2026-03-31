# WAP to Number of Subarrays with Sum K

def longest_subarray_with_sum_k(arr, k):
    prefix_sum = {0: 1}
    current_sum = 0
    count = 0

    for num in arr:
        current_sum += num
        if current_sum - k in prefix_sum:
            count += prefix_sum[current_sum - k]
        if current_sum in prefix_sum:
            prefix_sum[current_sum] += 1
        else:
            prefix_sum[current_sum] = 1

    return count

n = int(input("Enter the number of elements in the array: "))
arr = []
print("Enter the elements of the array:")
for _ in range(n):
    arr.append(int(input()))
k = int(input("Enter the value of K: "))
result = longest_subarray_with_sum_k(arr, k)
print("The length of the longest subarray with sum K is:", result)