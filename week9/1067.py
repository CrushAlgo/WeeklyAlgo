# 4
# 1 2 3 4
# 6 7 8 5
# 출력: 70


n = int(input())
x = input()
y = input()

answer = []

list_x = x.split(" ")
list_y = y.split(" ")

print(n)
print(list_x)
print(list_y)

for i in list_x:
    list_x.replace(i, int(i))

print(list_x)


for i in range(n):
    sum = 0
    # print("===={}=====".format(i))
    for j in range(n):
        index = (i+j) % n
        sum += (int(list_x[index]) * int(list_y[j]))
    answer.append(sum)

print(max(answer))

