import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());

            if(map.containsKey(v)) {
                map.remove(v);
            }else {
                map.put(v,1);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(st.nextToken());

            if(map.containsKey(v)) {
                map.remove(v);
            }else {
                map.put(v,1);
            }
        }

        System.out.println(map.size());

    }

}

