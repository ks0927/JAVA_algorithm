import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] map;
    static int[] pick;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        pick = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(!arr.contains(value)) {
                arr.add(value);
            }
        }

        N = arr.size();
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = arr.get(i);
        }

        sb = new StringBuilder();
        Arrays.sort(map);

        perm(0);

        System.out.print(sb);
    }

    public static void perm(int depth) {
        if (depth == M) {
            for (int value : pick) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {

//            visited[i] = true;
            pick[depth] = map[i];
            perm(depth + 1);
//            visited[i] = false;
            pick[depth] = 0;

        }

    }
}
