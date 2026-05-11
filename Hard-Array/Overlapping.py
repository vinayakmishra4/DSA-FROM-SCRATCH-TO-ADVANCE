# https://leetcode.com/problems/merge-intervals/description/ leetcode
# https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1 geeks for geeks
# https://www.naukri.com/code360/problems/merge-all-overlapping-intervals_6783452 code360
# WAP to iven an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals and return an array of the non-overlapping intervals that cover all the intervals in the input.

# brute force approch
def beoverlapping(arr):

    # Step 1: Sort intervals based on starting value
    arr.sort()
    # Start from the first interval
    i = 0
    # Loop until the second last interval
    while i < len(arr) - 1:

        # Current interval
        current = arr[i]
        # Next interval
        nxt = arr[i + 1]
        # Step 2: Check if intervals overlap
        # Overlap exists if current ending >= next starting
        if current[1] >= nxt[0]:

            # Step 3: Merge intervals
            # Keep the larger ending value
            current[1] = max(current[1], nxt[1])
            # Remove the next interval because it is merged
            arr.pop(i + 1)

        else:
            # Move to next interval if no overlap
            i += 1

    # Return merged intervals
    return arr

# optimal approch
def beoverlapping(arr):
    # Step 1: Sort intervals based on starting value
    arr.sort()
    merged = []
    
    for interval in arr:
        # If merged is empty or current interval does not overlap with the last one in merged
        if not merged or merged[-1][1] < interval[0]:
            merged.append(interval)
        else:
            # Overlap exists, merge with the last interval in merged
            merged[-1][1] = max(merged[-1][1], interval[1])
    
    return merged

rows = int(input("Enter number of rows: "))
cols = int(input("Enter number of columns: "))

nested_list = []

for i in range(rows):
    row = []
    
    for j in range(cols):
        value = int(input(f"Enter value for [{i}][{j}]: "))
        row.append(value)
    
    nested_list.append(row)

print("Nested List:")
print(nested_list)