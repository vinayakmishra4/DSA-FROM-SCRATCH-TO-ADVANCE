# write a program for to print the following pattern of  Hollow Sqaure 

def hollow_square_pyramid(n):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i == 1 or i == n or j == 1 or j == n:
                print("*", end=" ")
            else:
                print(" ", end=" ")
        print()


# Driver code
n=int(input("Enter the number of rows: "))
hollow_square_pyramid(n)