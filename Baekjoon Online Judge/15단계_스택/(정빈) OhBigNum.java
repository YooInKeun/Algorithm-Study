import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/*
문제
크기가 N인 수열 A = A1, A2, ..., AN이 있다. 
수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. 
Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 
그러한 수가 없는 경우에 오큰수는 -1이다.
예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, 
NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, 
NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

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

에제 입력 2
4
9 5 4 8

예제 출력 2
-1 8 8 -1

 */
public class OhBigNum {

	public static void main(String[] args) throws IOException {
		//시간초과 때문에 바꿔서 표현
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack st = new Stack<>();
		int num = Integer.parseInt(br.readLine());
		int[][] ohnum = new int[num][2];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			ohnum[i][0] = Integer.parseInt(str.nextToken());
			ohnum[i][1] = -1;
		}
		// 시간초과 된 부분
//		Scanner sc = new Scanner(System.in);
//		Stack st = new Stack<>();
//		int num = sc.nextInt();
//		int[][] ohnum = new int[num][2];
//		//ohnum 넣기
//		for(int i =0;i<num;i++) {
//			ohnum[i][0] = sc.nextInt();
//			ohnum[i][1] = -1;
//		}

		for (int i = 0; i < num; i++) {
			if (st.empty() || ohnum[(int) st.peek()][0] > ohnum[i][0]) {
				st.push(i);
			} else {
				while (!st.empty() && ohnum[(int) st.peek()][0] < ohnum[i][0]) {
					ohnum[(int) st.pop()][1] = ohnum[i][0];

				}
				st.push(i);
			}
		}


		// 출력
		for (int i = 0; i < num; i++) {
			System.out.print(ohnum[i][1] + " ");
		}

	}

}
