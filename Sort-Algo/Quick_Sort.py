def print_array(arr):
    for num in arr:
        print(num, end=" ")
    print()


def quick_sort(arr, low, high):
    if low < high:
        pi = partition(arr, low, high)

        quick_sort(arr, low, pi - 1)
        quick_sort(arr, pi + 1, high)


def partition(arr, low, high):
    pivot = arr[high]
    i = low - 1

    for j in range(low, high):
        if arr[j] <= pivot:
            i += 1
            swap(arr, i, j)

    swap(arr, i + 1, high)
    return i + 1


def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


# Main Section
if __name__ == "__main__":
    n = int(input("Enter size of array: "))

    arr = []
    print("Enter elements of array:")
    for _ in range(n):
        arr.append(int(input()))

    print("Array before sorting:")
    print_array(arr)

    quick_sort(arr, 0, n - 1)

    print("Array after sorting:")
    print_array(arr)
