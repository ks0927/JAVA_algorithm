import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100_001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();

                int index = poll.index;

                if (index == K) {
                    result = poll.time;
                    System.out.println(result);
                    return;
                }

                int i3 = index * 2;
                int i1 = index - 1;
                int i2 = index + 1;

                if (i3 >= 0 && i3 < MAX && !visited[i3]) {
                    visited[i3] = true;
                    queue.add(new Node(i3, poll.time));
                }

                if (i1 >= 0 && i1 < MAX && !visited[i1]) {
                    visited[i1] = true;
                    queue.add(new Node(i1, poll.time + 1));
                }

                if (i2 >= 0 && i2 < MAX && !visited[i2]) {
                    visited[i2] = true;
                    queue.add(new Node(i2, poll.time + 1));
                }
            }
        }

    }

    static class Node {
        int index;
        int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

}
