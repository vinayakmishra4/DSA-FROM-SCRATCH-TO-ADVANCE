# WAP to move all zero to end

def zerotoend(arr):
    count=0
    for i in range(len(arr)):
        if arr[i]!=0:
            arr[count]=arr[i]
            count+=1
    while count<len(arr):
        arr[count]=0
        count+=1
    return arr

nums=int(input("Enter the size of array: "))f
arr=list(map(int,input("Enter the elements of array: ").split()))
print("Array after moving zero to end: ",zerotoend(arr))