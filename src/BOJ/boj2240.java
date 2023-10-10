package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2240 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] jadooTree = new int[T+1];

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(bf.readLine());
            int tree = Integer.parseInt(st.nextToken());
            jadooTree[i] = tree;
        }

        int[][][] dp = new int[2+1][T+1][W+1];

        for (int i = 1; i <= T; i++) {
            int nowValue = jadooTree[i];

            if(nowValue == 1){
                //dp[1]인경우 초기화
                for (int k = 0; k <= W; k++) {
                    //이동을 한적이 없다면 자두는 1위치에서 시작하므로 1을 더해준다.
                    if(k == 0){
                        dp[1][i][k] = dp[1][i-1][k] + 1;
                        continue;
                    }

                    dp[1][i][k] = Math.max(dp[1][i-1][k],dp[2][i-1][k-1])+1;
                }
                //dp[2]인경우 초기화
                for (int k = 0; k <= W; k++) {
                    if(k == 0){
                        dp[2][i][k] = dp[2][i-1][k];
                        continue;
                    }

                    dp[2][i][k] = Math.max(dp[2][i-1][k],dp[1][i-1][k-1]);
                }
            }
            if(nowValue == 2){
                //dp[2]인경우 초기화
                for (int k = 0; k <= W; k++) {
                    //이동을 한적이 없다면 자두는 1위치에서 시작하므로 2위치의 이전값을 그대로 사용한다.
                    if(k == 0){
                        dp[2][i][k] = dp[2][i-1][k];
                        continue;
                    }

                    dp[2][i][k] = Math.max(dp[2][i-1][k],dp[1][i-1][k-1])+1;
                }
                //dp[1]인경우 초기화
                for (int k = 0; k <= W; k++) {
                    if(k == 0){
                        dp[1][i][k] = dp[1][i-1][k];
                        continue;
                    }

                    dp[1][i][k] = Math.max(dp[1][i-1][k],dp[2][i-1][k-1]);
                }
            }

        }

/*        System.out.println("dp[1]");
        for (int i = 1; i <= T; i++) {

            for (int j = 0; j <= W; j++) {
                System.out.print(dp[1][i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("dp[2]");
        for (int i = 1; i <= T; i++) {

            for (int j = 0; j <= W; j++) {
                System.out.print(dp[2][i][j]+" ");
            }
            System.out.println();
        }*/

        int result = 0;
        for (int i = 1; i <= 2; i++) {

            for (int j = 0; j <= W; j++) {
                result = Math.max(dp[i][T][j],result);
            }
        }

        System.out.println(result);


    }
}
