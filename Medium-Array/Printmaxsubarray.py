# WAP to to print the maximum subarray from the given array.

def max_subarray(arr):
    max_sum = float('-inf')
    current_sum = 0
    start = 0
    end = 0
    temp_start = 0

    for i in range(len(arr)):
        current_sum += arr[i]

        if current_sum > max_sum:
            max_sum = current_sum
            start = temp_start
            end = i

        if current_sum < 0:
            current_sum = 0
            temp_start = i + 1

    return arr[start:end + 1]

arr=[]
n=int(input("Enter the number of elements in the array: "))
print("Enter the elements of the array:")
for i in range(n):
    element=int(input())
    arr.append(element)
result = max_subarray(arr)
print("The maximum subarray is:", result)   