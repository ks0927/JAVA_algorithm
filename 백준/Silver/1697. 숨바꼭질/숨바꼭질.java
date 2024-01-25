import java.util.*;
import java.io.*;

public class Main {

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[100_001];

        int result = bfs(N, K);
        System.out.println(result);

    }

    private static int bfs(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int round = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                // 정답이면 return
                if (poll.equals(k)) {
                    return round;
                }

                // 방문한적있으면 pass
                if (visited[poll]) {
                    continue;
                }

                //방문했다고 체크
                visited[poll] = true;

                if (poll - 1 >= 0 && !visited[poll - 1]) {
                    queue.add(poll - 1);
                }
                if (poll + 1 <= 100_000 && !visited[poll + 1]) {
                    queue.add(poll + 1);
                }
                if (poll * 2 <= 100_000 && !visited[poll * 2]) {
                    queue.add(poll * 2);
                }

            }
            round++;
        }

        //불가능한 상황
        return -1;
    }

}
