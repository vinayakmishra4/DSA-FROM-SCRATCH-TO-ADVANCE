# WAP Program to print the largest elements (leaders) in the array first

def leader_array(arr):
    n=len(arr)
    leaders=[]
    max_from_right=arr[n-1]
    leaders.append(max_from_right)
    for i in range(n-2,-1,-1):
        if arr[i]>max_from_right:
            max_from_right=arr[i]
            leaders.append(max_from_right)

    leaders.reverse()    
    return leaders

arr=[]
n=int(input("Enter the number of elements in the array: "))
for i in range(n):
    element=int(input("Enter element: "))
    arr.append(element)
leaders=leader_array(arr)
print("The leader elements in the array are: ",leaders)
