a = input().split(" ")
n = int(a[0])
k = int(a[1])
coins = []
cnt = 0

for _ in range(n):
    coins.append(int(input()))

for coin in coins[::-1]:
    if k >= coin:
        start = coin
        break

index = coins.index(start)

for coin in coins[index+1::-1]:
    num = (k // coin)
    k = k % coin
    cnt += num
print(cnt)