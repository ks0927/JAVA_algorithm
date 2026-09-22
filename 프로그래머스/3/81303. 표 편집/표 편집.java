import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] delete = new boolean[n];
        
        // 0 = prev , 1 next
        int[][] map = new int[n][2];
        
        for(int i=0 ; i < n ; i++) {
            map[i][0] = i-1;
            map[i][1] = i+1;
        }

        int curIdx = k;
        
        for(String command : cmd) {
            
            String[] split = command.split(" ");
            String type = split[0];
            
            if(type.equals("U")) {
                for(int i =0 ; i < Integer.parseInt(split[1]); i++) {
                    curIdx = map[curIdx][0];
                }
            }
            
            if(type.equals("D")) {
                for(int i =0 ; i < Integer.parseInt(split[1]); i++) {
                    curIdx = map[curIdx][1];
                }
            }
            
            if(type.equals("C")) {
                
                int pre = map[curIdx][0];
                int nx = map[curIdx][1];
                stack.push(curIdx);
                delete[curIdx] = true;
                
                if(pre != -1) map[pre][1] = nx;
                if(nx != n) map[nx][0] = pre;
                
                if(nx == n) {
                    curIdx = map[curIdx][0];
                }else{
                    curIdx = map[curIdx][1];
                }

            }
            
            if(type.equals("Z")) {
                int restore = stack.pop();
                delete[restore] = false;
                
                int pre = map[restore][0];
                int nx = map[restore][1];
                
                if(pre != -1) map[pre][1] = restore;
                if(nx != n) map[nx][0] = restore;
                
            }

        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i =0; i < n; i++) {
            sb.append(delete[i] ? "X" : "O");
        }
        
        return sb.toString();
    }
}