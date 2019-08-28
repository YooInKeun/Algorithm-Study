import java.util.Scanner;

public class RecolorChessboard {
	static char[][] board; // 체스판
	//처음에 W로 시작하는 체스판
	static char[][] boardW= {
        { 'W','B','W','B','W','B','W','B' },
        { 'B','W','B','W','B','W','B','W' },
        { 'W','B','W','B','W','B','W','B' },
        { 'B','W','B','W','B','W','B','W' },
        { 'W','B','W','B','W','B','W','B' },
        { 'B','W','B','W','B','W','B','W' },
        { 'W','B','W','B','W','B','W','B' },
        { 'B','W','B','W','B','W','B','W' },
	};
	//처음에 B로 시작하는 체스판
	static char[][] boardB= {
		{ 'B','W','B','W','B','W','B','W' },
        { 'W','B','W','B','W','B','W','B' },
        { 'B','W','B','W','B','W','B','W' },
        { 'W','B','W','B','W','B','W','B' },
        { 'B','W','B','W','B','W','B','W' },
        { 'W','B','W','B','W','B','W','B' },
        { 'B','W','B','W','B','W','B','W' },
        { 'W','B','W','B','W','B','W','B' },
	};
	      
	static int row, colum; // 세로, 가로
	static int answer=2500; // 최대 answer
	public static void main(String[] args) {
		Scanner bf = new Scanner(System.in);

		row = bf.nextInt(); // 세로
		colum = bf.nextInt(); // 가로
		board = new char[row][colum]; 

		// 체스판 채우기
		for (int i = 0; i < row; i++) {
			String temp;
			temp = bf.next();
			for(int j=0; j < colum; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		
		//체스판 8x8 사이즈로 나눠서 확인
		for (int i = 0; i < row-7; i++) {
			for (int j = 0; j < colum-7; j++) {
				chess(i,j);
			}
		}
		//정답 출력
		System.out.println(answer);

	}
	static void chess(int row, int colum) {
		int wTemp=0;
		int bTemp=0;
		int boardRow=0;
		//처음에 W로 시작하는 체스판 과 처음에 B로 시작하는 체스판을 확인해서 다르면 count를 증가시켜서 확인
		for (int i = row; i < row+8; i++) {
			int boardColum=0;
			for(int j=colum; j < colum+8; j++) {
				if(board[i][j]!=boardW[boardRow][boardColum]) {
					wTemp++;
				}
				if(board[i][j]!=boardB[boardRow][boardColum]) {
					bTemp++;
				}
				boardColum++;
			}
			boardRow++;
		}
		//answer 보다 작으면 answer과 교체
		if(answer>wTemp)
			answer = wTemp;
		if(answer>bTemp)
			answer = bTemp;
		
	}
}
