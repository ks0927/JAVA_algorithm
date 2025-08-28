import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			long n = Long.parseLong(st.nextToken());
			long m = Long.parseLong(st.nextToken());

			int cnt = 0;
			while (n != 1) {
				n /= 2;
				cnt++;
			}

			sb.append(cnt + m + 1).append("\n");
		}
		
		System.out.println(sb);
	}

}
