import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/*
문제
스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 
스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 
이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 
있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

입력
첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다.
 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 
 물론 같은 정수가 두 번 나오는 일은 없다.

출력
입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. 
push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

입력 예제 1
8
4
3
6
8
7
5
2
1

출력 예제 1
+
+
+
+
-
-
+
+
-
+
+
-
-
-
-
-

입력 예제 2
5
1
2
5
3
4

출력 예제 2
NO

 */
public class StackSequence {

	public static void main(String[] args) {
		Stack st = new Stack<>();
		Queue que = new LinkedList();

		Scanner in = new Scanner(System.in);
		int answer = 0;
		int num = in.nextInt(); // 몇번 하는지
		int integer = 1; // 1부터 n 까지 수 넣기
		int sequence = 0; // 수열 넣는 곳
		boolean check = true;
		boolean sequenceCheck = true; // 수열이 만들어 졌는지

		for (int i = 0; i < num; i++) {
			// 수열
			sequence = in.nextInt();
			// 수열을 만들때까지
			while (sequenceCheck) {
				// 스택이 비여있지 않으면
				if (!st.empty()) {
					// 스택의 가장 윗부분과 수열이 일치
					if (st.peek().equals(sequence)) {
						que.offer("-");
						st.pop();
						sequenceCheck = false;
					} else if ((int) st.peek() < sequence) {
						que.offer("+");
						st.push(integer);
						integer++;
					} else {
						check = false;
						break;
					}
				}
				// 스택 비여있으면 스택에 integer 넣기
				else {
					que.offer("+");
					st.push(integer);
					integer++;
				}
			}
			sequenceCheck = true;

		}
		// 수열을 만들 수 있는 지 없는 지 체크
		if (check) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				System.out.println(que.poll());
			}
		} else
			System.out.println("NO");

	}

}
