/*
문제
n가지 종류의 동전이 있다. 각각의 동전이 나타내는 가치는 다르다. 
이 동전을 적당히 사용해서, 그 가치의 합이 k원이 되도록 하고 싶다. 
그 경우의 수를 구하시오. 각각의 동전은 몇 개라도 사용할 수 있다.
사용한 동전의 구성이 같은데, 순서만 다른 것은 같은 경우이다.

입력
첫째 줄에 n, k가 주어진다. (1 ≤ n ≤ 100, 1 ≤ k ≤ 10,000) 
다음 n개의 줄에는 각각의 동전의 가치가 주어진다. 동전의 가치는 100,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 경우의 수를 출력한다. 경우의 수는 2^31보다 작다.

예제 입력 1
3 10
1
2
5

예제 출력 1
10

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Coin1 {
	static int coin;
	static int[] coinArr;//동전 넣기
	static int[] avilableCoin; //k값을 동전으로 최대한 뺀 배열
	static int money;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		coin = sc.nextInt();
		money = sc.nextInt();
		coinArr = new int[coin];
		avilableCoin = new int[money+1];
		avilableCoin[0] = 1;
		
		//동전 넣어주기
		for (int i = 0; i < coin; i++) {
			coinArr[i] = sc.nextInt();
		}
		
		//동전의 갯수만큼
		for (int i = 0; i < coin; i++) {
			//k값까지 하나하나 다 뺴주기
			for (int j = 1; j <= money; j++) {
				//k값이 동전보다 클경우 (뺄수있으니까)
				if (j - coinArr[i] >= 0)
					//빼서 차이를 넣어준다.
					avilableCoin[j] += avilableCoin[j - coinArr[i]];
			}
		}
		
		//k번째 값 출력
		System.out.println(avilableCoin[money]);

	}
}
/*
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * coin = sc.nextInt(); money = sc.nextInt(); answer = money; coinArr = new
 * int[coin]; for (int i = 0; i < coin; i++) { coinArr[i] = sc.nextInt(); }
 * Arrays.sort(coinArr); for (int i = coin - 1; i >= 0; i--) { int temp = money;
 * while (temp>0) { temp = temp - coinArr[i]; if (temp>0&&divde(temp)) {
 * allDivide = false; break; } }
 * 
 * } if (allDivide) { for (int i = coin - 1; i >= 0; i--) { int temp = money;
 * while ((money - coinArr[i])>0) { money = money - coinArr[i]; } } answer =
 * answer-money;
 * 
 * } System.out.println(answer);
 * 
 * }
 * 
 * public static boolean divde(int temp) {
 * 
 * for (int i = 0; i < coin; i++) { if(temp%coinArr[i]==0) return true; } return
 * false; } }
 */
/*
 * 처음 컨셉 - k값이 동전으로 나눠지면 k값 출력, 아닐경우 내림차순정렬후 계속 빼주기
 * 
 * 두번째 컨셉 - k값을 각각으로 동전으로 다 빼주고 다시 다른 동전으로 빼줘서 최솟값 구한후 k-최솟값 출력
 * 2 11 
 * 3 
 * 5
 */