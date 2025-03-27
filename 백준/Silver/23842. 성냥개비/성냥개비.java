import java.util.*;
import java.io.*;

public class Main {
	static int[] sum;
	static String[] ans;
	static int N;
	static int[] weight;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		weight = new int[10];
		weight[0] = 6;
		weight[1] = 2;
		weight[2] = 5;
		weight[3] = 5;
		weight[4] = 4;
		weight[5] = 5;
		weight[6] = 6;
		weight[7] = 3;
		weight[8] = 7;
		weight[9] = 6;

		N -= 4;

		sum = new int[6];
		ans = new String[6];
		make(0);
		System.out.println("impossible");
	}

	private static void make(int depth) {

		if (depth == 6) {

			int first = Integer.parseInt(ans[0] + ans[1]);
			int second = Integer.parseInt(ans[2] + ans[3]);
			int third = Integer.parseInt(ans[4] + ans[5]);

			if (first + second == third) {
				int w = 0;
				for (int i = 0; i < 6; i++) {
					w += weight[sum[i]];
				}
				if (w == N) {
					System.out.print(ans[0]+ans[1]+"+"+ans[2]+ans[3]+"="+ans[4]+ans[5]);
					System.exit(0);
				}
			}
			
			return;
		}

		for (int i = 0; i < 10; i++) {
			ans[depth] = String.valueOf(i);
			sum[depth] = i;
			make(depth + 1);
		}
	}

}
