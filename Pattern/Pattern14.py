rows = int(input("Enter the row size for the pattern: "))
for i in range(1, rows + 1):  # Outer loop for rows
    for j in range(rows  - i):  # Inner loop for spaces
        print(" ", end=" ")
    for k in range(1, i + 1):  # Inner loop for numbers
        print(k, end=" ")
    for l in range(i - 1, 0, -1):  # Inner loop for reverse numbers
        print(l, end=" ")
    print()