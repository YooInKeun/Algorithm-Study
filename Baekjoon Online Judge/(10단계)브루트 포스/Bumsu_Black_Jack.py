N, M = map(int, input().split())
num = list(map(int, input().split(' ')))
max_sum = 0

for i in range(0, N-2):
    for j in range(i+1,N-1):
        for k in range(j+1,N):
            num_sum = num[i] + num[j] + num[k]
            if num_sum <= M and num_sum > max_sum:
                max_sum = num_sum
            if max_sum == M:
                break
        if max_sum == M:
            break
    if max_sum == M:
        break

print(max_sum)
            