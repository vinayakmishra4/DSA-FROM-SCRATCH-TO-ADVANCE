#  Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise. The rotation must be done in place, meaning the input 2D matrix must be modified directly..
def rotate(matrix):
    n = len(matrix)
    for i in range(n):
        for j in range(i, n):
            matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
    for i in range(n):
        matrix[i].reverse()

# Example usage:
matrix = [[1, 2, 3],
          [4, 5, 6],
            [7, 8, 9]]

rotate(matrix)
print(matrix)  # Output: [[7, 4, 1], [8,