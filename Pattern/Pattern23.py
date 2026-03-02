# print pascal triangle in python

rows = int(input("Enter the row size for the pattern: "))
for i in range(rows ):  # Outer loop for rows
    num = 1
    for j in range(rows - i):  # Inner loop for spaces
        print(" ", end=" ")
    for k in range(i + 1):  # Inner loop for numbers
        print(num, end="   ")
        num = num * (i - k) // (k + 1)  # Calculate Pascal's number
    print()
