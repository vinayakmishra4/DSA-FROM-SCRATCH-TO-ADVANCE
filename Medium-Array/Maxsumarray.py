# WAP to Kadane's Algorithm : Maximum Subarray Sum in an Array

def max_subarray_sum(arr):
    max_sum = float('-inf')
    current_sum = 0

    for num in arr:
        current_sum += num
        max_sum = max(max_sum, current_sum)

        if current_sum < 0:
            current_sum = 0

    return max_sum


arr=[]
n=int(input("Enter the number of elements in the array: "))
print("Enter the elements of the array:")
for i in range(n):
    element=int(input())
    arr.append(element)
result = max_subarray_sum(arr)
print("The maximum subarray sum is:", result)