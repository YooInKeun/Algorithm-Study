
/*
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1
55-50+40

예제 출력 1
-35

 */
import java.util.Arrays;
import java.util.Scanner;

public class MissingParentheses {
	static String num;
	static String[] numArr;
	static String strNum = "";
	static int answer = 0;
	static boolean calculate = true;

	public static void main(String[] args) {
		Scanner bf = new Scanner(System.in);
		num = bf.nextLine();
		numArr = num.split("");//하나씩 잘라주기

		for (int i = 0; i < numArr.length; i++) {
			//부호가 나오면 계산 해주기
			if (numArr[i].equals("-")) {
				//만약 -가 나오지 않았으면 더해줘야 하고 한번이라도 나왔으면 빼줄수 있다.
				if (calculate)
					answer += Integer.parseInt(strNum.toString()); // 스트링 변수를 인트(숫자)로 변환
				else
					answer -= Integer.parseInt(strNum.toString()); // 스트링 변수를 인트(숫자)로 변환
				calculate = false;
				strNum = ""; // 숫자 초기화
			//부호가 나오면 계산 해주기
			} else if (numArr[i].equals("+")) {
				//만약 -가 나오지 않았으면 더해줘야 하고 한번이라도 나왔으면 빼줄수 있다.
				if (calculate)
					answer += Integer.parseInt(strNum.toString()); // 스트링 변수를 인트(숫자)로 변환
				else
					answer -= Integer.parseInt(strNum.toString()); // 스트링 변수를 인트(숫자)로 변환
				strNum = "";// 숫자 초기화

			} else {
				//스트링배열에 있는 숫자들을 합치기
				strNum += numArr[i];
			}

		}

		// 마지막 숫자 더해주기
		if (calculate)
			answer += Integer.parseInt(strNum.toString());
		else
			answer -= Integer.parseInt(strNum.toString());

		System.out.println(answer);
	}
}
