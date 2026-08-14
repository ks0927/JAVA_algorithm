import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        if(n==1) return new int[] {1};
        
        int[][] map = new int[n][n];
        
        int[] dr = {1,0,-1};
        int[] dc = {0,1,-1};
        
        int r = 0;
        int c = 0;
        int flag = 0;
        int num = 1;
        
        while(map[r][c] == 0) {
            map[r][c] = num++;
            
            int nr = r + dr[flag];
            int nc = c + dc[flag];
            
            // 방향전환
            if( !(nr >= 0 && nr < n && nc >= 0 && nc < n) || map[nr][nc] != 0) {
                flag = (flag + 1) % 3;
                r += dr[flag];
                c += dc[flag];
            }else{
                r = nr;
                c = nc;
            }
        }
        
        int[] answer = new int[num-1];
        
        int idx = 0;
        for(int i=0; i < n; i++) {
            for(int j=0; j< n; j++) {
                if(map[i][j]==0) break;
                answer[idx++] = map[i][j];
            }
        }
        

        return answer;
    }
}