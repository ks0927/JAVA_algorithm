package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj1758 {

    static int N;
    static Long result;
    static Integer[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        line = new Integer[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            line[i] = a;
        }

        //내림차순으로 정렬한뒤 팁을 받는게 최대로 돈을 받을수있다.
        Arrays.sort(line, Collections.reverseOrder());

        result = 0L;
        for (int i = 0; i < line.length; i++) {
            if(line[i]-i <= 0)
                break;
            result += line[i]-i;
        }

        System.out.println(result);
    }
}
