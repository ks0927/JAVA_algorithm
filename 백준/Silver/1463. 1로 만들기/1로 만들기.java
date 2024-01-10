import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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

        memo[1] = 1;
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
    }
}