# hollow butterfly pattern in python


rows = int(input("Enter the number of rows: "))

for i in range(1, rows + 1): # loop for upper half of the pattern
    for j in range(1, i + 1): # loop for left wing of the butterfly
        if j == 1 or j == i: # condition to print stars at the edges
            print("*", end="")
        else:
            print(" ", end="") # print space for hollow part
    for j in range(1, (rows - i) * 2 + 1): # loop for space between the wings
        print(" ", end="")
    for j in range(1, i + 1): # loop for right wing of the butterfly
        if j == 1 or j == i: # condition to print stars at the edges
            print("*", end="")
        else:
            print(" ", end="") # print space for hollow part
    print() # move to the next line