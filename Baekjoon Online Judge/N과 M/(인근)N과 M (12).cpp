/*
문제
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

N개의 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
고른 수열은 비내림차순이어야 한다.
길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
입력
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1
3 1
4 4 2
예제 출력 1
2
4
예제 입력 2
4 2
9 7 9 1
예제 출력 2
1 1
1 7
1 9
7 7
7 9
9 9
예제 입력 3
4 4
1 1 2 2
예제 출력 3
1 1 1 1
1 1 1 2
1 1 2 2
1 2 2 2
2 2 2 2
*/

// 백트래킹 문제

#include <iostream>
#include <algorithm>
#pragma warning(disable:4996)
#define MAX 7

using namespace std;

int N, M, cnt, start; // cnt: 방문한 원소의 개수, start: 원소 방문 시, for문에서 iterator 초기값(오름차순 구현하기 위해)
int buffer[MAX], num[MAX]; // buffer: M개의 숫자를 오름차순으로 저장할 배열, num: 출력될 숫자를 저장할 배열

void func(int cnt, int start);

int main() {

	int i, j;
	scanf("%d %d", &N, &M); // cout, cin 사용 시 시간 초과 -> printf, scanf로 변경

	for (i = 0; i < N; i++) {
		scanf("%d", &buffer[i]); // 배열값 입력받기

		for (j = 0; j < i; j++) { // 중복된 값 있는지 검사
			if (buffer[j] == buffer[i]) { // 중복된 값 있으면
				--i; // i 값 감소
				--N; // N 값 감소
			}
		}
	}
	sort(buffer, buffer + N); // 오름차순 정렬

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
		num[cnt] = buffer[i]; // buffer에 있는 원소 num에 저장
		func(cnt + 1, i); // 방문한 원소가 (cnt+1)개로 증가(Recursive)
	}
}