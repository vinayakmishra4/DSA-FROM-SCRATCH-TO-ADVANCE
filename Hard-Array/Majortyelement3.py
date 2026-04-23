# WAP to find the majority element in an array. A majority element is an element that appears more than n/3 times in the array.
def majority_element(nums):
    count = {}
    for num in nums:
        if num in count:
            count[num] += 1
        else:
            count[num] = 1

    for num, freq in count.items():
        if freq > len(nums) // 3:
            return num

    return None

nums=int(input("Enter the number of elements in the array: "))
arr=[]
for i in range(nums):
    element=int(input("Enter the element: "))
    arr.append(element)
result = majority_element(arr)
print("The majority element is:", result)