import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			String k = st.nextToken();
			String num = st.nextToken();

			int int1;
			int int2;
			try {
				int1 = Integer.parseInt(num, 8);
			} catch (NumberFormatException e) {
				int1 = 0;
			}
			try {
				int2 = Integer.parseInt(num, 16);
			} catch (NumberFormatException e) {
				int2 = 0;
			}

			sb.append(k).append(" ").append(int1).append(" ").append(Integer.parseInt(num)).append(" ").append(int2).append("\n");
		}

		System.out.print(sb);
	}

}
