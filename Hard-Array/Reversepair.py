# WAP to : Given an array of numbers, you need to return the count of reverse pairs. Reverse Pairs are those pairs where i<j and arr[i]>2*arr[j].
# geeks for geeks :- https://www.geeksforgeeks.org/problems/count-reverse-pairs/1
# leetcode :-https://leetcode.com/problems/reverse-pairs/description/
# coding 360 :-https://www.naukri.com/code360/problems/reverse-pairs_1112652

# Brute Force Approach
def bereversePairs(nums):
    count = 0
    # Traverse through all possible pairs of the given array and count those pairs which satisfy the given condition.
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            if nums[i] > 2 * nums[j]:
                count += 1
    return count



nums = int(input("Enter the number of elements in the array: "))
arr = []
for i in range(nums):
    num = int(input("Enter the element: "))
    arr.append(num)
print("The count of reverse pairs is:", bereversePairs(arr))
