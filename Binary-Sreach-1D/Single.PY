# WAP to find out the single element in a sorted array where every element appears twice except for one.

def single_element(arr):
    low = 0
    high = len(arr) - 1

    while low < high:
        mid = low + (high - low) // 2

        # Check if mid is even or odd
        if mid % 2 == 0:
            if arr[mid] == arr[mid + 1]:
                low = mid + 2
            else:
                high = mid
        else:
            if arr[mid] == arr[mid - 1]:
                low = mid + 1
            else:
                high = mid - 1

    return arr[low]


num = int(input("Enter the number of elements in the array: "))
arr = []
for i in range(num):
    element = int(input(f"Enter element {i + 1}: "))
    arr.append(element)

result = single_element(arr)
print(f"The single element in the array is: {result}")
