'''
문제

입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

예제 입력 1 
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
예제 출력 1 
4
힌트
(1,4), (5,7), (8,11), (12,14) 를 이용할 수 있다.


'''

N = int(input())
meetings = [[tuple(map(int, input().split(' '))), 1] for _ in range(N)]
meetings.sort(reverse=True)
count = 1

end_time = meetings[0][0][0]
for i in range(1, N):
    if meetings[i][0][1] <= end_time:
        end_time = meetings[i][0][0]
        count += 1
print(count)