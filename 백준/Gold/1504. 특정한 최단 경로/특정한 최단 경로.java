import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> nodes;
    static boolean[] visited;
    static int[] map;
    static int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        nodes = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            nodes.add(new ArrayList<Node>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            nodes.get(a).add(new Node(b, c));
            nodes.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        visited = new boolean[N + 1];
        // 1 -> u -> v -> N 순서로 이동
        int type1 = 0;
        type1 += dijkstra(1, u);
        type1 += dijkstra(u, v);
        type1 += dijkstra(v, N);

        // 1 -> v -> u -> N 순서로 이동
        int type2 = 0;
        type2 += dijkstra(1, v);
        type2 += dijkstra(v, u);
        type2 += dijkstra(u, N);

        int ans = (type1 >= INF && type2 >= INF) ? -1 : Math.min(type1, type2);

        System.out.println(ans);
    }

    //다익스트라
    static int dijkstra(int start, int end) {
        Arrays.fill(map, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0)); //시작노드
        map[start] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                int cur = poll.next; //현재 노드

                if (!visited[cur]) { //현재 노드가 방문한적없으면
                    visited[cur] = true;

                    for (Node node : nodes.get(cur)) { //현재 노드로 부터 갈수있는 노드들을 확인하는데
                        if (!visited[node.next] && map[node.next] > map[cur] + node.weight) { // 간적없으면서, 최소의 비용으로 이동이가능할때 초기화해주고 큐에 다시 넣어준다.
                            map[node.next] = map[cur] + node.weight;
                            queue.add(new Node(node.next, map[node.next]));
                        }
                    }
                }
            }
        }

        return map[end];
    }

    static class Node implements Comparable<Node> {
        int next;
        int weight;

        public Node(int next, int weight) {
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (this.weight > o.weight) {
                return 1;
            }
            if (this.weight < o.weight) {
                return -1;
            }

            return 0;
        }
    }
}
