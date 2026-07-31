import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int addServer = 0;
        Queue<int[]> que = new LinkedList<>();
        
        for(int i = 0; i < 24; i++) {
            
            if(!que.isEmpty()) {
                int[] cur = que.peek();
                if(cur[0] == i) {
                    addServer -= cur[1];
                    que.poll();
                }
            }
            if( (players[i] / m) - addServer > 0) {
                int add = (players[i] / m) - addServer;
                addServer+= add;
                answer+= add;
                if(i+k > i) que.add(new int[] {i+k,add});
                else addServer-=add;
            }

        }

        return answer;
    }
}