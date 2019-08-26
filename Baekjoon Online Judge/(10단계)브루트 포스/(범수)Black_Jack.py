N, M = map(int, input().split())
num = list(map(int, input().split()))
max_sum = 0

for i, item_x in enumerate(num[0:-2]):
    for j, item_y in enumerate(num[i+1:-1]):
        for k, item_y in enumerate(num[j+1:]):
            num_sum = item_x + item_y + item_y
            if num_sum <= M and num_sum > max_sum:
                max_sum = num_sum

print(max_sum)
            