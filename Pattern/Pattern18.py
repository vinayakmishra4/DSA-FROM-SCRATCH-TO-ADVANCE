# pattern of the alphabets of the inverted right angle triangle

rows=int(input("Enter the number of the rows"))

for i in range(rows,0,-1):
        for j in range(1,i+1):
                print(chr(64+j),end=" ")
        print()