import java.util.*;

class Solution {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] map = new int[rows+1][columns+1];   
        int a = 1;
        for(int i=1; i <= rows; i++) {
            for(int j=1; j<= columns; j++) {
                map[i][j] = a++;
            }
        }
        
        
        for(int i=0; i < queries.length; i++) {
            
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            int S = (x2-x1 + y2-y1) * 2;

            // 돌면서 최소값 찾고 값들 저장
            List<Integer> vals = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            int r=x1;
            int c=y1;
            int flag=0;
            while (vals.size() < S) {
                vals.add(map[r][c]);
                min = Math.min(min, map[r][c]);
                int nr = r+dr[flag];
                int nc = c+dc[flag];
                if (nr<x1 || nr>x2 || nc<y1 || nc>y2) {
                    flag = (flag+1)%4;
                    nr = r+dr[flag];
                    nc = c+dc[flag];
                }
                r=nr;
                c=nc;
            }
            answer[i] = min;
            
            // flat하게 한거 한칸 밀기 
            vals.add(0, vals.remove(vals.size()-1));

            // 다시돌면서 저장한 값들 채우기
            r=x1; c=y1; flag=0;
            int idx=0;
            while (idx < S) {
                map[r][c] = vals.get(idx++);
                int nr = r+dr[flag];
                int nc = c+dc[flag];
                if (nr<x1 || nr>x2 || nc<y1 || nc>y2) {
                    flag = (flag+1)%4;
                    nr = r+dr[flag];
                    nc = c+dc[flag];
                }
                r=nr;
                c=nc;
            }
            
        }

        return answer;
    }
}