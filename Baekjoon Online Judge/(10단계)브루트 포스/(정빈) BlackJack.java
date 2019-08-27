/*
문제
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 블랙잭은 카지노마다 다양한 규정이 있다.
한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
김정인 버젼의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는다.
합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

예제 입력 1
5 21
5 6 7 8 9

예제 출력 1
21
*/
import java.util.Scanner;

public class BlackJack {
	static int numOfCard; //카드의 갯수
	static int[] numOfCardArr; //카드를 담는 배열
	static boolean[] visitNum; //조합을 이용하기 때문에, 어떤 카드를 선택할지 정해주는 배열
	static int maxCount; //카드를 조합했을 때, 만드는 최대의 수
	static int answer; // 정답을 보여줄 변수

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner bf = new Scanner(System.in);

		numOfCard = bf.nextInt(); // N을 넣는다
		maxCount = bf.nextInt(); // M을 넣는다

		numOfCardArr = new int[numOfCard]; 
		visitNum = new boolean[numOfCard];

		//카드를 담는 반복문
		for (int i = 0; i < numOfCardArr.length; i++) {
			numOfCardArr[i] = bf.nextInt();
		}
		
		combination(0, 0); //조합

		System.out.println(answer); //정답
	}
	
	//조합
	public static void combination(int count, int idx) {
		//3가지 카드가 선택됐을때
		if (count == 3) {
			cardPlus();
			return;
		}

		//카드를 선택하는 과정
		for (int i = idx; i < visitNum.length; i++) {
			if (visitNum[i] == false) {
				visitNum[i] = true;
				combination(count + 1, i);
				visitNum[i] = false;
			}

		}

	}

	// 카드를 더해주는 함수
	public static void cardPlus() {
		int temp = 0;
		for (int i = 0; i < numOfCardArr.length; i++) {
			if (visitNum[i] == true) {
				temp += numOfCardArr[i];
			}

		}
		//temp가 M을 넘지않으며, 현재 answer 보다 크면 교체
		if (maxCount >= temp && temp > answer) {
			answer = temp;
		}

	}

}
