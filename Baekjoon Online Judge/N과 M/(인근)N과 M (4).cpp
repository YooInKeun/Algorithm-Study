/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1
3 1
예제 출력 1
1
2
3
예제 입력 2
4 2
예제 출력 2
1 1
1 2
1 3
1 4
2 2
2 3
2 4
3 3
3 4
4 4
예제 입력 3
3 3
예제 출력 3
1 1 1
1 1 2
1 1 3
1 2 2
1 2 3
1 3 3
2 2 2
2 2 3
2 3 3
3 3 3
*/

// 백트래킹 문제

#include <iostream>
#pragma warning(disable:4996)
#define MAX 8

using namespace std;

int N, M, cnt, start; // cnt: 방문한 원소의 개수, start: 원소 방문 시, for문에서 iterator 초기값(오름차순 구현하기 위해)
int num[MAX]; // M개의 숫자를 저장할 배열

void func(int cnt, int start);

int main() {

	scanf("%d %d", &N, &M); // cout, cin 사용 시 시간 초과 -> printf, scanf로 변경
	func(0, 0); // 방문한 원소가 0개일 때부터 시작

	return 0;
}

void func(int cnt, int start) {

	if (cnt == M) { // 방문한 원소의 개수가 M값(= 출력해야 하는 숫자 개수)과 같다면
		for (int i = 0; i < M; i++) {
			printf("%d ", num[i]); // 방문한 원소들을 모두 출력
		}
		printf("\n");
		return; // 그리고 끝내기
	}

	for (int i = start; i < N; i++) {
		num[cnt] = i + 1; // index값이 cnt인 곳에 (i+1)을 할당
		func(cnt + 1, i); // 방문한 원소가 (cnt+1)개로 증가(Recursive)
	}
}