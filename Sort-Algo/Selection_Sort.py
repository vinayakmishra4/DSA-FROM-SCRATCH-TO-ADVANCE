def before_sort(arr):
    for num in arr:
        print(num, end=" ")
    print()


def selection_sort(arr):
    # Loop through each element in the array except the last one
    for i in range(len(arr) - 1):
        min_index = i

        # Find minimum element in the unsorted part
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j

        # Swap the found minimum with the first unsorted element
        swap(arr, i, min_index)


def after_sort(arr):
    for num in arr:
        print(num, end=" ")
    print()


def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


def main():
    # Ask user for size of array
    n = int(input("Enter the size of array: "))

    # Read array elements
    arr = []
    print("Enter the elements of the array:")
    for _ in range(n):
        arr.append(int(input()))

    print("Before sorting:")
    before_sort(arr)

    selection_sort(arr)

    print("After sorting:")
    after_sort(arr)


if __name__ == "__main__":
    main()
