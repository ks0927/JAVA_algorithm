package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj4811 {

    public static void main(String[] args) throws IOException {

        //미리 작성할 dp리스트
        Long[][] dp = new Long[31][31];

        //Long 배열은 기본 null로 초기화 되어있기때문에 0으로 채워주자.
        for (int i = 0; i <= 30; i++) {
            Arrays.fill(dp[i],0L);
        }

        for (int H = 0; H <= 30; H++) {
            for (int W = 0; W <= 30; W++) {

                //어떤 경우에서든 W >= H 여야 한다
                if(H > W) continue;

                //H가 0인경우는 WW, WWW 와 같은 경우  즉 1가지
                if(H == 0) {
                    dp[W][H] = 1L;
                }

                else {
                    dp[W][H] = dp[W][H-1]+ dp[W-1][H];
                }
            }

        }
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 31; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N ==0){
                break;
            }
            //알약 N개는 N개의 W와 N개의 H가 필요하다.
            System.out.println(dp[N][N]);
        }
    }
}
