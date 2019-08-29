
/*
문제
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 
입력
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

예제 입력1
216

예제 출력1
198
 */
import java.util.Scanner;

public class Decomposition {
	static int num = 0; //처음 받을 예제
	static int answer = 0; //정답

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner bf = new Scanner(System.in);
		num = bf.nextInt();

		for (int i = 1; i < num + 1; i++) {
			int temp = i; // 자신의 수 더하기
			int j = i; // 각 자리 수를 더할때 자신(i) 값을 보존하기 위해 temp에 넣는다.
			//각자리 수를 더하기
			while (j != 0) {
				// 1의 자리 값을 더해준다.
				temp += j % 10;
				// 1의 자리를 없애고 10의 자리의 수를 1의 자리로 바꾼다.
				j /= 10;
			}
			// 처음 입력받은 수와 같아지면
			if (temp == num) {
				answer = i;// i를 정답에 넣는다
				break;
			}
		}
		System.out.println(answer); // 정답
	}
}
