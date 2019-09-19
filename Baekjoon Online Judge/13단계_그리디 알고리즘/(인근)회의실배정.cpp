/*
문제
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
회의의 시작시간과 끝나는 시간이 같을 수도 있다.
이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

예제 입력 1
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14
예제 출력 1
4
*/

// Greedy

#include <iostream>
#include <vector>
#include <algorithm>
#pragma warning(disable:4996)

using namespace std;

bool sortbysec(const pair<int, int>& a, const pair<int, int>& b) { // sort 조건 함수
	if (a.second == b.second) // 강의실 종료 시간이 같다면
		return (a.first < b.first); // 강의실 시작 시간이 빠른 순서로
	else
		return (a.second < b.second); // 강의실 종료 시간이 다르다면, 빨리 끝나는 순서로
}

int main() {

	// pair: (시작시간, 종료시간)
	vector< pair<int, int> > vect;
	vector< pair<int, int> > tmp;
	int N, num1, num2, cnt = 1;

	scanf("%d", &N);

	for (int i = 0; i < N; i++) {
		scanf("%d %d", &num1, &num2);
		vect.push_back(make_pair(num1, num2));
	}

	sort(vect.begin(), vect.end(), sortbysec);
	tmp.assign(1, vect[0]);

	for (int i = 0; i < vect.size(); i++) {
		if (i != (N - 1)) {
			if (tmp[0].second <= vect[i + 1].first) { // 현재 회의의 종료 시간이 다음 후보 회의의 시작 시간보다 크거나 같아야, 다음 회의로 선택 가능

				tmp.assign(1, vect[i + 1]);
				cnt++;
			}
		}
	}

	printf("%d", cnt);

	return 0;
}