t = int(input())
numbers = []

for _ in range(t):
    numbers.append(int(input()))

for number in numbers:
    double_number = str(pow(number, 2))
    s = len(str(number))
    if int(double_number[-s:]) == number:
        print("YES")
    else:
        print("NO")