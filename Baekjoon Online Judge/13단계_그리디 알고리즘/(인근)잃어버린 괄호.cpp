/*
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다.
그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다.
식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
수는 0으로 시작할 수 있다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1
55-50+40
예제 출력 1
-35
*/

// Greedy

#include <iostream>
#include <string.h>
#pragma warning(disable:4996)
#define MAX 50

using namespace std;

int main() {

	char equation[MAX], buffer[MAX], myOperator[MAX];
	char* str_num[MAX];
	char* numToken;
	int numIdx = 0, operatorIdx = 0, answer = 0;
	int num[MAX], numSum[MAX];

	scanf("%s", equation);
	strcpy(buffer, equation);

	numToken = strtok(equation, "+-");

	while (numToken != NULL) {
		str_num[numIdx] = numToken;
		numIdx++;
		numToken = strtok(NULL, "+-");
	}

	for (int i = 0; buffer[i] != NULL; i++) {
		if (buffer[i] == '+' || buffer[i] == '-') {

			myOperator[operatorIdx] = buffer[i];
			operatorIdx++;
		}
	}

	for (int i = 0; i < numIdx; i++)
		num[i] = atoi(str_num[i]);

	numSum[0] = num[0];

	for (int i = 0; i < numIdx; i++) {
		if (myOperator[i] == '-')
			numSum[i + 1] = num[i + 1];
		else if (myOperator[i] == '+') {
			numSum[i + 1] = numSum[i] + num[i + 1];
			numSum[i] = NULL;
		}
	}

	bool firstFlag = true;
	for (int i = 0; i < numIdx; i++) {

		if (numSum[i] != NULL && firstFlag == true) {

			answer = numSum[i];
			firstFlag = false;
		}
		else if(numSum[i] !=NULL && firstFlag == false) {
			answer -= numSum[i];
		}
	}

	printf("%d", answer);

	return 0;
}