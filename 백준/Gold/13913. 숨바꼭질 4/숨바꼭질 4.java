import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.println(0);
            System.out.println(N);
            return;
        }

        int[] dp = new int[100001];
        int[] index = new int[100001];

        Arrays.fill(dp, 1000000);
        Arrays.fill(index, -2);

        findBrother(dp, index);

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int idx = K;
        while (idx != -1) {
            stack.addFirst(idx);
            idx = index[idx];
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst()).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

    private static void findBrother(int[] dp, int[] index) {
        dp[N] = 0;
        index[N] = -1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();


                if (poll + 1 < 100001 && dp[poll + 1] > dp[poll] + 1) {
                    dp[poll + 1] = dp[poll] + 1;
                    index[poll + 1] = poll;

                    if (poll + 1 == K) {
                        System.out.println(dp[poll + 1]);
                        return;
                    }
                    queue.add(poll + 1);
                }
                if (poll - 1 >= 0 && dp[poll - 1] > dp[poll] + 1) {
                    dp[poll - 1] = dp[poll] + 1;
                    index[poll - 1] = poll;
                    if (poll - 1 == K) {
                        System.out.println(dp[poll - 1]);
                        return;
                    }
                    queue.add(poll - 1);
                }
                if (poll * 2 < 100001 && dp[poll * 2] > dp[poll] + 1) {
                    dp[poll * 2] = dp[poll] + 1;
                    index[poll * 2] = poll;

                    if (poll * 2 == K) {
                        System.out.println(dp[poll * 2]);
                        return;
                    }
                    queue.add(poll * 2);
                }
            }

        }
    }


}

