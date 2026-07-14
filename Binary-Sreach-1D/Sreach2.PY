#  Given an integer array arr of size N, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.
# Geeks for geeks :- https://www.geeksforgeeks.org/dsa/search-an-element-in-a-sorted-and-pivoted-array/
# leetcode :- https://leetcode.com/problems/search-in-rotated-sorted-array/
# coding ninjas :- https://www.codingninjas.com/codestudio/problems/search-in-rotated-sorted-array_1082559?leftPanelTab=0

def search(arr, k):
    # Serch in rotated sorted array using binary search
    # 
    left=0
    right=len(arr)-1;
    while left<=right:
        mid=(left+right)//2
        if arr[mid]==k:
            return True
        elif arr[left]<=arr[mid]:
            if arr[left]<=k and k<arr[mid]:
                right=mid-1
            else:
                left=mid+1
        else:
            if arr[mid]<k and k<=arr[right]:
                left=mid+1
            else:
                right=mid-1
    return False

nums=input("Enter the array elements separated by space: ")
arr=[]

for i in nums:
    i=input("Enter the array elements separated by space: ")
    arr.append(int(i))

k=int(input("Enter the target value: "))
print(" result :=" , search(arr, k))
