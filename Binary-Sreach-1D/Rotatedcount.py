# WAP to Find out how many times the array has been rotated
# geeks for geeks :- https://www.geeksforgeeks.org/problems/rotation4723/1
# coding nijas :- https://www.naukri.com/code360/problems/rotation_7449070

def count_rotation(arr):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2

        # Check if mid is the minimum element
        if arr[mid] < arr[(mid - 1) % len(arr)] and arr[mid] < arr[(mid + 1) % len(arr)]:
            return mid

        # If the left half is sorted, the minimum must be in the right half
        elif arr[low] <= arr[mid]:
            low = mid + 1
        else:
            high = mid - 1

    return 0  # If the array is not rotated

nums=int(input("Enter the number of elements in the array: "))
arr = []
for i in range(nums):
    element = int(input(f"Enter element {i + 1}: "))
    arr.append(element)
result = count_rotation(arr)
if result == 0:
    print("The array is not rotated.")
else:
    print(f"The array has been rotated {result} times.")