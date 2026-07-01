# WAP to find the sreach insertion postion in the array
# leetcode :-https://leetcode.com/problems/search-insert-position/
# geeks for geeks:https://www.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1
# code360:-https://www.naukri.com/code360/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813?leftPanelTabValue=SUBMISSION

# find or inset in the array 
def searchInsertK(arr, k):
    # assigned the left and right pointer to the first and last index of the array
    left = 0
    right = len(arr) - 1

    # loop until the left pointer is less than or equal to the right pointer
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == k:
            return mid
        elif arr[mid] < k:
            left = mid + 1
        else:
            right = mid - 1

    return left
                






arr=[]
num=int(input(" Enter the size of array :- "))
print(" Enter the elements ")
for i in range(num):
    i=int(input())
    arr.append(i)
k=int(input("Enter the number to insert sreach postion"))
result=searchInsertK(arr, k)
print("Position of the number : " , searchInsertK(arr, k))