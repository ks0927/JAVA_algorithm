class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        // dp[i][j][0]은 i,j에 아래 방향으로 들어올수있는 경우
        // dp[i][j][1]은 i,j에 오른쪽 방향으로 들어올수있는 경우
        int[][][] dp = new int[m][n][2];
        
        for(int i=0; i < m ; i++) {
            if(cityMap[i][0] == 1) break;
            dp[i][0][0] = 1;
        }
        
        for(int i=0; i < n ; i++) {
            if(cityMap[0][i] == 1) break;
            dp[0][i][1] = 1;
        }
        
        
        for(int i= 1; i < m; i++) {
            for(int j=1; j < n; j++) {
                
                if(cityMap[i][j] == 1) continue;           
                
                int down = dp[i-1][j][0];
                if(cityMap[i-1][j] == 0) {
                    down = (down + dp[i-1][j][1]) % MOD;
                }
                
                int right = dp[i][j-1][1];
                if(cityMap[i][j-1] == 0) {
                    right = (right + dp[i][j-1][0]) % MOD;
                }
                
                dp[i][j][0] = down;
                dp[i][j][1] = right;
            }
        }
        
        answer = (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
        return answer;
    }
}