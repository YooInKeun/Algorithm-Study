/*
문제
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.

한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.

김정인 버젼의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.

이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.

N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는다.

합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

예제 입력 1
5 21
5 6 7 8 9
예제 출력 1
21
*/

// 브루트 포스

#include <iostream>
#pragma warning(disable:4996)

using namespace std;

int main() {

	int N, M, sum = 0, tmp = 0; // sum: 합계, tmp: 이전 sum 값
	int arr[100];

	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}

	// 3중 for문, 초기값 주의
	for (int i = 0; i < N - 2; i++){
		for (int j = i + 1; j < N - 1; j++) {
			for (int k = j + 1; k < N; k++) {

				sum = arr[i] + arr[j] + arr[k]; // sum 저장
				if (sum <= M && sum > tmp) { // 합계가 M을 넘지 않고, 이전 값보다 크다면
					sum = arr[i] + arr[j] + arr[k]; // sum 갱신
					tmp = sum; // sum 값 임시 저장
				}
			}
		}
	}

	printf("%d", sum);

	return 0;
}
