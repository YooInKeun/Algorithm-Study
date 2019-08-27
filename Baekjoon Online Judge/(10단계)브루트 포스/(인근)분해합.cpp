/*
문제
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다.
반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

예제 입력 1
216
예제 출력 1
198
*/

// 브루트 포스

#include <iostream>
#pragma warning(disable:4996)

using namespace std;

int main() {

	int N;
	int num, answer; // num: 분해합 값, answer: 생성자 값 
	int a, b, c, d, e, f; // a: 십만의 자리수, b: 만의 자리수, c: 천의 자리수, d: 백의 자리수, e: 십의 자리수, f: 일의 자리수
	bool exitOuterLoop = false; // 정답 발견 시, 중첩 루프 빠져나오기 위해

	scanf("%d", &N);

	for (a = 0; a < 10; a++) {
		for (b = 0; b < 10; b++) {
			for (c = 0; c < 10; c++) {
				for (d = 0; d < 10; d++) {
					for (e = 0; e < 10; e++) {
						for (f = 0; f < 10; f++) {

							num = 100001 * a + 10001 * b + 1001 * c + 101 * d + 11 * e + 2 * f; // 분해합 값이
							if (num == N) { // 주어진 N값과 같다면

								answer = 100000 * a + 10000 * b + 1000 * c + 100 * d + 10 * e + f; // 생성자 값 계산
								exitOuterLoop = true;
								printf("%d\n", answer); // 생성자 값 출력
							}

							if (exitOuterLoop == true)
								break;
						}
					}
				}
			}
		}
	}

	if (exitOuterLoop == false) // 생성자가 없으면
		printf("0"); // 0 출력

	return 0;
}