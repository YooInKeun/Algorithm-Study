'''
문제

N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다. 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다. 이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다. 아래는 5명으로 이루어진 집단에서 각 사람의 덩치와 그 등수가 표시된 표이다.

이름	<몸무게, 키>	덩치 등수
A	<55, 185>	2
B	<58, 183>	2
C	<88, 186>	1
D	<60, 175>	2
E	<46, 155>	5
위 표에서 C보다 더 큰 덩치의 사람이 없으므로 C는 1등이 된다. 그리고 A, B, D 각각의 덩치보다 큰 사람은 C뿐이므로 이들은 모두 2등이 된다. 그리고 E보다 큰 덩치는 A, B, C, D 이렇게 4명이므로 E의 덩치는 5등이 된다. 위 경우에 3등과 4등은 존재하지 않는다. 여러분은 학생 N명의 몸무게와 키가 담긴 입력을 읽어서 각 사람의 덩치 등수를 계산하여 출력해야 한다.

입력
첫 줄에는 전체 사람의 수 N이 주어진다. 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다. 단, 2 ≤ N ≤ 50, 10 ≤ x,y ≤ 200 이다.

출력
여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 단, 각 덩치 등수는 공백문자로 분리되어야 한다.

예제 입력 1 
5
55 185
58 183
88 186
60 175
46 155
예제 출력 1 
2 2 1 2 5
'''

""" 
N = int(input())
people = []
result = []

for _ in range(N):
    people.append(list(map(int, input().split(' '))))
    result.append(1)

for i in range(0, N-1):
    for j in range(i+1, N):
        if people[i] == people[j]:
            continue
        weight_first = people[i][0] > people[j][0]
        height_first = people[i][1] > people[j][1]
        weight_same = people[i][0] == people[j][0]
        height_same = people[i][1] == people[j][1]

        if weight_first and height_first:
            result[j] += 1
        elif not (weight_first or height_first):
            result[i] += 1
        elif weight_same:
            if height_first:
                result[j] += 1
            else:
                result[i] += 1
        elif height_same:
            if weight_first:
                result[j] += 1
            else:
                result[i] += 1

print(" ".join(map(str, result))
"""


N = int(input())
people = []
result = []

for _ in range(N):
    people.append(list(map(int, input().split(' '))))
    result.append(1)

for i in range(0, N):
    for j in range(0, N):
        if people[i] == people[j]:
            continue
        weight_first = people[i][0] > people[j][0]
        height_first = people[i][1] > people[j][1]

        if weight_first and height_first:
            result[j] += 1

for item in result:
    print(item)