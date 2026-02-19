# pattern for the right angle triangle of the alphabets
rows=int(input("Enter the rows"))

for i in range(1,rows+1):
    for j in range(1,i+1):
        print(chr(64+j),end=" ")
    print()