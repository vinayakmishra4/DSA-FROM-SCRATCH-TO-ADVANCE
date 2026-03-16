# Function to check if an array is sorted

def is_sorted(arr):
    for i in range(len(arr) - 1):
        if arr[i] > arr[i + 1]:
            return False
    return True

number_of_elements = int(input("Enter the number of elements in the array: "))
array = []
print("Enter the elements of the array:")
for _ in range(number_of_elements):
    element = int(input())
    array.append(element)
if is_sorted(array):
    print("The array is sorted.")
else:
    print("The array is not sorted.")

