# WAP to find out the missing the array using XOR opreations 

def missing(arr):
    n = len(arr) + 1  # Since one number is missing, total should be n
    xor1 = 0
    xor2 = 0
    for i in range(1, n+1):
        xor1 = xor1 ^ i
    for num in arr:
        xor2 = xor2 ^ num
    return xor1 ^ xor2

num = int(input("Enter the number of elements (n-1, where n is the range 1 to n)"))
arr = []
for i in range(num):
    element = int(input())
    arr.append(element)    

print("The Missing Number = ", missing(arr))