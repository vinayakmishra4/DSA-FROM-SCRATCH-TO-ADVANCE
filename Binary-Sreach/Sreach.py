# Binary Sreach Algorithm
def binary_search(arr, target):
    # Assuming arr is sorted in ascending order
    left, right = 0, len(arr) - 1

    # Loop until the search space is exhausted
    while left <= right:
        # Calculate the middle index
        mid = left + (right - left) // 2

        # Check if the target is present at mid
        if arr[mid] == target:
            return mid
        # If target is greater, ignore the left half
        elif arr[mid] < target:
            left = mid + 1
        # If target is smaller, ignore the right half
        else:
            right = mid - 1

    return -1  # Target not found

# Example usage
if __name__ == "__main__":
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    target = 5
    result = binary_search(arr, target)

    if result != -1:
        print(f"Element found at index: {result}")
    else:
        print("Element not found in the array.")