# WAP to sort an array of 0s, 1s and 2s without using any sorting algo
def sort012(arr):
    # Initialize pointers for next positions of 0, 1 and 2
    low = mid = 0
    high = len(arr) - 1
    while mid <= high:
        if arr[mid] == 0:
            arr[low], arr[mid] = arr[mid], arr[low]
            low += 1
            mid += 1
        elif arr[mid] == 1:
            mid += 1
        else:  # arr[mid] == 2
            arr[mid], arr[high] = arr[high], arr[mid]
            high -= 1

arr=[]
n=int(input("Enter the number of elements in the array: "))
print("Enter the elements (0s, 1s and 2s only):")
for i in range(n):
    arr.append(int(input()))
sort012(arr)
print("Sorted array:", arr)