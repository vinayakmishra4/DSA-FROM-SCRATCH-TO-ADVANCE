# WAP to find the unique element in an array

def find_unique(arr):
    unique_element = 0
    for num in arr:
        unique_element ^= num
    return unique_element

nums=int(input("Enter the number of elements in the array: "))
arr = []
print("Enter the elements of the array:")
for _ in range(nums):
    arr.append(int(input()))
unique = find_unique(arr)
print("The unique element in the array is:", unique)
