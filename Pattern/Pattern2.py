rows = int(input("Enter the row size for the pattern: "))
for i in range(rows, 0, -1):  # Outer loop for rows in reverse
    for j in range(1, i + 1):  # Inner loop for columns
        print("*", end=" ")   # Print star
    print()