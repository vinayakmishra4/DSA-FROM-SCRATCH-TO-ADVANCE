# print the zigzag pattern


rows=int(input("Enter the number of rows: "))

for i in range(1,rows+1): # outer loop for rows
    for j in range(1, rows+1): # inner loop for columns
        if (i+j)%2==0: # print the zigzag pattern
            print("1", end="")
        else:
            print("0", end="")
    print()