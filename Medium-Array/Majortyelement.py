# WAP to find the majority element in an array. The majority element is the element that appears more than n/2 times in the array.

def majority_element(nums):
    count = 0
    candidate = None

    for num in nums:
        if count == 0:
            candidate = num
        count += (1 if num == candidate else -1)

    return candidate

arr=[]
n=int(input("Enter the number of elements in the array: "))
print("Enter the elements of the array:")
for i in range(n):
    element=int(input())
    arr.append(element)
result = majority_element(arr)
print("The majority element is:", result)
