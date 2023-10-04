package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1463 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int X = Integer.parseInt(st.nextToken());

        if(X == 1){
            System.out.println(0);
            return;
        }
        int bfs = BFS(X);

        System.out.println(bfs);

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
