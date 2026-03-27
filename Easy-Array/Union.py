# WAP to find the union of two arrays. The union of two arrays is a list that contains all the unique elements from both arrays. For example, if the first array is [1, 2, 3] and the second array is [3, 4, 5], then the union of these two arrays would be [1, 2, 3, 4, 5].


def union_of_arrays(arr1, arr2): 
    # Create a set to store unique elements
    union_set = set() 

    # Add elements of the first array to the set
    for num in arr1: 
        union_set.add(num) 

    # Add elements of the second array to the set
    for num in arr2: 
        union_set.add(num) 

    # Convert the set back to a list and return it
    return list(union_set)

num=int(input("Enter the number of elements in the first array: "))
arr1 = []
print("Enter the elements of the first array: ")
for i in range(num):
    arr1.append(int(input()))
num=int(input("Enter the number of elements in the second array: "))
arr2 = []
print("Enter the elements of the second array: ")
for i in range(num):
    arr2.append(int(input()))

result = union_of_arrays(arr1, arr2)
print("The union of the two arrays is: ", result)