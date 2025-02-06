import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] shirts = new int[6];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			int value = Integer.parseInt(st.nextToken());
			shirts[i] = value;
		}

		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		int tvalue = 0;

		for (int i : shirts) {
			int a = i / T;
			int b = (i % T > 0) ? 1 : 0;
			
			tvalue = tvalue + a + b;
		}
		
		int pvalue1 = N / P;
		int pvalue2 = N % P;
		
		sb.append(tvalue).append("\n");
		sb.append(pvalue1).append(" ").append(pvalue2);
		
		System.out.println(sb);
	}

}
