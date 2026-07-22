# WAP to find out the square root of a number using binary search method.
# leetcode: 69
# geeks for geeks: https://www.geeksforgeeks.org/square-root-of-an-integer/

def sq_rt(x):
    left=0
    right=x
    while left<=right:
        mid=left+(right-left)//2
        if mid*mid==x:
            return mid
        elif mid*mid<x:
            left=mid+1
        else:
            right=mid-1
    return right

num=int(input("Enter a number: "))
print(sq_rt(num))