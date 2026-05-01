# WAP to find the sum of 4 numbers in an array

# brute force approach
# using 4 nested loops to check all combinations of 4 numbers in the array and see if their sum equals the target. This approach has a time complexity of O(n^4) and is not efficient for large arrays.
# time complexity: O(n^4) space complexity: O(1)
def sum4(arr, target):
    # Sort the array
    arr.sort()
    # Get the length of the array
    n = len(arr)
    for i in range(n - 3):
        for j in range(i + 1, n - 2):
            for k in range(j + 1, n - 1):
                for l in range(k + 1, n):
                    if arr[i] + arr[j] + arr[k] + arr[l] == target:
                        return True
    return False

# better approach
# using hashing to store the sums of pairs of numbers in the array and then checking if the complement of the target (target - sum of pairs) exists in the hash. This approach has a time complexity of O(n^2) and a space complexity of O(n^2).
# time complexity: O(n^2) space complexity: O(n^2)
def besum4(arr,target):
    # Sort the array
    arr.sort()
    # Get the length of the array
    n = len(arr)
    # Create a hash to store the sums of pairs of numbers
    pair_sums = {}
    for i in range(n - 1):
        for j in range(i + 1, n):
            pair_sum = arr[i] + arr[j]
            if pair_sum not in pair_sums:
                pair_sums[pair_sum] = [(i, j)]
            else:
                pair_sums[pair_sum].append((i, j))

    # Check if the complement of the target exists in the hash
    for pair_sum in pair_sums:
        complement = target - pair_sum
        if complement in pair_sums:
            for (i, j) in pair_sums[pair_sum]:
                for (k, l) in pair_sums[complement]:
                    if i != k and i != l and j != k and j != l:
                        return True
    return False





nums=int(input("Enter the number of elements in the array: "))
arr = []
for i in range(nums):
    element = int(input("Enter element: "))
    arr.append(element)
target = int(input("Enter the target sum: "))
result = besum4(arr, target)
if result:
    print("The sum of 4 numbers in the array is equal to the target.")
else:
    print("The sum of 4 numbers in the array is not equal to the target.")