import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        int[] map = new int[N + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        // 다익스트라
        // 한점에서 모든 정점까지의 최단거리를 구함
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new Node(K, 0));
        map[K] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentNode = poll.v;

            if (!visited[currentNode]) {
                visited[currentNode] = true;

                for (Node node : graph.get(currentNode)) {
                    int nextNode = node.v;

                    if (!visited[nextNode]) {
                        if (map[nextNode] > map[currentNode] + node.weight) {
                            map[nextNode] = map[currentNode] + node.weight;
                            queue.add(new Node(nextNode, map[nextNode]));
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (map[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(map[i]);
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }


    static class Node implements Comparable<Node> {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
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
