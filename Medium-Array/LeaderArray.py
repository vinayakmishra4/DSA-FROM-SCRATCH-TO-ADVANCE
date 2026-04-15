# WAP Program to print the largest elements (leaders) in the array first

def leader_array(arr):
    n = len(arr)                     # Get the length of the array
    leaders = []                     # List to store leader elements

    max_from_right = arr[n-1]        # Start with the last element
    leaders.append(max_from_right)   # Last element is always a leader

    # Traverse the array from right to left (excluding last element)
    for i in range(n-2, -1, -1):
        # If current element is greater than max seen so far from right
        if arr[i] > max_from_right:
            max_from_right = arr[i]  # Update max_from_right
            leaders.append(max_from_right)  # Add it as a leader

    leaders.reverse()                # Reverse to maintain original order
    return leaders                   # Return the list of leaders

arr=[]
n=int(input("Enter the number of elements in the array: "))
for i in range(n):
    element=int(input("Enter element: "))
    arr.append(element)
leaders=leader_array(arr)
print("The leader elements in the array are: ",leaders)
