# WAP to rearrange an array such that if postive integer at postive index and negative intger at odd index and if any postive integer is at odd index or negative integer is at even index then replace it with -1

def rearrangeArray(nums):
    n = len(nums)
    result = [0] * n

    posIndex = 0
    negIndex = 1

    for num in nums:
        if num > 0:
            result[posIndex] = num
            posIndex += 2
        else:
            result[negIndex] = num
            negIndex += 2

    return result

arr=[]
n=int(input("Enter the size of the array: "))
print("Enter the elements of the array: ")
for i in range(n):
    arr.append(int(input()))
result = rearrangeArray(arr)
print("Rearranged array: ", result)
