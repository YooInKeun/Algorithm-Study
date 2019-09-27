import java.util.Scanner;
import java.util.Stack;

/*
문제
세계는 균형이 잘 잡혀있어야 한다. 양과 음, 빛과 어둠 그리고 왼쪽 괄호와 오른쪽 괄호처럼 말이다.
정민이의 임무는 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램을 짜는 것이다.
문자열에 포함되는 괄호는 소괄호("()") 와 대괄호("[]")로 2종류이고, 문자열이 균형을 이루는 조건은 아래와 같다.
모든 왼쪽 소괄호("(")는 오른쪽 소괄호(")")와만 짝을 이룰 수 있다.
모든 왼쪽 대괄호("[")는 오른쪽 대괄호("]")와만 짝을 이룰 수 있다.
모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재한다.
모든 괄호들의 짝은 1:1 매칭만 가능하다. 즉, 괄호 하나가 둘 이상의 괄호와 짝지어지지 않는다.
짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야 한다.
정민이를 도와 문자열이 주어졌을 때 균형잡힌 문자열인지 아닌지를 판단해보자.

입력
하나 또는 여러줄에 걸쳐서 문자열이 주어진다. 각 문자열은 영문 알파벳, 공백, 
소괄호("( )") 대괄호("[ ]")등으로 이루어져 있으며, 길이는 100글자보다 작거나 같다.
입력의 종료조건으로 맨 마지막에 점 하나(".")가 들어온다.

출력
각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.

예제 입력 1
So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.
예제 출력 1
yes
yes
no
no
no
yes
yes

 */
public class BalancedWorld {

	public static void main(String[] args) {
		Stack st = new Stack<>();
		Scanner in = new Scanner(System.in);
		int answer = 0;
		boolean check;
		// 마지막 . 예외사항 두기 위해
		String line = in.nextLine();
		while (!line.equals(".")) {
			check = true;
			for (int i = 0; i < line.length(); i++) {
				switch (line.charAt(i)) {
				case '(':
					st.push(1);
					break;
				case '[':
					st.push(2);
					break;
				case ')':
					// 비어 있거나 ( 가 없을 경우
					if (st.isEmpty() || !st.peek().equals(1)) {
						check = false;
						break;
					}
					st.pop();
					break;
				case ']':
					// 비어 있거나 [ 가 없을 경우
					if (st.isEmpty() || !st.peek().equals(2)) {
						check = false;
						break;
					}
					st.pop();
					break;

				}
			}
			// 스택이 비어있지 않거나 위에서 no 상항일때
			if (check && st.empty())
				System.out.println("yes");
			else
				System.out.println("no");
			st.clear();
			line = in.nextLine();
		}

	}
}