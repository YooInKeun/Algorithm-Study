/*
문제
오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다.
첫 삼각형은 정삼각형으로 변의 길이는 1이다.
그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.

파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

출력
각 테스트 케이스마다 P(N)을 출력한다.

예제 입력 1
2
6
12
예제 출력 1
3
16
*/

// 다이나믹 프로그래밍

#include <iostream>
#pragma warning(disable:4996)
#define MAX 99999

using namespace std;

int main() {

	int T, num[MAX];
	unsigned long long P[100]; // *주의 : N값에 따라 숫자가 큰 폭으로 커지기 때문에, P(N)값을 unsigned long long으로 선언
	P[0] = P[1] = P[2] = 1; // P(1), P(2), P(3) 초기화

	scanf("%d", &T);

	for (int i = 0; i < T; i++)
		scanf("%d", &num[i]);
	
	for (int i = 0; i < T; i++) {
		if (num[i] == 1 || num[i] == 2 || num[i] == 3) // P(1), P(2), P(3)인 경우
			cout << P[0] << endl; // 1 출력
		else {
			for (int j = 0; j < num[i] - 3; j++) // N이 4 이상인 경우
				P[j + 3] = P[j + 1] + P[j]; // 파도반 수열 공식

			cout << P[num[i] - 1] << endl; // 정답 출력
		}
	}

	return 0;
}