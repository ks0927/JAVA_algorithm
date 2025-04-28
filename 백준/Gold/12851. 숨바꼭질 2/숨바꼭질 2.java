import java.io.*;
import java.util.*;

public class Main {
	static int N,K;
	static int[] times;
	static int[] cnts;
	
	static class Point implements Comparable<Point> {
		int index;
		int time;
		public Point(int index, int time) {
			this.index = index;
			this.time = time;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.time, o.time);
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		times = new int[100001];
		cnts = new int[100001];
		
		Arrays.fill(times, 100001);
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.add(new Point(N, 0));
		times[N] = 0;
		cnts[N] = 1;
		
		boolean flag = false;
		while(!pq.isEmpty()) {
			
			int size = pq.size();
			
			if(flag) break;
			
			for (int i = 0; i < size; i++) {
				Point poll = pq.poll();
				
				if(check(poll.index+1)) {
					if(times[poll.index+1] >= times[poll.index] + 1) {
						times[poll.index+1] = times[poll.index] + 1;
						cnts[poll.index+1] += 1;
						
						pq.add(new Point(poll.index+1,times[poll.index+1]));
						if(poll.index+1 == K) flag = true;
					}
				}
				
				if(check(poll.index-1)) {
					if(times[poll.index-1] >= times[poll.index] + 1) {
						times[poll.index-1] = times[poll.index] + 1;
						cnts[poll.index-1] += 1;
						
						pq.add(new Point(poll.index-1,times[poll.index-1]));
						if(poll.index-1 == K) flag = true;
					}
				}
				
				if(check(poll.index*2)) {
					if(times[poll.index*2] >= times[poll.index] + 1) {
						times[poll.index*2] = times[poll.index] + 1;
						cnts[poll.index*2] += 1;
						
						pq.add(new Point(poll.index*2,times[poll.index*2]));
						if(poll.index*2 == K) flag = true;
					}
				}
 			}
		}
		
		System.out.println(times[K]);
		System.out.println(cnts[K]);
	}

	public static boolean check(int r) {
		return r >= 0 && r < 100001;
	}
}
