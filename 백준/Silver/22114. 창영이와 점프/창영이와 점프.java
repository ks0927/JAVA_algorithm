import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int K;

    static int[] p;
    static int[] r;
    static int[] length;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        length = new int[N];
        for (int i = 1; i < N; i++) {
            int w = Integer.parseInt(st.nextToken());
            length[i] = w;
        }

        init();
        for (int i = 1; i < N; i++) {
            union(i,i+1);
        }

//        System.out.println(Arrays.toString(p));
//        System.out.println(Arrays.toString(r));

        int group  = p[1];
        int blocks = r[p[1]];

        int max = blocks;
        for (int i = 1; i <= N; i++) {
//            System.out.println("group = " + group);
//            System.out.println("blocks = " + blocks);

            int curGroup = p[i];
            if(group != curGroup) {
//                System.out.println("curGroup = " + curGroup);
                max = Math.max(max , blocks + r[curGroup]);
                group = curGroup;
                blocks = r[curGroup];
            }
        }

        System.out.println(max);
    }

    static void init() {
        p = new int[N + 1];
        r = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }

    static int find(int a) {
        if (a == p[a]) return p[a];
        return p[a] = find(p[a]);
    }

    static boolean union(int s, int e) {
        int x = find(s);
        int y = find(e);

        if(x == y) return false;

        //s에서e까지 거리가 K보다 크면 못 연결함
        if(length[s] > K) return false;

        if(r[x] > r[y]) {
            p[y] = x;
            r[x] += r[y];
        }else {
            p[x] = y;
            r[y] += r[x];
        }

        return true;
    }

}