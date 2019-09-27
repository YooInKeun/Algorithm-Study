/*
문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다.
물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다.
push연산은 +로, pop 연산은 -로 표현하도록 한다.
불가능한 경우 NO를 출력한다.

예제 입력 1
8
4
3
6
8
7
5
2
1

예제 출력 1
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-

예제 입력 2
5
1
2
5
3
4
예제 출력 2
NO
*/

// Stack

#include <iostream>
#include <stack>
#include <vector>
#pragma warning(disable:4996)
#define MAX 100000

using namespace std;

int main() {

	int n, input[MAX], num[MAX], i = 0, j = 0; // input : 유저 입력 값, num : 오름차순으로 저장된 숫자
	bool flag = true; // YES or NO flag
	vector<char> result; // push('+'), pop('-') 문자 저장할 벡터
	stack<int> s;

	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		num[i] = i + 1;

	for (int i = 0; i < n; i++)
		scanf("%d", &input[i]);

	for (i = 0; i < n; ) {
	
		while (num[j] != input[i]) { // 원하는 숫자가 나올 때 까지
			s.push(num[j]); // push
			result.push_back('+'); // push는 '+' 표시
			j++;

			if (result.size() > n * 2) { // vector size 조건문을 달지 않으면 런타임 에러 발생
				flag = false;
				break;
			}
		}
		
		if (num[j] == input[i]) { // 원하는 숫자가 나오면
			s.push(num[j]); // 이것 또한 push
			result.push_back('+'); // push는 '+' 표시
			j++;
		}

		while (s.top() == input[i]) { // 원하는 숫자가 스택에 있으면
			s.pop(); // pop
			result.push_back('-'); // pop은 '-' 표시
			i++;

			if (s.empty()) { // 스택이 비었는지 확인 안해주면, s.top()에서 오류 발생(empty인 스택 참조 오류)
				break;
			}
		}

		if (result.size() > n * 2) { // '+', '-'를 저장한 vector size가 입력한 n값의 2배보다 크면
			flag = false; // 스택 수열이 불가능한 경우
			break; // 전체 반복문 중단
		}
	}

	if (flag == true) { // 스택 수열이 가능한 경우
		for (int i = 0; i < n * 2; i++)
			printf("%c\n", result[i]);
	}
	else { // 스택 수열이 불가능한 경우
		printf("NO\n");
	}

	return 0;
}