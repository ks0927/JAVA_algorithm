import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int LCM = (M * N) / GCD(M, N);

            int solution = solution(x, LCM, M, y, N);
            sb.append(solution).append("\n");

        }

        System.out.println(sb);

    }

    static int solution(int x, int LCM, int M, int y, int N) {
        // x를 기준으로 최소공배수 까지 반복한다.
        // ex) M = 10 , N = 12, x = 3 ,y= 9
        // x = 3 기준, 3 , 13 , 23, 33 ,43 ,53 이렇게 돈다는 이야기
        for (int j = x; j <= LCM; j += M) {

            // 그렇게 돌면서 나온 값을 - y 한뒤 N으로 나누어떨어지는지 확인
            // 나누어 떨어지면 가능한 연도
            if ((j - y) % N == 0) {
                return j;
            }
        }
        // 일치하는 값이 없다면 불가능 하다는 것으로 -1 반환
        return -1;
    }

    // 유클리드 호제법을 이용한 최대공약수 구하기.
    // https://programmer-chocho.tistory.com/9
    static int GCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }

}

