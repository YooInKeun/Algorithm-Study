/*
문제
크기가 N인 수열 A = A1, A2, ..., AN이 있다.
수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.
둘째에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.

출력
총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.

예제 입력 1
4
3 5 2 7
예제 출력 1
5 7 7 -1

예제 입력 2
4
9 5 4 8
예제 출력 2
-1 8 8 -1
*/

// Stack

#include<iostream>
#include<stack>
#include<vector>
#pragma warning(disable:4996)

using namespace std;

int main() {

	int n;
	stack<int> s;
	
	scanf("%d", &n);

	vector<int> v(n), result(n);

	for (int i = 0; i < n; i++)
		scanf("%d", &v[i]);

	for (int i = n - 1; i >= 0; i--) {
		while (!s.empty() && s.top() <= v[i]) // 현재 스택의 top이 입력한 숫자 보다 작거나 같으면
			s.pop(); // pop

		if (s.empty()) // 스택이 비어 있으면
			result[i] = -1; // -1 출력
		else // 비어 있지 않으면
			result[i] = s.top(); // 스택의 top에 있는 값이 오큰수

		s.push(v[i]);
	}

	for (int i = 0; i < n; i++)
		printf("%d ", result[i]);
}