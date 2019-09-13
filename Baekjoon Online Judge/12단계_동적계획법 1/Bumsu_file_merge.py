

T = int(input())

result = []
for _ in range(T):
    K = int(input())
    M = [[0 for _ in range(K)] for _ in range(K)]
    costs = list(map(int, input().split(' ')))

    for i in range(0, K):
        M[i][i] = costs[i]
    for i in range(0, K - 1):
        M[i][i + 1] = M[i][i] + M[i + 1][i + 1]
    
    i = 0
    j = 2
    loop_cnt = 0
    while M[0][K - 1] == 0:
        min_cost = min(M[i][j - 1], M[i + 1][j])
        for k in range(i + 1, j - 1):
            if min_cost > M[i][k] + M[k + 1][j]:
                min_cost = M[i][k] + M[k + 1][j]

        sum_cost = 0
        for k in range(i, j + 1):
            sum_cost += costs[k]
        M[i][j] = min_cost + sum_cost

        if j == K - 1:
            loop_cnt += 1
            i = 0
            j = 2 + loop_cnt
        else:
            i = i + 1
            j = j + 1

    result.append(M[0][K-1])

for value in result:
    print(value)