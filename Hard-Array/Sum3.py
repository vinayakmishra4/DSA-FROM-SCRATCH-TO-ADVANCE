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

# better approach
def hasSum(arr, target):
    # use a set to store the numbers we have seen so far
    n = len(arr)
    # iterate through the array and for each number, check if the needed number to reach the target is in the set
    for i in range(n):
        s = set()
        for j in range(i + 1, n):
            needed = target - arr[i] - arr[j]    
            if needed in s:
                    return True
            s.add(arr[j])
        
    return False

# optimal approach
# Two pointer approach
def hasTripletSum(arr, target):
    # sort the array
    arr.sort()
    # length of the array
    n= len(arr)
    # iterate through the array and for each number, use two pointers to find if there are two numbers that sum up to the needed value
    for i in range(n):
        needed = target - arr[i]
        left, right = i + 1, n - 1
        while left < right:
            current_sum = arr[left] + arr[right]
            if current_sum == needed:
                return True
            elif current_sum < needed:
                left += 1
            else:
                right -= 1
        return False
    

arr=[]
n=int(input("Enter the size of the array: "))
print("Enter the elements of the array: ")
for i in range(n):
    arr.append(int(input()))
target=int(input("Enter the target value: "))
if hasTripletSum(arr, target):
    print("There are three numbers in the array that sum up to the target value.")
else:
    print("There are no three numbers in the array that sum up to the target value.") 