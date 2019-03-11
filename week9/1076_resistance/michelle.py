colors = []
answer = ''
resistance = [ ['black', 0, 1], ['brown', 1,10], ['red', 2, 100], 
['orange', 3, 1000], ['yellow', 4, 10000], ['green', 5, 100000],
['blue', 6, 1000000], ['violet', 7, 10000000], ['grey', 8, 100000000], 
['white', 9, 1000000000]]

for _ in range(3):
    n = input()
    colors.append(n)

for i in colors[0:2]:
    for j in resistance:
        if i == j[0]:
           answer += str(j[1])

for j in resistance:
    if colors[2] == j[0]:
        answer = int(answer) * j[2]

print(answer)