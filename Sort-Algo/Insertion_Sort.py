# Function to print array before sorting
def before_sort(arr):
    for num in arr:
        print(num, end=" ")
    print()

# Function to perform insertion sort
def insertion(arr):
    for i in range(1, len(arr)):
        temp = arr[i]   # current element
        j = i - 1        # previous index
        
        # Move elements greater than temp to one position ahead
        while j >= 0 and arr[j] > temp:
            arr[j + 1] = arr[j]
            j -= 1
        
        arr[j + 1] = temp  # place temp at correct position

# Function to print array after sorting
def after_sort(arr):
    for num in arr:
        print(num, end=" ")
    print()

# Main function
def main():
    # Ask user for array size
    print("Enter the size of array")
    n = int(input())

    arr = []

    # Input array elements
    print("Enter the number of elements in arr")
    for _ in range(n):
        arr.append(int(input()))

    # Before sorting
    print("Before sorting")
    before_sort(arr)

    # Sorting using insertion sort
    insertion(arr)

    # After sorting
    print("After sorting")
    after_sort(arr)

# Run main
if __name__ == "__main__":
    main()
