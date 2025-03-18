import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] vid = new int[N];
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			vid[i] = value;
			sum+= value;
			max = Math.max(max, value);
		}
		
		int start = max;
		int end = sum;
		int mid;
		while(start < end) {
			mid = (start + end)/2;
			
			int cnt = 0;
			int s = 0;
			for (int i = 0; i < N; i++) {
				s+= vid[i];
				if(s > mid) {
					cnt++;
					s=vid[i];
				}
			}
			cnt++;
			
//			System.out.println("start: "+start+"end: "+end+"mid: "+mid+"cnt: "+cnt);
			if(cnt > M) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		
		System.out.println(end);
	}

}
