import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long N = Long.parseLong(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		long[] map = new long[51];
		
		map[0] = 1;
		
		for (int i = 1; i <= b; i++) {
			map[i] = map[i-1] + (long)(Math.pow(2, i));
		}
		
		if(N <= map[b]) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	}

}
