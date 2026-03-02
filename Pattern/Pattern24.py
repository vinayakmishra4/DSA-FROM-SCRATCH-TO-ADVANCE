# Buttery fly pattern

rows = int(input("Enter the row size for the pattern: "))
for i in range(1, rows + 1):  # Upper part of butterfly
    for j in range(1, i + 1):
        print("*", end=" ")
    for j in range(2 * (rows - i)):
        print(" ", end=" ")
    for j in range(1, i + 1):
        print("*", end=" ")
    print()
for i in range(rows, 0, -1):  # Lower part of butterfly
    for j in range(1, i + 1):
        print("*", end=" ")
    for j in range(2 * (rows - i)):
        print(" ", end=" ")
    for j in range(1, i + 1):
        print("*", end=" ")
    print()