import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] people;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int diff;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];

		map = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			map[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int person = Integer.parseInt(st.nextToken());
			people[i] = person;
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			int T = Integer.parseInt(st.nextToken());

			for (int j = 0; j < T; j++) {
				int endNode = Integer.parseInt(st.nextToken());
				map[i].add(endNode);
				map[endNode].add(i);
			}

		}

		diff = 100_000_000;
		visited = new boolean[N + 1];
		subset(1);

		System.out.println((diff == 100_000_000) ? -1 : diff);
	}

	// 모든 부분 조합 구하는 재귀함수
	private static void subset(int depth) {

		// 부분조합을 구했으면 true false값을 통해 2개의 선거구를 나눈다.
		if (depth == N + 1) {
			ArrayList<Integer> cityA = new ArrayList<>();
			ArrayList<Integer> cityB = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				if (visited[i])
					cityA.add(i);

				if (!visited[i])
					cityB.add(i);
			}

			if (cityA.size() == 0 || cityB.size() == 0) {
				return;
			}

			// city의 값들끼리 이어져있니?
			if (isConnected(cityA) && isConnected(cityB)) {
				compareCity(cityA, cityB); //이어져있다면 도시 인구수 비교
			}

			return;
		}

		visited[depth] = true;
		subset(depth + 1);
		visited[depth] = false;
		subset(depth + 1);
	}

	private static void compareCity(ArrayList<Integer> cityA, ArrayList<Integer> cityB) {
		int peopleA = 0;
		int peopleB = 0;

		for (Integer integer : cityA) {
			peopleA += people[integer];
		}
		for (Integer integer : cityB) {
			peopleB += people[integer];
		}

		int value = Math.abs(peopleA - peopleB);
		diff = Math.min(value, diff);
	}

	//bfs를 통해 간선들끼리 이어져있나 체크
	private static boolean isConnected(ArrayList<Integer> city) {

		boolean[] check = new boolean[N + 1];

		Queue<Integer> queue = new LinkedList<>();
		Integer init = city.get(0);
		queue.add(init);
		check[init] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer poll = queue.poll();

				for (Integer integer : map[poll]) {
					if (!check[integer] && city.contains(integer)) { //담겨있는지 체크해야됨 왜냐면 한바퀴돌아서 true될수도
						check[integer] = true;
						queue.add(integer);
					}
				}

			}
		}

		for (Integer integer : city) {
			if (!check[integer]) {
				return false;
			}
		}

		return true;

	}
}
