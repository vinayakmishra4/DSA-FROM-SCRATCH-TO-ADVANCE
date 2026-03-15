# find the second largest in the array

def secondlargest(arr):
    if not arr:
        return None  # Return None for an empty array

    largest = arr[0]  # Initialize largest with the first element

    for num in arr:
        if num > largest:
            largest = num  # Update largest if current number is greater
    
    secondLargest = -1
    for num in arr:
        if num != largest and num > secondLargest:
              secondLargest=num
    
    return secondLargest

number_of_elements = int(input("Enter the number of elements in the array: "))
array = []
print("Enter the elements of the array:")
for _ in range(number_of_elements):
    element = int(input())
    array.append(element)
largest_element = find_largest(array)
if largest_element is not None:
    print(f"The largest element in the array is: {largest_element}")
else:
    print("The array is empty.")