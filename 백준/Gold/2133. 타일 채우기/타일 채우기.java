import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;

		for (int i = 4; i <= N; i += 2) {
			int sum = dp[i - 2] * dp[2];

			for (int j = 0; j <= i - 4; j += 2) {
				sum = sum + (2 * dp[j]);
			}
			dp[i] = sum;
		}
		
		System.out.println(dp[N]);
	}

}
