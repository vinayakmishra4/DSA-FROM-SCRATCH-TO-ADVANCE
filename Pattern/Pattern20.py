# Pattern of inverted priymand of aplhabets

rows=int(input("Enter the number of pattern"))

for i in range(rows, 0, -1):  # Outer loop for rows in reverse
    for j in range(rows - i):  # Inner loop for spaces
        print(" ", end=" ")
    for k in range(1, i + 1):  # Inner loop for numbers
        print(chr(64+k), end=" ")
    for l in range(i - 1, 0, -1):  # Inner loop for reverse numbers
        print(chr(64+l), end=" ")
    print()
    