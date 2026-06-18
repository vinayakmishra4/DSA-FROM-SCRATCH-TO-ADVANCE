# WAP  Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.
# leetcode: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
# geeksforgeeks: https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
# coding ninja: https://www.codingninjas.com/codestudio/problems/first-and-last-positions-of-an-element-in-a-sorted-array_1082549

def lower_bound(arr, x):
    # Initialize the left and right pointers
    left = 0
    right = len(arr)

    # Perform binary search to find the lower bound
    while left < right:
        mid = (left + right) // 2

        if arr[mid] < x:
            left = mid + 1
        else:
            right = mid

    return left

nums=int(input("Enter the number of elements in the array: "))
arr=[]

for i in range(nums):
    element=int(input(f"Enter element {i+1}: "))
    arr.append(element)

x=int(input("Enter the integer x to find its lower bound: "))
result = lower_bound(arr, x)

print(f"The lower bound of {x} in the array is at index: {result}")