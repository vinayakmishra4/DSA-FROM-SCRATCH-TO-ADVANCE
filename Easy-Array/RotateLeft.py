# Rotate Left - Given an array of integers and a number, rotate the array to the left by that number of positions.
def rotate_left(arr, positions):
    n = len(arr)
    positions = positions % n  # Handle cases where positions > n
    return arr[positions:] + arr[:positions]

# Example usage:

num=int(input("Enter the number of positions to rotate left: "))
arr = list(map(int, input("Enter the array of integers (space-separated): ").split()))
result = rotate_left(arr, num)
print("Array after rotation:", result)

  