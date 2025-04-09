import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		int[] idx = new int[N];

		int size = 0;
		for (int i = 0; i < N; i++) {

			int temp = Arrays.binarySearch(dp, 0, size, arr[i]);
			if (temp >= 0) {
				idx[i]= -1; //안쓴놈들 처리
				continue; // 중복처리
			}
			int pos = Math.abs(temp) - 1;

			idx[i] = pos;
			dp[pos] = arr[i];

			if (pos == size)
				++size;

		}
		System.out.println(size);

		int id = size - 1;
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = N-1; i >= 0; i--) {
			
			if(id == -1) break;
			
			if(idx[i] == id) {
				stack.addFirst(arr[i]);
				id--;
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pollFirst()).append(" ");
		}
		
		System.out.println(sb);

	}

}
