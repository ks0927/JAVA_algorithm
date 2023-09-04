package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2644 {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int s1;
    static int s2;
    static int m;

    public static int solution(int s1, int s2) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s1);
        visited[s1][s1] = true;
        int result = 0;

        while (!queue.isEmpty()) { //큐가 비었니
            ++result;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                Integer poll = queue.poll();

                if(poll ==s2) return result;

                for (int i = 1; i <= n; i++) {
                    if(map[poll][i] ==1 && !visited[poll][i]){
//                        System.out.println("i = " + i);
//                        System.out.println("result = " + result);
                        if(i ==s2) return result;
                        queue.add(i);
                        visited[poll][i] =true;
                    }
                }

            }
        }
        return -1;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        s1 = Integer.parseInt(st.nextToken());
        s2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            map[parent][child] =1;
            map[child][parent] =1;
        }

        int solution = solution(s1, s2);
        System.out.println(solution);

    }
}
