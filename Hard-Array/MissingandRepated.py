# WAP to Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

# geeks for geeks https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
# leetcode https://leetcode.com/problems/find-missing-and-repeated-values/description/
# code360 https://www.naukri.com/code360/problems/find-the-repeating-and-missing-number_1062727

# brute force
def brfindTwoElement(arr, n):
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

# better approach
# using hashing
def befindTwoElement(arr, n):
    # code here
    A = 0
    B = 0
    # Create a hash array to store the count of each element
    hash_arr = [0] * (n + 1)
    for i in range(n):
        hash_arr[arr[i]] += 1
    
    # Traverse the hash array and find the repeating and missing elements
    for i in range(1, n + 1):
        if hash_arr[i] == 2:
            A = i
        elif hash_arr[i] == 0:
            B = i

    return [A, B]

# optimal approach
# using mathematical formulas
def opfindTwoElement(arr, n):
    # code here
    A = 0
    B = 0
    # Calculate the sum of the first n natural numbers and the sum of squares of the first n natural numbers
    sum_n = n * (n + 1) // 2
    sum_n_sq = n * (n + 1) * (2 * n + 1) // 6
    
    # Calculate the sum of the elements in the array and the sum of squares of the elements in the array
    sum_arr = sum(arr)
    sum_arr_sq = sum(x * x for x in arr)
    
    # Calculate A - B and A^2 - B^2
    A_minus_B = sum_arr - sum_n
    A_sq_minus_B_sq = sum_arr_sq - sum_n_sq
    
    # Calculate A + B using the formula (A^2 - B^2) / (A - B)
    A_plus_B = A_sq_minus_B_sq // A_minus_B
    
    # Calculate A and B using the formulas A = (A + B) / 2 and B = (A + B) / 2 - A
    A = (A_plus_B + A_minus_B) // 2
    B = A_plus_B - A

    return [A, B]


nums=int(input("Enter the size of the array: "))
arr=list(map(int,input("Enter the elements of the array: ").split()))
result=opfindTwoElement(arr,nums)
print("The repeating and missing numbers are: ", result)