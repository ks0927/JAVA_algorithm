import java.io.*;
import java.util.*;

public class Main {
    static boolean[] outButton = new boolean[10];
    static boolean[] visited = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(M != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int out = Integer.parseInt(st.nextToken());
                outButton[out] = true;
            }
        }

        int bfs = bfs(N);

        int min = Math.min(bfs, Math.abs(N - 100));
        System.out.println(min);
    }

    public static int bfs(int num) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(num);
        visited[num] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                //같은 움직임이라도 자릿수가 작은경우가 있다.
                /*
                1555
                3
                0 1 9

                해당예시는 2222 와 888 둘다 같은 움직임이지만 888일때가 자릿수가 적어서 버튼을 적게누른다.
                */
                if (checkCanMake(poll)) {
                    return level + String.valueOf(poll).length();
                }

                visited[poll] = true;

                //따라서 큐에 넣을때 -1 경우를 먼저 넣는게 이득일때가 있다...;;
                if (poll - 1 >= 0 && !visited[poll - 1]) {
                    queue.add(poll - 1);
                }
                if (poll + 1 <= 999_999 && !visited[poll + 1]) {
                    queue.add(poll + 1);
                }

            }
            level++;
        }

        //불가능
        return Integer.MAX_VALUE;
    }

    public static boolean checkCanMake(int num) {
        while (num >= 10) {
            int target = num % 10;
            if (outButton[target]) {
                return false;
            }
            num /= 10;
        }

        if (outButton[num]) {
            return false;
        }

        return true;
    }
}
