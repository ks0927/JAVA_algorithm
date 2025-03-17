import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] map = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			map[s].add(e);
			map[e].add(s);
		}
		
		int cnt = 0;
		
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer> friends = new ArrayList<>();
		visited[1] = true;
		for (int i = 0; i < map[1].size(); i++) {
			int friend = map[1].get(i);
			if(visited[friend]) continue;
			
			visited[friend] = true;
			cnt++;
			friends.add(friend);
		}
		
		for (Integer value : friends) {
			for (int i = 0; i < map[value].size(); i++) {
				int ff = map[value].get(i);
				if(visited[ff]) continue;
				
				visited[ff] = true;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
