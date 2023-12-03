import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        for (int i = 0; i < N - 1; i++) {
            Integer remove = queue.poll();
            if(queue.size() == 1){
                break;
            }
            Integer poll = queue.poll();
            queue.add(poll);
        }
        System.out.println(queue.poll());
    }
}