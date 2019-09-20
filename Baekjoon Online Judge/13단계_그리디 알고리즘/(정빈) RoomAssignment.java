/*
문제
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의들에 대하여 회의실 사용표를 만들려고 한다. 
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라. 
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.

예제 입력 1
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

예제 출력 1
4

 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RoomAssignment {
	static int[][] meetingRoom;
	static int num;
	static int answer = 1;
	static int current = 0;

	public static void main(String[] args) {
		Scanner bf = new Scanner(System.in);
		num = bf.nextInt();

		meetingRoom = new int[num][2];
		for (int i = 0; i < num; i++) {
			meetingRoom[i][0] = bf.nextInt();
			meetingRoom[i][1] = bf.nextInt();
		}

		// 종료시간을 기준으로 정렬, 단 종료시간이 같으면 시작시간으로 정렬
		Arrays.sort(meetingRoom, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				// start[0], end[0] 배열은 arr[][] 의 첫번째 라인(시작시간)이다.
				// start[1], end[0] 배열은 arr[][] 의 두번째 라인(종료시간)이다.
				if (start[1] == end[1]) {
					// 만약 비교하는 값의 종료시간이 같을 경우 시작시간으로 정렬한다.
					return Integer.compare(start[0], end[0]);
				}
				// 종료시간에 따라 정렬한다.
				return Integer.compare(start[1], end[1]);
			}

		});

		current = meetingRoom[0][1];// 처음 종료 시간 넣기
		// 처음 종료 시간보다 큰 시작시간 찾기
		for (int i = 1; i < num; i++) {
			if (meetingRoom[i][0] >= current) {
				// 해당 종료시간을 넣기
				current = meetingRoom[i][1];
				answer++;
			}

		}

		// 시간초과 나는 부분 - 모든 부분을 다 생각해줘서
//		// System.out.println(meetingRoom[1][1]);
//		for (int time = 0; time < num; time++) {
//			check = true;
//			for (int i = 0; i < count; i++) {
//				if ((room[i][1]) == 0) {
//					room[i][0] = meetingRoom[time][1];
//					check = false;
//					room[i][1]++;
//				} else if (meetingRoom[time][0] >= room[i][0]) {
//					room[i][0] = meetingRoom[time][1];
//					check = false;
//					room[i][1]++;
//
//				}
//				in = meetingRoom[time][1];
//			}
//			if (check) {
//				room[count][0] = in;
//				room[count][1] = 1;
//				count++;
//			}
//		}
//
//		for (int i = 0; i < count; i++) {
//			if (room[i][1] > answer)
//				answer = (int) room[i][1];
//		}
//		for (int i = 0; i < count; i++) {
//			System.out.println(room[i][0]+" "+room[i][1]);
//		}
		
		System.out.println(answer);
	}

}
