package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        if(N ==1){
            System.out.println(1);
            return;
        }

//        BFS(N);
        Long[] memo = new Long[N+1];

        memo[1] = 1L;
        memo[2] = 1L;
        for (int i = 3; i <= N; i++) {
            long nowValue = memo[i - 2] + memo[i - 1];
            memo[i] = nowValue;
//            System.out.println("memo["+i+"] = " + memo[i]);
        }

        System.out.println(memo[N]);
    }

    private static void BFS(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        int count = 1;
        while (count != N){

//            System.out.println("count = " + count);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();

                if(poll == 0){
                    queue.add(1);
                    queue.add(0);
                }
                if(poll == 1){
                    queue.add(0);
                }
            }
            count++;
        }
        System.out.println(queue.size());
    }
}
