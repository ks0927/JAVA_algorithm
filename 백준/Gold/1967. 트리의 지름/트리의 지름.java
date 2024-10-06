import java.io.*;
import java.util.*;

public class Main {

    static int ans = 0;
    static int N;
    static ArrayList<ArrayList<Node>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(parent).add(new Node(child, weight));
            graph.get(child).add(new Node(parent, weight));

        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1];
            DFS(i, 0);
        }

        System.out.println(ans);
    }


    static class Node {
        int child;
        int weight;

        public Node(int child, int weight) {
            this.child = child;
            this.weight = weight;
        }

    }

    static void DFS(int index, int sum) {

        if(ans < sum) {
            ans = sum;
        }

        if(!visited[index]){
            visited[index] = true;

            for (Node nodes : graph.get(index)) {
                if(!visited[nodes.child]) {
                    DFS(nodes.child,sum + nodes.weight);
                }
            }
        }
    }

}
