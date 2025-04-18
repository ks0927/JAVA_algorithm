import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static long[] map;
	static long min;
	static long[] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			map[i] = Long.parseLong(st.nextToken());
		}

		min = 2_000_000_001;
		result = new long[2];

		find();

		System.out.println(result[0] + " " + result[1]);
	}

	private static void find() {

		int left = 0;
		int right = map.length - 1;
		int mid;
		while (left < right) {
			
			long value = map[left] + map[right];
			
			if(min > Math.abs(map[left] + map[right])) {
				min = Math.abs(map[left] + map[right]);
				result[0] = map[left];
				result[1] = map[right];
			}
			
			if(value == 0) {
				return;
			}
			
			if(value < 0) {
				left++;
			}
			
			if(value > 0) {
				right--;
			}
		}
	}

}
