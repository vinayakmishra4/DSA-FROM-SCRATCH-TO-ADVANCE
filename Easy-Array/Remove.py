# WAP to remove the duplicate elment in the array

def remove_duplicate(arr):
    unique_elements = []
    for element in arr:
        if element not in unique_elements:
            unique_elements.append(element)
    return unique_elements


# input array

num=int(input("Enter the number of elements in the array: "))
arr = []
for i in range(num):
    element = int(input("Enter element {}: ".format(i + 1)))
    arr.append(element)

# remove duplicates
result = remove_duplicate(arr)
print("Array after removing duplicates:", result)
