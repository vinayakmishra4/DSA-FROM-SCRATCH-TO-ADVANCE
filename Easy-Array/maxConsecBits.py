# WAP to find out the maximum number of Maximum Consecutive One's in the array

import math


def maxConsecutiveOnes(arr):
    max_count = 0
    current_count = 0
    for num in arr:
        if num == 1:
            current_count += 1
            max_count = max(max_count, current_count)
        else:
            current_count = 0
    return max_count


nums = int(input("Enter the number of elements = "))
arr = []
for i in range(nums):
    element = int(input("Enter the elements = "))
    arr.append(element)

print("Maximum Consecutive One's in the array =", maxConsecutiveOnes(arr))
