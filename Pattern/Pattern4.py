n=int(input("Enter the number for print pattern of Inverted Pyramid Pattern"))

for i in range(n,0,-1):
    for j in range(n-i):
        print(" ",end=" ")
    for k in range(1,2*i):
        print("*",end=" ")
    print()