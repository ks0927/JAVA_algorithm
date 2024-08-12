import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static ArrayList<ArrayList<Node>> graph;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        //그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        map = new int[N + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        int result = dijkstra(startPoint, endPoint);
        System.out.print(result);

    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        // 오름차순
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    //다익스트라
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(new Node(start, 0));
        map[start] = 0;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentNode = poll.end;

            if(!visited[currentNode]) {
                visited[currentNode] = true;

                for (Node node : graph.get(currentNode)) {
                    int nextNode = node.end;

                    if (!visited[nextNode]) {
                        if (map[nextNode] > map[currentNode] + node.weight) {
                            map[nextNode] = map[currentNode] + node.weight;
                            queue.add(new Node(nextNode, map[nextNode]));
                        }
                    }
                }

            }

        }

        return map[end];
    }

}
