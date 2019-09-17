import java.util.Scanner;

public class RoomAssignment {
	static int[][] room;
	static int num;
	static int answer = 0;
	static int count = 0;
	static boolean check = true;

	public static void main(String[] args) {
		Scanner bf = new Scanner(System.in);
		num = bf.nextInt();
		room = new int[100000][100000];

		for (int time = 0; time < num; time++) {
			check = true;
			int first = bf.nextInt();
			int end = bf.nextInt();
			for (int i = 0; i < count; i++) {
				if ((room[i][(num) - 1]) == 0) {
					room[i][0] = first;
					room[i][1] = end;
					check = false;
					room[i][(num) - 1]++;
				} else if (first > room[i][(room[i][(num ) - 1])]) {

					room[i][room[i][(num) - 1] * 2] = first;
					room[i][room[i][(num) - 1] * 2 + 1] = end;
					check = false;
					room[i][(num) - 1]++;

				}
			}
			if (check) {
				room[count][0] = first;
				room[count][1] = end;
				count++;
				room[count][(num) - 1] = 1;
			}
		}

		for (int i = 0; i < num; i++) {
			if (room[i][(num) - 1] > answer)
				answer = (int) room[i][(num) - 1];
		}
		System.out.println(answer);
	}
}
