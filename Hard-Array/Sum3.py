# WAP to find the sum of three numbers of target value in an array.

# brute force approach
def sum3(arr, target):
    # use three nested loops to check all combinations of three numbers in the array
    n = len(arr)
    for i in range(n):
        for j in range(i+1, n):
            for k in range(j+1, n):
                if arr[i] + arr[j] + arr[k] == target:
                    return True
    return False

arr=[]
n=int(input("Enter the size of the array: "))
print("Enter the elements of the array: ")
for i in range(n):
    arr.append(int(input()))
target=int(input("Enter the target value: "))
if sum3(arr, target):
    print("There are three numbers in the array that sum up to the target value.")
else:
    print("There are no three numbers in the array that sum up to the target value.") 