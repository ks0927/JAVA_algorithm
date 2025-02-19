import java.io.*;
import java.util.*;

public class Solution {

	static int[] GYs;
	static int[] cards;
	static int[] IYs;
	static int GY;
	static int IY;
	static boolean[] check;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			check = new boolean[19];
			GYs = new int[9];
			cards = new int[9];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int value = Integer.parseInt(st.nextToken());
				GYs[j] = value;
				check[value] = true;
			}

			int index = 0;
			for (int j = 1; j <= 18; j++) {
				if (!check[j]) {
					cards[index] = j;
					index++;
				}
			}

			IYs = new int[9];
			visited = new boolean[9];
			GY = 0;
			IY = 0;
			
			perm(0);
			sb.append("#").append(i + 1).append(" ").append(GY).append(" ").append(IY).append("\n");
		}
		System.out.println(sb);
	}

	private static void perm(int depth) {

		if (depth == 9) {
			int gySum = 0;
			int iySum = 0;
			for (int i = 0; i < 9; i++) {
				if (GYs[i] > IYs[i]) {
					gySum += (GYs[i] + IYs[i]);
				} else {
					iySum += (GYs[i] + IYs[i]);
				}
			}
			if(gySum > iySum) {
				GY++;
			}else {
				IY++;
			}
			
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			IYs[depth] = cards[i];
			perm(depth + 1);
			visited[i] = false;
		}
	}

}
