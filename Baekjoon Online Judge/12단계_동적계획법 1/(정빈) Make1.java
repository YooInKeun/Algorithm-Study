import java.util.Scanner;

public class Make1 {
	static int answer=100000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		make(num, 0);
		
		System.out.println(answer);
	}
	static void make(int num, int count) {
		if(num==0) {
			return;
		}
		if(num==1) {
			if(answer>count)
				answer = count;
			return;
		}
		else {

		if(num%3==0) {
			System.out.println(num);
			System.out.println(num/3 +"이때의" + count);
			count++;
			System.out.println(count);
			make(num/3,count);
		}
		if(num%2==0) {
			count++;
			make(num/2,count);
		}
		System.out.println(num);
		count++;
		make(num-1,count);
		
		}
	}
}
