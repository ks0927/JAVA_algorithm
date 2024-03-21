import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map.put(start, end);
        }

        boolean[] visited = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                for (int j = 1; j <= 6; j++) {
                    int next = poll + j;

                    if (next >= 100) {
                        System.out.println(level + 1);
                        return;
                    }

                    if (!visited[next]) {
                        if (map.containsKey(next)) {
                            next = map.get(next);
                        }
                        queue.add(next);
                        visited[next] = true;
                    }

                }
            }
            level++;
        }
    }


}
