"""""

Binary Search in 1D Array to find Floor and Ceiling of a number
Floor: The floor of a number x in a sorted array is the greatest element in the array
        which is less than or equal to x. If such element doesn't exist, floor is undefined (here, returned as -1).
Ceiling: The ceiling of a number x in a sorted array is the smallest element in the array
         which is greater than or equal to x. If such element doesn't exist, ceiling is undefined (here, returned as -1).

"""
# leetcode 
# geeks for geeks https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1 ,https://www.geeksforgeeks.org/problems/ceil-in-a-sorted-array/1
# coding 360 https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401

# Function to find the floor of x
# Floor = largest element <= x
def floor(arr, x):
    left, right = 0, len(arr) - 1
    ans = None

    while left <= right:
        mid = (left + right) // 2

        # Current element can be a floor candidate
        if arr[mid] <= x:
            ans = arr[mid]
            left = mid + 1  # Search for a larger valid floor
        else:
            right = mid - 1

    return ans


# Function to find the ceil of x
# Ceil = smallest element >= x
def ceil(arr, x):
    left, right = 0, len(arr) - 1
    ans = None

    while left <= right:
        mid = (left + right) // 2

        # Current element can be a ceil candidate
        if arr[mid] >= x:
            ans = arr[mid]
            right = mid - 1  # Search for a smaller valid ceil
        else:
            left = mid + 1

    return ans


# Take sorted array input from the user
arr = list(map(int, input("Enter sorted array elements: ").split()))

# Take the target value
x = int(input("Enter value of x: "))

# Display results
print("Floor:", floor(arr, x))
print("Ceil :", ceil(arr, x))