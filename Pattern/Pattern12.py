# WAP to Number Right-Angled Triangle Pattern in Python 

number=int(input("Enter the number of rows: "))

def number_right_angled_triangle(n):
    for i in range(1, n + 1):
        for j in range(1, i + 1):
            print(j, end=" ")
        print()

number_right_angled_triangle(number)

