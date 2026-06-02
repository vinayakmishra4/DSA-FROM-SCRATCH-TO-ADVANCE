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

# optimal approach
# using merge sort
def oprevesrparis(nums):
    # The idea is to use a modified merge sort algorithm to count the reverse pairs while sorting the array. During the merge step, we can count how many elements in the right half of the array are less than half of the current element in the left half.
    def merge_sort(nums, low, high):
        if low >= high:
            return 0
        mid = (low + high) // 2
        count = merge_sort(nums, low, mid) + merge_sort(nums, mid + 1, high)
        j = mid + 1
        for i in range(low, mid + 1):
            while j <= high and nums[i] > 2 * nums[j]:
                j += 1
            count += j - (mid + 1)
        # Merge the two sorted halves
        temp = []
        left, right = low, mid + 1
        # Merge the two halves while counting the reverse pairs
        while left <= mid and right <= high:
            if nums[left] <= nums[right]:
                temp.append(nums[left])
                left += 1
            else:
                temp.append(nums[right])
                right += 1
        while left <= mid:
            temp.append(nums[left])
            left += 1
        while right <= high:
            temp.append(nums[right])
            right += 1
        for i in range(len(temp)):
            nums[low + i] = temp[i]
        return count

    return merge_sort(nums, 0, len(nums) - 1)

nums = int(input("Enter the number of elements in the array: "))
arr = []
for i in range(nums):
    num = int(input("Enter the element: "))
    arr.append(num)
print("The count of reverse pairs (optimal approach) is:", oprevesrparis(arr))
