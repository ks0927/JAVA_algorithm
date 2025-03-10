import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] time;
    static int[] degree;
    static int[] dp;
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            time = new int[N + 1];
            degree = new int[N + 1];
            dp = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }
            map = new ArrayList[N + 1];
            for (int j = 0; j <= N; j++) {
                map[j] = new ArrayList<>();
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                map[s].add(e);
                degree[e] += 1;
            }
            int target = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new ArrayDeque<>();
            for (int j = 1; j <= N; j++) {
                if (degree[j] == 0) {
                    queue.add(j);
                    dp[j] = time[j];
                }
            }

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Integer poll = queue.poll();

                    for (int end : map[poll]) {
                        degree[end] -= 1;
                        dp[end] = Math.max(dp[end], dp[poll] + time[end]);
                        if (degree[end] == 0) {
                            queue.add(end);
                        }
                    }
                }
            }

            sb.append(dp[target]).append("\n");
        }

        System.out.print(sb);
    }


}