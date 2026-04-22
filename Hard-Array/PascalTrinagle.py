# WAP to print the pascal triangle

# Pascal's Triangle is a triangular array of numbers where each number is the sum of the two numbers directly above it in the previous row. The first and last number of each row is always 1. The nth row of Pascal's Triangle contains the binomial coefficients, which can be calculated using the formula: C(n, k) = n! / (k! * (n - k)!), where n is the row number and k is the position in the row.
def pascal_triangle(nums):
    # Loop through each row of the triangle
    for i in range(nums):
        # Print spaces to center the triangle
        for j in range(nums - i - 1):
            print(" ", end="")
        
        # Loop through each element in the row and calculate the binomial coefficient
        for j in range(i + 1):
            print(f"{factorial(i) // (factorial(j) * factorial(i - j))} ", end=" ")
        print()

# A helper function to calculate the factorial of a number
def factorial(num):
    # Base case: factorial of 0 or 1 is 1
    if num == 0 or num == 1:
        return 1
    # Recursive case: factorial of n is n multiplied by factorial of (n - 1)
    else:
        return num * factorial(num - 1)

num = int(input("Enter the number of rows for Pascal's Triangle: "))
pascal_triangle(num)
print("Pascal's Triangle printed successfully!")
