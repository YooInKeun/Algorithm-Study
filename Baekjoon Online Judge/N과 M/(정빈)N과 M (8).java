import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NandM {
	static int MAX;
	static int num;
	static boolean print_num[];
	static int num_arr[];
	// static Queue<Integer> print = new LinkedList<Integer>();
	static ArrayList print = new ArrayList();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner bf = new Scanner(System.in);

		MAX = bf.nextInt();
		num = bf.nextInt();

		print_num = new boolean[MAX];
		num_arr = new int[MAX];

		for (int i = 0; i < num_arr.length; i++) {
			num_arr[i] = bf.nextInt();
		}
		Arrays.sort(num_arr);
		permutation(0, 0);
	}

	public static void permutation(int idx, int count) {

		if (count == num) {
			print();
			return;
		}

		for (int i = idx; i < num_arr.length; i++) {

			print.add(num_arr[i]);
			permutation(i, count + 1);
			print.remove(print.size() - 1);
			
		}
		
	}

	public static void print() {
		int num = 0;
		for (int i = 0; i < print.size(); i++) {

			System.out.print(print.get(i) + " ");
		}
		System.out.println();

	}

}
