import java.util.ArrayList;
import java.util.Scanner;

public class cooking {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<int[]> momentList = new ArrayList<int[]>();
		ArrayList<int[]> requiredList = new ArrayList<int[]>();
		int student_array[] = new int[T];
		int moment_time[];
		int required_time[];
		int output[] = new int[T];
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			student_array[i] = N;
			moment_time = new int[N];
			required_time = new int[N];
			for (int j = 0; j < N; j++) {
				moment_time[j] = sc.nextInt();
			}
			momentList.add(moment_time);
			for (int k = 0; k < N; k++) {
				required_time[k] = sc.nextInt();
			}
			requiredList.add(required_time);
		}

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < student_array[i]; j++) {
				if (j != 0) {
					int a = momentList.get(i)[j];
					int b = momentList.get(i)[j - 1];
					int c = requiredList.get(i)[j];
					if ((a - b) >= c) {
						output[i]++;
					}
				} else {
					int d = momentList.get(i)[j];
					int e = requiredList.get(i)[j];
					if (d >= e) {
						output[i]++;
					}
				}
			}
		}
		for (int i = 0; i < T; i++) {
			System.out.println(output[i]);
		}
	}
}