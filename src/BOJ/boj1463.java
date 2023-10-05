package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1463 {
    static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int X = Integer.parseInt(st.nextToken());

        if(X == 1){
            System.out.println(0);
            return;
        }

        if(X == 2 || X == 3){
            System.out.println(1);
            return;
        }

        memo = new int[X+1];

        Arrays.fill(memo,Integer.MAX_VALUE);

        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;



        for (int i = 1; i <= X; i++) {
            if(i % 3 == 0){
                int value = 0;
                int n3 = value + 1;
                int nextValue = i / 3;
                value = memo[nextValue] + n3;
                memo[i] = Math.min(memo[i],value);
            }
            if(i % 2 == 0){
                int value = 0;
                int n2 = value + 1;
                int nextValue = i / 2;
                value = memo[nextValue] + n2;
                memo[i] = Math.min(memo[i],value);
            }
            if(i != 1){
                int value = 0;
                int nMinus = value + 1;
                int nextValue = i-1;
                value = memo[nextValue] + nMinus;
                memo[i] = Math.min(memo[i],value);
            }

        }

        System.out.println(memo[X]);




/*
        if(X == 1){
            System.out.println(0);
            return;
        }
        int bfs = BFS(X);

        System.out.println(bfs);
*/

    }


    static int BFS(int num){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);

        int count = 0;

        while(!(queue.isEmpty())){
            count++;
//            System.out.println("count = " + count);
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
//                System.out.println("poll = " + poll);

                if(poll == 1){
                    return count;
                }

                if(poll % 3 == 0){
                    int num3 = poll / 3;
                    if(num3 ==1){
                        return count;
                    }
                    queue.add(num3);
                }

                if(poll % 2 == 0){
                    int num2 = poll / 2;
                    if(num2 ==1){
                        return count;
                    }
                    queue.add(num2);
                }

                if(poll != 1) {
                    int numMinus1 = poll-1;
                    if(numMinus1 ==1){
                        return count;
                    }
                    queue.add(numMinus1);
                }

            }
        }

        return count;

    }
}
