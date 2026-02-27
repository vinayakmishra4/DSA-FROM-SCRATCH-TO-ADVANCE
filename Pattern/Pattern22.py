# Floyd's Triangle Pattern in Python

rows=int(input("Enter the number of rows = "))

nums=1

for i in range(1,rows+1): # outer loop for rows
        for j in range(1,i+1): # outer loop for columns
                print(nums,end=" ") # print in the squence
                nums=nums+1
        print()

