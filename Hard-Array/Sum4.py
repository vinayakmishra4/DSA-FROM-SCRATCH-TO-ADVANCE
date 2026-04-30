# WAP to find the sum of 4 numbers in an array

# brute force approach
def sum4(arr, target):
    # Sort the array
    arr.sort()
    # Get the length of the array
    n = len(arr)
    for i in range(n - 3):
        for j in range(i + 1, n - 2):
            for k in range(j + 1, n - 1):
                for l in range(k + 1, n):
                    if arr[i] + arr[j] + arr[k] + arr[l] == target:
                        return True
    return False






nums=int(input("Enter the number of elements in the array: "))
arr = []
for i in range(nums):
    element = int(input("Enter element: "))
    arr.append(element)
target = int(input("Enter the target sum: "))
result = sum4(arr, target)
if result:
    print("The sum of 4 numbers in the array is equal to the target.")
else:
    print("The sum of 4 numbers in the array is not equal to the target.")