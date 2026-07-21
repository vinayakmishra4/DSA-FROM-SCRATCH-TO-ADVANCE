# WAP to Peak element in the sorted array 

def peakelement(arr):
    low=0
    high=len(arr)-1

    while low<high:
        mid=low+(low+high)//2
        if arr[mid]<arr[mid+1]:
            low=mid+1
        else:
            high=mid
    return arr[low]

nums=int(input("Enter the number of elements in the array: "))
arr=[]
for i in range(nums):
    element=int(input("Enter the element: "))
    arr.append(element)
result=peakelement(arr)
print("The peak element in the array is:", result)

