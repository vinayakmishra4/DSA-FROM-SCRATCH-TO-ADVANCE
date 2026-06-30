# WAP to find the sreach insertion postion in the array
# leetcode :-https://leetcode.com/problems/search-insert-position/
# geeks for geeks:https://www.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1
# code360:-https://www.naukri.com/code360/problems/algorithm-to-find-best-insert-position-in-sorted-array_839813?leftPanelTabValue=SUBMISSION

# find or inset in the array 
def searchInsertK(arr, k):
    for i in range(len(arr)):
        if arr[i]==k :
            return i        






arr=[]
num=int(input(" Enter the size of array :- "))
print(" Enter the elements ")
for i in range(num):
    i=int(input())
    arr.append(i)
k=int(input("Enter the number to insert sreach postion"))
result=searchInsertK(arr, k)
print("Position of the number : " , searchInsertK(arr, k))