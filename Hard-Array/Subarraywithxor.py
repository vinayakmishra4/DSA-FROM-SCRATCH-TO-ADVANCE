# WAP to find Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.
from collections import defaultdict
# brute force approach
def brsubarraywithxor(a, b):

    # Get the length of the array
    n = len(a)
    # Variable to store the count of subarrays
    count = 0# Pick every starting index
    for i in range(n):
        
        # Initialize XOR value for each new subarray
        current_xor = 0
        # Extend the subarray from index i to j
        for j in range(i, n):
            
            # Calculate XOR of elements
            current_xor ^= a[j]
            # If XOR becomes equal to b
            if current_xor == b:

                # Increase the count
                count += 1

    # Return total count of subarrays
    return count


# Optimal Approach
def opsubarrayWithXor(a, b):
    freq = defaultdict(int)

    # Prefix XOR 0 occurs once initially
    freq[0] = 1

    prefix_xor = 0
    count = 0

    for num in a:
        # Compute prefix XOR
        prefix_xor ^= num

        # Required previous XOR
        required = prefix_xor ^ b

        # Add matching prefixes
        count += freq[required]

        # Store current prefix XOR
        freq[prefix_xor] += 1

    return count

# Input array elements
arr = list(map(int, input("Enter array elements: ").split()))
# Input XOR value
k = int(input("Enter XOR value: "))
# Function call
result = brsubarraywithxor(arr, k)
# Print result
print("Total subarrays with XOR =", k, "is:", result)