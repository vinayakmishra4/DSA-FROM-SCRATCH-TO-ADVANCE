# print the square number pattern

rows=int(input("Enter the number of rows: "))

for i in range(1,rows+1):
    for j in range(1,rows+1):
        print(j,end=" ")
    print()