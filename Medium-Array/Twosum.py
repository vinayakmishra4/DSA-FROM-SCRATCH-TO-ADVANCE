# WAP to Check if a pair with given sum exists in Array

def two_sum(arr, target):
    seen = set()
    for num in arr:
        complement = target - num
        if complement in seen:
            return True
        seen.add(num)
    return False

num=int(input("Enter the number of elements in the array: "))
arr = list(map(int, input("Enter the elements of the array: ").split()))
target=int(input("Enter the target sum: "))
if two_sum(arr, target):
    print("A pair with the given sum exists in the array.")
else:
    print("No pair with the given sum exists in the array.")