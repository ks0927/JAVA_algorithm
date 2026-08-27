
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        
        boolean[][][] visited = new boolean[11][11][4];
        
        int r = 5;
        int c = 5;
        for(char cur : dirs.toCharArray()) {
            
            int dir = 0;

            if (cur == 'U') dir = 0;
            if (cur == 'D') dir = 1;
            if (cur == 'R') dir = 2;
            if (cur == 'L') dir = 3;

            int nr = r + dr[dir];
            int nc = c + dc[dir];
            
            if (nr < 0 || nr >= 11 || nc < 0 || nc >= 11) {
                continue;
            }
            
            if(!visited[nr][nc][dir]) {
                visited[nr][nc][dir] = true;
                answer++;
                
                if(dir ==0) visited[r][c][1] = true;
                if(dir ==1) visited[r][c][0] = true;
                if(dir ==2) visited[r][c][3] = true;
                if(dir ==3) visited[r][c][2] = true;
            }
            
            r = nr;
            c = nc;
        }
        
        return answer;
    }
}