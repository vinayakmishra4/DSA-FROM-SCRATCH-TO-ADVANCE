# WAP to find out the frist and last occurance in the array
# leetcode :-https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
# geeks for geeks :-https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
# coding 360:-https://www.naukri.com/code360/problems/first-and-last-position-of-an-element-in-sorted-array_1082549


def find(arr, x):
    # strating and ending point for the binary serach
    low=0
    high=len(arr)-1
    list=[]

    # using while loop to find the frist and last occurnce  
    while low < high:
        mid=(low + high)//2 