# WAP to Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

# geeks for geeks https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
# leetcode https://leetcode.com/problems/find-missing-and-repeated-values/description/
# code360 https://www.naukri.com/code360/problems/find-the-repeating-and-missing-number_1062727

# brute force
def findTwoElement(arr, n):
    # code here
    A = 0
    B = 0
    # Traverse the array and mark visited places as negative
    for i in range(n):
        if arr[abs(arr[i]) - 1] < 0:
            A = abs(arr[i])
        else:
            arr[abs(arr[i]) - 1] = -arr[abs(arr[i]) - 1]
    
    # Traverse the array again and find the index which is positive
    for i in range(n):
        if arr[i] > 0:
            B = i + 1

    return [A, B]

nums=int(input("Enter the size of the array: "))
arr=list(map(int,input("Enter the elements of the array: ").split()))
result=findTwoElement(arr,nums)
print("The repeating and missing numbers are: ", result)