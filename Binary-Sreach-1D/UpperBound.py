# WAP to find the upper bound in array using binary search
# geeks for geeks :-https://www.geeksforgeeks.org/problems/implement-upper-bound/1
# coding 360 :https://www.naukri.com/code360/problems/implement-upper-bound_8165383

def upperbound(arr, x):
    """
    Returns the index of the first element
    that is strictly greater than x.
    """

    low = 0
    high = len(arr)

    # Binary Search
    while low < high:
        mid = (low + high) // 2

        if arr[mid] <= x:
            # Upper bound must be on the right side
            low = mid + 1
        else:
            # Possible answer, search left for first occurrence
            high = mid

    return low


# -------- User Input --------

# Input the sorted array
arr = list(map(int, input("Enter sorted array elements: ").split()))

# Input the value whose upper bound is to be found
x = int(input("Enter value x: "))

# Find upper bound index
index = upperbound(arr, x)

# Display result
if index < len(arr):
    print(f"Upper bound of {x} is at index {index}, value = {arr[index]}")
else:
    print(f"No element greater than {x} exists in the array.")