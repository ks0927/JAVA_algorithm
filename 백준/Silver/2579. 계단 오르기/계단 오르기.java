import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {

	static int[] score;
	static int[] dp;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		score = new int[N];
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		if(N==1) {
			System.out.println(score[0]);
			return;
		}
		if(N==2) {
			System.out.println(score[0] + score[1]);
			return;
		}
		
		dp = new int[N];
		dp[0] = score[0];
		dp[1] = score[0] + score[1];
		dp[2] = Math.max(dp[0]+score[2], score[1]+ score[2]);

		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
		}
		
		System.out.println(dp[N-1]);
	}

}
