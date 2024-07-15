import java.io.*;
import java.util.*;

public class Main {
    // 참고 https://velog.io/@doxxx93/boj-11725
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[] parentsNode = new int[T + 1]; // 부모노드 값
        boolean[] visited = new boolean[T + 1]; // 부모노드 값
        ArrayList<Integer>[] trees = new ArrayList[T + 1]; // 그래프 인접리스트
        for (int i = 1; i <= T; i++) {
            trees[i] = new ArrayList<>();
        }

        for (int i = 1; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int Node1 = Integer.parseInt(st.nextToken());
            int Node2 = Integer.parseInt(st.nextToken());

            trees[Node1].add(Node2);
            trees[Node2].add(Node1);
        }

        // bfs로 그래프(트리) 순회
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                ArrayList<Integer> tree = trees[poll];
                for (Integer child : tree) {
                    if(!visited[child]) {
                        visited[child] = true;
                        parentsNode[child] = poll;
                        queue.add(child);
                    }
                }
            }
        }

        for (int i = 2; i <= T; i++) {
            sb.append(parentsNode[i]).append("\n");
        }

        System.out.print(sb);

    }

}
