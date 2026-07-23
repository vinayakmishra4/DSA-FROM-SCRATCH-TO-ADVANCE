#  WAP Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.
# Geek for Geeks :- https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
# coding ninjas :- https://www.codingninjas.com/codestudio/problems/n-th-root-of-m_893186?leftPanelTab=0

def nth_root(N, M):
    if N == 1:
        return M

    low, high = 1, max(1, M)

    while low <= high:
        mid = low + (high - low) // 2
        power = mid ** N

        if power == M:
            return mid
        elif power < M:
            low = mid + 1
        else:
            high = mid - 1

    return -1

N = int(input("Enter the value of N: "))
M = int(input("Enter the value of M: "))
result = nth_root(N, M)
if result != -1:
    print(f"The {N}th root of {M} is: {result}")
else:
    print(f"The {N}th root of {M} is not an integer.")