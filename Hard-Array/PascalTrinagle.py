# WAP to print the pascal triangle
def pascal_triangle(nums):
    for i in range(nums):
        for j in range(nums - i - 1):
            print(" ", end="")
        
        for j in range(i + 1):
            print(f"{factorial(i) // (factorial(j) * factorial(i - j))} ", end=" ")
        print()

def factorial(num):
    if num == 0 or num == 1:
        return 1
    else:
        return num * factorial(num - 1)

num = int(input("Enter the number of rows for Pascal's Triangle: "))
pascal_triangle(num)
print("Pascal's Triangle printed successfully!")
