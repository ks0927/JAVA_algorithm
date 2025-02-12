import java.util.*;
import java.io.*;

public class Solution {

	static int[] score;
	static int[] cal;
	static int maxScore;
	static int maxCal;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());

			score = new int[N];
			cal = new int[N];
			maxScore = 0;
			maxCal = 0;
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				score[j] = s;
				cal[j] = c;
			}

			subset(0, N, limit, 0, 0);
			sb.append("#").append(i + 1).append(" ").append(maxScore).append("\n");

		}

		System.out.print(sb);
	}

	public static void subset(int depth, int N, int limit, int calSum, int scoreSum) {
		if (calSum > limit)
			return;

		if (depth == N && calSum <= limit) {
			maxScore = Math.max(maxScore, scoreSum);
			return;
		}

		subset(depth + 1, N, limit, calSum + cal[depth], scoreSum + score[depth]);
		subset(depth + 1, N, limit, calSum, scoreSum);
	}
}
