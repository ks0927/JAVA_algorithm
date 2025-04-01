import java.util.*;
import java.io.*;

public class Main {
	static int[] counts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		counts = new int[11];

		int right = 0;
		int left = 0;
		int result = 0;
		while (right < N) {
			counts[arr[right++]]++;

			int[] minMax = findMinMax();
			int dist = minMax[1] - minMax[0];
			
			while(dist > 2) {
				counts[arr[left++]]--;
				minMax = findMinMax();
				dist = minMax[1] - minMax[0];
			}
			
			result = Math.max(result, right - left);
		}

		System.out.println(result);
	}

	private static int[] findMinMax() {
		int min = 11;
		int max = 0;

		for (int i = 1; i <= 10; i++) {
			if (counts[i] != 0) {
				min = Math.min(min, i);
				max = Math.max(max, i);
			}

		}
		return new int[] { min, max };
	}
}
