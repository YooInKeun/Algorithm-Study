/*
����
�����̴� �ڽ��� ���ÿ��� MN���� ���� ���簢������ �������� �ִ� M*N ũ���� ���带 ã�Ҵ�.
� ���簢���� ���������� ĥ���� �ְ�, �������� ������� ĥ���� �ִ�.
�����̴� �� ���带 �߶� 8*8 ũ���� ü�������� ������� �Ѵ�.

ü������ �������� ����� �����Ƽ� ĥ���� �־�� �Ѵ�.
��ü������, �� ĭ�� �������� ��� �� �ϳ��� ��ĥ�Ǿ� �ְ�, ���� �����ϴ� �� ���� �簢���� �ٸ� ������ ĥ���� �־�� �Ѵ�.
���� �� ���Ǹ� ������ ü������ ��ĥ�ϴ� ���� �� �������̴�.
�ϳ��� �� ���� �� ĭ�� ����� ���, �ϳ��� �������� ����̴�.

���尡 ü����ó�� ĥ���� �ִٴ� ������ ���, �����̴� 8*8 ũ���� ü�������� �߶� �Ŀ� �� ���� ���簢���� �ٽ� ĥ�ؾ߰ڴٰ� �����ߴ�.
�翬�� 8*8 ũ��� �ƹ������� ��� �ȴ�.
�����̰� �ٽ� ĥ�ؾ� �ϴ� ���簢���� �ּ� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� N�� M�� �־�����. N�� M�� 8���� ũ�ų� ����, 50���� �۰ų� ���� �ڿ����̴�.
��° �ٺ��� N���� �ٿ��� ������ �� ���� ���°� �־�����.
B�� �������̸�, W�� ����̴�.

���
ù° �ٿ� �����̰� �ٽ� ĥ�ؾ� �ϴ� ���簢�� ������ �ּڰ��� ����Ѵ�.

���� �Է� 1
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
���� ��� 1
1

���� �Է� 2
10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
���� ��� 2
12
*/

// ���Ʈ ����

#include <iostream>
#include <string>
#pragma warning(disable:4996)
#define MAX 50
#define INF 9999999

using namespace std;

int main() {

	int N, M, cnt = 0, min = INF;
	string board[MAX]; // M*N ũ���� ������

	// ü������ ���� �� ���� ���� ������

	string black_board[8] = { // ù ��° ĭ�� �������� ���
								"BWBWBWBW",
								"WBWBWBWB",
								"BWBWBWBW",
								"WBWBWBWB",
								"BWBWBWBW",
								"WBWBWBWB",
								"BWBWBWBW",
								"WBWBWBWB"
							};

	string white_board[8] = { // ù ��° ĭ�� �Ͼ���� ���
								"WBWBWBWB",
								"BWBWBWBW",
								"WBWBWBWB",
								"BWBWBWBW",
								"WBWBWBWB",
								"BWBWBWBW",
								"WBWBWBWB",
								"BWBWBWBW"
							};

	scanf("%d %d", &N, &M);

	for (int i = 0; i < N; i++)
		cin >> board[i];

	// board�� ù��° ĭ�� ��ġ�� (i, j)
	for (int i = 0; i < N - 7; i++) {
		for (int j = 0; j < M - 7; j++) {

			for (int BW = 0; BW < 2; BW++) {
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {

						if (BW == 0) { // ü������ ù��° ĭ�� ���������� �ξ��� ��
							if (board[i + k][j + l] != black_board[k][l])
								cnt++;
						}
						else if (BW == 1) { // ü������ ù��° ĭ�� �Ͼ������ �ξ��� ��
							if (board[i + k][j + l] != white_board[k][l])
								cnt++;
						}
					}
				}

				if (min > cnt)
					min = cnt;

				cnt = 0;
			}
		}
	}
	printf("%d", min);

	return 0;
}