class Solution {
    
    static int[] dr = {0,1,-1,0};
    static int[] dc = {1,0,0,-1};
    static int R;
    static int C;
    
    public int solution(String[][] board, int h, int w) {

        R = board.length;
        C = board[0].length;
        
        String cur = board[h][w];
        
        int cnt = 0;
        for(int i=0;i < 4 ; i++) {
            
            int cr = h + dr[i];
            int cc = w + dc[i];
            
            if(!vaild(cr,cc)){
                continue;
            }
            
            if(cur.equals(board[cr][cc])) cnt++;
        }
        
        
        return cnt;
    }
    
    static boolean vaild(int r, int c) {
        return (r>=0 && r <R && c>=0 && c < C);
    }
}