/*
문제
수열 S가 어떤 수 Sk를 기준으로 S1 < S2 < ... Sk-1 < Sk > Sk+1 > ... SN-1 > SN을 만족한다면, 그 수열을 바이토닉 수열이라고 한다.

예를 들어, {10, 20, 30, 25, 20}과 {10, 20, 30, 40}, {50, 40, 25, 10} 은 바이토닉 수열이지만,  {1, 2, 3, 2, 1, 2, 3, 2, 1}과 {10, 20, 30, 40, 20, 30} 은 바이토닉 수열이 아니다.

수열 A가 주어졌을 때, 그 수열의 부분 수열 중 바이토닉 수열이면서 가장 긴 수열의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 부분 수열 중에서 가장 긴 바이토닉 수열의 길이를 출력한다.

예제 입력 1
10
1 5 2 1 4 3 4 5 2 1

예제 출력 1
7

힌트
예제의 경우 {1 5 2 1 4 3 4 5 2 1}이 가장 긴 바이토닉 부분 수열이다.
*/

// 다이나믹 프로그래밍

#include <iostream>
#pragma warning(disable:4996)
#define MAX 1000

using namespace std;

int main() {

	int N, num[MAX], tmp, frontMax = 1, frontLength = 1, backMax = 1, backLength = 1;

	scanf("%d", &N);

	for (int i = 0; i < N; i++)
		scanf("%d", &num[i]);

	for (int i = 0; i < N; i++) { // i값은 기준점(S_i)
		for (int j = 0; j < i; j++) {
			tmp = num[j];

			if (num[j] < num[i]) {
				frontLength++;
				for (int k = j + 1; k < i; k++) {
					if (num[k] > tmp && num[k] < num[i]) {
						tmp = num[k];
						frontLength++;
					}
				}
			}
			if (frontMax < frontLength)
				frontMax = frontLength;

			frontLength = 1;
		}

		for (int p = i + 1; p < N; p++) {
			tmp = num[p];

			if (num[p] < num[i]) {
				backLength++;
				for (int k = p + 1; k < N; k++) {
					if (num[k] > tmp && num[k] < num[i]) {
						tmp = num[k];
						backLength++;
					}
				}
			}
			if (backMax < backLength)
				backMax = backLength;

			backLength = 1;
		}
	}

	printf("%d", frontMax + backMax);

	return 0;
}