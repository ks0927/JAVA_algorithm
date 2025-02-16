import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[] apple;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());
        apple = new int[T];
        for (int i = 0; i < T; i++) {
            apple[i] = Integer.parseInt(br.readLine());
        }

        int leftIndex = 1;
        int rightIndex = M;

        int flag = 0;
        int sum = 0;
        while (flag < T) {

            if (apple[flag] > rightIndex) {
                int move = apple[flag] - rightIndex;
                sum += move;
                rightIndex += move;
                leftIndex += move;
            }

            if (apple[flag] < leftIndex) {
                int move = leftIndex - apple[flag];
                sum += move;
                rightIndex -= move;
                leftIndex -= move;
            }

            flag++;
        }

        System.out.println(sum);
    }


}


