# Optimized Bubble Sort implementation in Python

def bubble_sort_optimized(arr):
    n = len(arr)

    for i in range(n):
        # Flag to check if any swap happens in this pass
        swapped = False
        
        # Loop through the array up to n - i - 1
        for j in range(0, n - i - 1):

            # If the current element is greater than the next, swap them
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True  # A swap occurred
        
        # If no swaps happened in the inner loop, array is already sorted
        if not swapped:
            break  # Exit early for efficiency
    
    return arr


# Take user input
n = int(input("Enter number of elements: "))
numbers = []

# Read n elements from the user
for i in range(n):
    num = int(input(f"Enter element {i+1}: "))
    numbers.append(num)

# Sort the array using optimized bubble sort
sorted_numbers = bubble_sort_optimized(numbers)

# Print the sorted result
print("Sorted array is:", sorted_numbers)
