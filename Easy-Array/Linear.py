# linear srearch in python

def linear_search(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1


number_of_elements = int(input("Enter the number of elements in the array: "))
array = []

print("Enter the elements of the array:")
for _ in range(number_of_elements):
    element = int(input())
    array.append(element)

target_value = int(input("Enter the target value to search: "))
result = linear_search(array, target_value)
if result != -1:
    print(f"Element found at index: {result}")
else:
    print("Element not found in the array.")