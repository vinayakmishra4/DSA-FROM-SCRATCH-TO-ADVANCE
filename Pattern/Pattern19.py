# pattern of pirymand of the alphabets

rows = int(input("Enter the row size for the pattern: "))
for i in range(1, rows + 1):  # Outer loop for rows
    for j in range(rows  - i):  # Inner loop for spaces
        print(" ", end=" ")
    for k in range(1, i + 1):  # Inner loop for aphabets
        print(chr(64+k), end=" ")
    for l in range(i - 1, 0, -1):  # Inner loop for aphabets in reverse 
        print(chr(64+l), end=" ")
    print()