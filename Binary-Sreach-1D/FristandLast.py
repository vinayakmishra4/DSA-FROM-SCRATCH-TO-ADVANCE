# WAP to find out the frist and last occurance in the array
# leetcode :-https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
# geeks for geeks :-https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
# coding 360:-https://www.naukri.com/code360/problems/first-and-last-position-of-an-element-in-sorted-array_1082549


def first_occurrence(arr, x):
    left = 0
    right = len(arr) - 1
    ans = -1

    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == x:
            ans = mid          # store possible answer
            right = mid - 1   # search further left

        elif arr[mid] < x:
            left = mid + 1

        else:
            right = mid - 1

    return ans

# Last occurance
def Lastoccurance(arr,x):

# comibing the frist and last of occurance
def find(arr, x):
    #code here