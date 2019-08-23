import java.awt.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner bf = new Scanner(System.in);

		MAX = bf.nextInt();
		num = bf.nextInt();

		print_num = new boolean[MAX];
		num_arr = new int[MAX];

		for (int i = 0; i < num_arr.length; i++) {
			num_arr[i] = i + 1;
		}

		permutation(0);

	}

	public static void permutation(int count) throws IOException {

		if (count == num) {
			print();
			return;
		}

		for (int i = 0; i < num_arr.length; i++) {

			print.add(num_arr[i]);
			permutation(count + 1);
			print.remove(print.size() - 1);

		}
	}

	public static void print() throws IOException {

		for (int i = 0; i < print.size(); i++) {
			bw.write(String.valueOf(print.get(i)) + " ");

		}
		bw.flush();
		bw.newLine();

	}

}
