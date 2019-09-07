
//import java.util.Scanner;
//
//public class Make1 {
//	static int answer = 10000000;
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//
//		make(num, 0);
//
//		System.out.println(answer);
//	}
//
//	
//}
import java.util.Scanner;

public class Make1 {
	static int[] answerArr;
	static int[] answerArr2 = new int[1000001];
	static int answer = 10000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		answerArr = new int[num + 1];
		answerArr[1] = 0;
		answerArr2[1] = 0;
		for (int i = 2; i < num + 1; i++) {

			answerArr[i] = answerArr[i - 1] + 1;
			if (i % 3 == 0 && answerArr[i] > (answerArr[i / 3] + 1)) {
				answerArr[i] = answerArr[i / 3] + 1;
			}
			if (i % 2 == 0 && answerArr[i] > (answerArr[i / 2] + 1)) {
				answerArr[i] = answerArr[i / 2] + 1;
			}

		}
		for (int i = 2; i < num + 1; i++) {
			make(num, 0);
			
			answerArr2[i] = answer;
			System.out.println(answer);
			answer=100000000;

		}
		
		for(int i=1;i<num+1;i++) {
			if(answerArr[i]!=answerArr2[i]) {
				System.out.println(i+"일떄"+answerArr[i]+"그리고"+answerArr2[i]);
				System.out.println("ㄴㄴ");
			}
		}

		//System.out.println(answerArr[num]);
	}
	
	static void make(int num, int count) {
		if (num == 0) {
			return;
		}
		if (num == 1) {
			if (answer > count)
				answer = count;
			return;
		} else {
			if (num % 3 == 0) {
				make(num / 3, count + 1);
			} else {
				if (num % 2 == 0) {
					make(num / 2, count + 1);
				}
				make(num - 1, count + 1);
			}

		}
	}

}