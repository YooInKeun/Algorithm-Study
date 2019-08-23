import java.awt.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NandM {
	static int MAX;
	static int num;
	static boolean print_num[];
	static int print_num_initial[];
	static int num_arr[];
	static ArrayList temp = new ArrayList();
	static ArrayList print = new ArrayList();
	static BufferedWriter check = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	

	public static void main(String[] args) throws IOException {
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
		permutation(0);

	}

	public static void permutation(int count) throws IOException {

		if (count == num) {
			print();
			return;
		}

		for (int i = 0; i < print_num.length; i++) {
			
			if (print_num[i] == false) {
				print_num[i] = true;
				print.add(num_arr[i]);
				permutation(count + 1);
				print.remove(print.size() - 1);

				print_num[i] = false;
			}
		}
	}

	public static void print() throws IOException {
		
		for (int i = 0; i < print.size(); i++) {
			bw.write(String.valueOf(print.get(i)) + " ");

		}
		bw.flush();
		//check.write(bw.flush());
		bw.newLine();


	}

}
