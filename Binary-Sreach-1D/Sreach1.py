# WAP to Search X in sorted array
# Leetcode: 704. Binary Search 
# GeeksforGeeks: https://www.geeksforgeeks.org/python-program-for-binary-search/
# coding ninjas: https://www.codingninjas.com/codestudio/problems/binary-search_1082559

# find out the traget value using binary search

def binarySearch(arr, target):
    # define low and high pointer
    low=0
    high=len(arr)-1;
    # loop until low is less than or equal to high 
    while low<=high:
        mid=(low+high)//2
        if arr[mid]==target:
            return mid
        elif arr[mid]>target:
            high=mid-1
        else:  
            low=mid+1
    return -1

nums=int(input("Enter the number of elements in the array: "))
arr=[]
print("Enter the elements in sorted order: ")
for i in range(nums):
    arr.append(int(input()))
target=int(input("Enter the target value: "))
result=binarySearch(arr, target)
if result==-1:
    print("Element not found in the array.")
else:
    print("Element found at index:", result)