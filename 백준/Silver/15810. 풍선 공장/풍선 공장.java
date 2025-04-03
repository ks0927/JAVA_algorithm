import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] ball;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ball = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ball[i] = Integer.parseInt(st.nextToken());
		}

		long left = 0L;
		long right = 1000000000000L;
		long mid;
		while (left < right) {
			mid = (left + right) / 2;

			long sum = 0L;
			for (int i = 0; i < N; i++) {
				sum += mid / ball[i];
			}
			
			if(sum < M) {
				left = mid + 1;
			}else {
				right = mid;
			}
		}
		
		System.out.println(right);
	}

}
