# two sum with target sum
# using two pointers approach
def two_sum(nums, target):
    nums.sort()
    left, right = 0, len(nums) - 1

    while left < right:
        current_sum = nums[left] + nums[right]

        if current_sum == target:
            return [nums[left], nums[right]]
        elif current_sum < target:
            left += 1
        else:
            right -= 1

    return []

# Example usage
num=int(input("Enter the number of elements in the array: "))
nums = []
print("Enter the elements of the array:")
for _ in range(num):
    nums.append(int(input()))
target = int(input("Enter the target sum: "))
result = two_sum(nums, target)
if result:
    print(f"Two numbers that add up to {target} are: {result[0]} and {result[1]}")
else:
    print(f"No two numbers add up to {target}.")
