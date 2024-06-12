import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] house = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			int parseInt = Integer.parseInt(st.nextToken());
			house[i] = parseInt;
		}
		
		Set<Integer> set = new HashSet<>();
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			//house[s] 부터 house[e]까지 + 1 
			// s부터 e까지 돌면서 Set<Integer>로 비온 집 기록해두기
			for(int j = s; j <= e; j++) {
				set.add(j);
				house[j]+=1;
			}
			
			if(i%3 == 0) {
				// 배수 시스템 작동
				// Set에 있는 숫자들을 x 라고 하면 house[x]의 값들을 1씩 모두 줄인다.
				// 그 뒤 Set을 초기화한다.
				for(Integer rained : set) {
					house[rained]-=1;
				}
				set.clear();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < n; i++) {
			sb.append(house[i]).append(" ");
		}
		sb.append(house[n]).append("\n");
		
		System.out.println(sb);
	}
}