# WAP to find out the frist and last occurance in the array
# leetcode :-https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
# geeks for geeks :-https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
# coding 360:-https://www.naukri.com/code360/problems/first-and-last-position-of-an-element-in-sorted-array_1082549

# First occurrence of element in array
def first_occurrence(arr, x):
    left = 0
    right = len(arr) - 1
    ans = -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == x:
            ans = mid
            right = mid - 1  # search further left

        elif arr[mid] < x:
            left = mid + 1

        else:
            right = mid - 1

    return ans


# Last occurrence of element in array
def last_occurrence(arr, x):
    left = 0
    right = len(arr) - 1
    ans = -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == x:
            ans = mid
            left = mid + 1  # search further right

        elif arr[mid] < x:
            left = mid + 1

        else:
            right = mid - 1

    return ans


# Combining first and last occurrence
def find(arr, x):
    first = first_occurrence(arr, x)
    last = last_occurrence(arr, x)
    return [first, last]


# User Input
n = int(input("Enter the number of elements: "))

print("Enter the elements in sorted order:")
arr = list(map(int, input().split()))

x = int(input("Enter the element to find: "))

result = find(arr, x)

print("First and Last Occurrence:", result)