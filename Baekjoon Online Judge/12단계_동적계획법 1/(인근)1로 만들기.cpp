/*
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.

정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

예제 입력 1
2
예제 출력 1
1

예제 입력 2
10
예제 출력 2
3

힌트
10의 경우에 10 -> 9 -> 3 -> 1 로 3번 만에 만들 수 있다.
*/

// 다이나믹 프로그래밍

#include <iostream>
#pragma warning(disable:4996)

using namespace std;

int func(int num) {

	if (num == 1) // 1이면 0번
		return 0;
	else {
		if (num % 3 == 0) { // N이 3으로 나누어 떨어지고
			if (num % 2 == 0) { // 2로 나누어 떨어지면
				if (func(num / 3) > func(num / 2)) // 3으로 나누었을 때와 2로 나누었을 때 결과를 비교해서 분기
					return func(num / 2) + 1;
				else
					return func(num / 3) + 1;
			}
			else if (num % 2 == 1) // 2로 나누어 떨어지지 않으면
				return func(num / 3) + 1; // 바로 3으로 나누기
		}
		else if (num % 3 == 1) { // N을 3으로 나눴을 때 나머지가 1이고
			if (num % 2 == 0) { // 2로 나누어 떨어지면
				if (func(num / 2) > func(num - 1)) // 2로 나누었을 때와 1을 뺐을 때 결과를 비교해서 분기
					return func(num - 1) + 1;
				else
					return func(num / 2) + 1;
			}
			else if (num % 2 == 1) // 2로도 나누어 떨어지지 않으면
				return func(num - 1) + 1; // 1 빼기
		}
		else if (num % 3 == 2)  { // N을 3으로 나눴을 때 나머지가 2고
			if (num % 2 == 0) { // 2로 나누어 떨어지면
				if (func(num / 2) > func(num - 1)) // 2로 나누었을 때와 1을 뺐을 때 결과를 비교해서 분기
					return func(num - 1) + 1;
				else
					return func(num / 2) + 1;
			}
			else if (num % 2 == 1) // 2로도 나누어 떨어지지 않으면
				return func(num - 1) + 1; // 1 빼기
		}
	}
}

int main() {

	int N;

	scanf("%d", &N);
	printf("%d", func(N));

	return 0;
}