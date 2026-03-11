# pattern plus sign in python

rows=int(input("Enter the number of rows: "))

for i in range(1,rows+1):
    for j in range(1,rows+1):
        if i==rows//2+1 or j==rows//2+1:
            print("*",end="")
        else:
            print(" ",end="")
    print()