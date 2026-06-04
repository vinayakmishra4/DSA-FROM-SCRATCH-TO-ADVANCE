# WAP to Given an array that contains both negative and positive integers, find the maximum product subarray.
# leetcode https://leetcode.com/problems/maximum-product-subarray/description/
# geeks for geeks https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
# coding ninja https://www.naukri.com/code360/problems/maximum-product-subarray_1115474

# Approach 1: Brute Force
# Time Complexity: O(n^2)
def max_product_subarray(arr):
    # Initialize the maximum product to negative infinity
    n = len(arr)
    max_product = float('-inf')

    # Iterate through all possible subarrays
    for i in range(n):
        product = 1
        for j in range(i, n):
            product *= arr[j]
            max_product = max(max_product, product)

    return max_product

num=int(input("Enter the number of elements in the array: "))
arr=[]
print("Enter the elements of the array: ")
for i in range(num):
    arr.append(int(input()))
result = max_product_subarray(arr)
print("The maximum product subarray is:", result)
