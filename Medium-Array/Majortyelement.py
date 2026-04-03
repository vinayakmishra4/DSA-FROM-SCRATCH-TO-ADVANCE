# WAP to find the majority element in an array. The majority element is the element that appears more than n/2 times in the array.

def majority_element(nums):
    count = {}
    for num in nums:
        if num in count:
            count[num] += 1
        else:
            count[num] = 1

    for num, freq in count.items():
        if freq > len(nums) // 2:
            return num

    return None

arr = []
n = int(input("Enter the number of elements in the array: "))
print("Enter the elements of the array:")
for i in range(n):
    element=int(input())
    arr.append(element)
result = majority_element(arr)
print("The majority element is:", result)
