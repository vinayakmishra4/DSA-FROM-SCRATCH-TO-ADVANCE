# WAP-You are given a sorted array containing N integers and a number X, you have to find the occurrences of X in the given array.
# Geeks for Geeks :- https://www.geeksforgeeks.org/number-of-occurrences-in-a-sorted-array/
# leetcode :- https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
# coding ninjas :- https://www.codingninjas.com/codestudio/problems/number-of-occurrences_893186

def first(arr, n, x):
    low = 0
    high = n - 1
    res = -1
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == x:
            res = mid
            high = mid - 1
        elif arr[mid] < x:
            low = mid + 1
        else:
            high = mid - 1
    return res
    
nums=int(input("Enter the number of elements in the array: "))
arr=[]
for i in range(nums):
    arr.append(int(input(f"Enter element {i+1}: ")))
x=int(input("Enter the number to find occurrences of: "))
print(f"The number of occurrences of {x} in the array is: {first(arr, nums, x)}")