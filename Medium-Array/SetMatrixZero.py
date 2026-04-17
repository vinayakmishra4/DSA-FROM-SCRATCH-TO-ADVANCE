# WAP to Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix..

# function to set the entire row and column to 0 if an element is 0
def setZeroes(matrix):
    # Get the number of rows and columns in the matrix
    rows = len(matrix)
    cols = len(matrix[0])

    # Create sets to keep track of rows and columns that need to be set to 0
    zero_rows = set()
    zero_cols = set()

    # Iterate through the matrix to find the positions of 0 elements
    for i in range(rows):
        for j in range(cols):
            if matrix[i][j] == 0:
                zero_rows.add(i)
                zero_cols.add(j)

    # Set the entire row and column to 0 for each position found
    for row in zero_rows:
        for j in range(cols):
            matrix[row][j] = 0

    # Set the entire column to 0 for each position found
    for col in zero_cols:
        for i in range(rows):
            matrix[i][col] = 0
    
    # Return the modified matrix
    return matrix

# Example usage
arr=[[1, 2, 3], [4, 0, 6], [7, 8, 9]]
result = setZeroes(arr)
print("Modified matrix:")
for row in result:
    print(row) 