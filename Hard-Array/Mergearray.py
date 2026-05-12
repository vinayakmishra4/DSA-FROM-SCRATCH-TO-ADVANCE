# WAP to Merge two Sorted Arrays Without Extra Space
# geeks for geeks https://www.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
# leetcode https://leetcode.com/problems/merge-sorted-array/description/
# code360 https://www.naukri.com/code360/problems/merge-two-sorted-arrays-without-extra-space_6898839

# Method 1:Using Extra Space

def merge(arr1, arr2):
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

nums=int(input("Enter the size of first array: "))
arr1 = list(map(int, input("Enter the elements of first array: ").split()))
nums2=int(input("Enter the size of second array: "))
arr2 = list(map(int, input("Enter the elements of second array: ").split()))
result = merge(arr1, arr2)
print("Merged array:", result)
