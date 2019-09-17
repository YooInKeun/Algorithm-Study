'''
문제
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.

사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

입력
첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.

예제 입력 1 
3 10
1
2
5
예제 출력 1 
10
'''

n, k = map(int, input().split())

coins = [int(input())]
M = [[1], [1 for _ in range(k + 1)]]

for value in range(1, k + 1):
    if value % coins[0] == 0:
        M[0].append(1)
    else:
        M[0].append(0)

for i in range(1, n):
    coins.append(int(input()))

    for value in range(1, k + 1):
        case = 0
        for index, coin in enumerate(coins):
            if value - coin >= 0:
                case += M[index][value - coin]
        M[1][value] = case

    if i != n - 1:
        small_index = 1 if coins[0] > coins[1] else 0
        gab = abs(coins[0] - coins[1])
        coins[0] = coins[small_index]
        del(coins[1])
        if small_index:
            for value in range(gab, k + 1):
                M[1][value] += M[0][value - gab]
            M[0] = [case for case in M[1]]
        else:
            for value in range(gab, k + 1):
                M[0][value] += M[1][value - gab]
print(M[1][k])

