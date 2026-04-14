# WAP to find next lexicographically greater permutation of a given array of integers. If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

def next_permutation(nums):
    # Step 1: Find the first decreasing element from the right
    # This finds the "pivot" index i such that nums[i] < nums[i+1]
    # If no such index exists, the array is in descending order (last permutation)
    n = len(nums)
    i = n - 2
    while i >= 0 and nums[i] >= nums[i + 1]:
        i -= 1

    # Step 2: If pivot exists, find the next larger element to swap with
    if i >= 0:
        # Find the smallest number greater than nums[i] to the right
        j = n - 1
        while nums[j] <= nums[i]:
            j -= 1
        
        # Swap pivot with that number
        nums[i], nums[j] = nums[j], nums[i]

    # Step 3: Reverse the suffix (everything right of pivot)
    # This makes it the smallest possible order after the swap
    nums[i + 1:] = reversed(nums[i + 1:])

arr=[]
n=int(input("Enter the number of elements in the array: "))
print("Enter the elements of the array:")
for _ in range(n):
    arr.append(int(input()))
next_permutation(arr)
print("The next permutation is:", arr)
