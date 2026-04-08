# WAP to to buy and sell stock to maximize profit. You can only complete at most one transaction (i.e., buy one and sell one share of the stock).

# function to calculate the maximum profit from a list of stock prices
def maxProfit(arr):
    # check if the list of prices is empty
    if not arr:
        return 0
    
    # initialize the minimum price to the first price in the list and the maximum profit to 0
    min_price = arr[0]
    max_profit = 0

    # iterate through the list of prices
    for price in arr:
        if price < min_price:
            min_price = price
        else:
            max_profit = max(max_profit, price - min_price)

    # return the maximum profit
    return max_profit

arr=[]
n=int(input("Enter the number of stock prices: "))
print("Enter the stock prices: ")
for i in range(n):
    price=int(input())
    arr.append(price)
profit = maxProfit(arr)
print("Maximum profit: ", profit)