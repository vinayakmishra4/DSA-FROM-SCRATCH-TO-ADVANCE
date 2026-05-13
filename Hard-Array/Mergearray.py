# WAP to Merge two Sorted Arrays Without Extra Space
# geeks for geeks https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
# leetcode https://leetcode.com/problems/merge-sorted-array/description/
# code360 https://www.naukri.com/code360/problems/merge-two-sorted-arrays-without-extra-space_6898839

# Method 1:Using Extra Space
def exmerge(arr1, arr2):
    merged = []
    i, j = 0, 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            merged.append(arr1[i])
            i += 1
        else:
            merged.append(arr2[j])
            j += 1
    # Append any remaining elements from either array
    merged.extend(arr1[i:])
    merged.extend(arr2[j:])
    return merged

# Method 2: Merge Without Using Extra Space
# arr1 should have enough empty spaces at the end

def merge(arr1, m, arr2, n):

    # i -> last valid element in arr1
    i = m - 1
    # j -> last element in arr2
    j = n - 1
    # k -> last position of merged array
    k = m + n - 1
    
    # Compare elements from the back
    # and place the larger one at the end
    while i >= 0 and j >= 0:

        if arr1[i] > arr2[j]:
            arr1[k] = arr1[i]
            i -= 1
        else:
            arr1[k] = arr2[j]
            j -= 1

        k -= 1

    return arr1 

nums=int(input("Enter the size of first array: "))
arr1 = list(map(int, input("Enter the elements of first array: ").split()))
nums2=int(input("Enter the size of second array: "))
arr2 = list(map(int, input("Enter the elements of second array: ").split()))
result = merge(arr1, arr2)
print("Merged array:", result)
