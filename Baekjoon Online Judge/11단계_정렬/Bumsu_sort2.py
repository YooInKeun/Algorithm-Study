'''
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
예제 입력 1 
5
5
4
3
2
1
예제 출력 1 
1
2
3
4
5
'''

#리스트 병합 함수
def merge_list(list1, list2):
    temp_list = []

    #list1, list2가 빌 때까지 반복
    #list1과 list2의 첫번째 인자 중 작은 것을 temo_list에 넣고 넣어진 것은 삭제
    while list1 and list2:
        if list1[0] < list2[0]:
            temp_list.append(list1[0])
            del(list1[0])
        else:
            temp_list.append(list2[0])
            del(list2[0])

    #list에 남아있는 것들을 이어 붙임
    if list1:
        temp_list += list1
    elif list2:
        temp_list += list2

    return temp_list

#main
N = int(input())
num = []

#입력받을때 길이가 1인 리스트형태
#num은 2중 리스트
for _ in range(N):
    num.append([int(input())])

#num 내부의 리스트들이 하나가 될때까지 반복
i = 0
while len(num) != 1:
    num[i] = merge_list(num[i], num[i+1]) #인접한 두 리스트를 병합
    del(num[i+1]) #병합된 리스트는 앞쪽 리스트에 저장되었으므로 뒷쪽 리스트는 제거

    #리스트 끝까지 돌았으면 i를 다시 0으로 바꿔서 리스트를 다시 돌게 함
    if i + 1 >= len(num) - 1:
        i = 0
    else:
        i += 1

#출력
for i in range(len(num[0])):
    print(num[0][i])