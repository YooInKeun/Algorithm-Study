/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
수열은 사전 순으로 증가하는 순서로 출력해야 한다.
예제 입력 1
3 1
예제 출력 1
1
2
3
예제 입력 2
4 2
예제 출력 2
1 2
1 3
1 4
2 1
2 3
2 4
3 1
3 2
3 4
4 1
4 2
4 3
예제 입력 3
4 4
예제 출력 3
1 2 3 4
1 2 4 3
1 3 2 4
1 3 4 2
1 4 2 3
1 4 3 2
2 1 3 4
2 1 4 3
2 3 1 4
2 3 4 1
2 4 1 3
2 4 3 1
3 1 2 4
3 1 4 2
3 2 1 4
3 2 4 1
3 4 1 2
3 4 2 1
4 1 2 3
4 1 3 2
4 2 1 3
4 2 3 1
4 3 1 2
4 3 2 1
*/

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

public class NandM {
	static int totalOfNum; // 총  숫자의 갯수
	static int numOfPrint; // 출력되어야하는 숫자의 갯수
	static boolean vistedNum[]; // 방문했는지 안했는지 확인
	static int totalOfNumArray[]; // 출력되어야 하는 숫자가 모두 들어간곳
	static ArrayList print = new ArrayList(); //출력 해주는 숫자가 들어가는 곳

	public static void main(String[] args) {

		Scanner bf = new Scanner(System.in);

		totalOfNum = bf.nextInt(); // 총 숫자의 갯수
		numOfPrint = bf.nextInt(); // 출력되어야하는 숫자의 갯수

		vistedNum = new boolean[totalOfNum];
		totalOfNumArray = new int[totalOfNum];

		// 숫자를 넣는 과정
		for (int i = 0; i < totalOfNumArray.length; i++) {
			totalOfNumArray[i] = i + 1;
		}

		permutation(0); // count 0부터 시작

	}

	
	public static void permutation(int count) {
		//count와 출력되어야 하는 갯수가 일치할때 print()함수 실행
		if (count == numOfPrint) {
			print(); // 출력
			return;
		}
		//
		for (int i = 0; i < vistedNum.length; i++) {

			if (vistedNum[i] == false) { // 한번도 방문하지 않았으면
				vistedNum[i] = true; // '방문'으로 변경후
				print.add(totalOfNumArray[i]); // 해당값을 출력(print) 리스트에 넣어준다.
				permutation(count + 1); // count 1을 증가시킨다
				print.remove(print.size() - 1); // 출력(print) 리스트의 마지막 값을 삭제시킨다.
 				vistedNum[i] = false; // '방문하지 않음'으로 변경
			}
		}
	}
	// 출력해주는 함수
	public static void print() {
		int num = 0; //print 리스트의 처음부터 출력해주기 위해
		for (int i = 0; i < vistedNum.length; i++) {

			if (vistedNum[i] == true) { //방문한 곳만
				System.out.print(print.get(num) + " "); //print 리스트에 있는 값을 순서대로 출력
				num++;
			}
		}
		System.out.println();
	}

}
