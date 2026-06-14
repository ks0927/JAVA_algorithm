import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        // map에 순위 저장 -> index 기반으로 실제 순위 조정
        
        HashMap<String,Integer> rank = new HashMap<>();
        for(int i =0; i < players.length; i++) {
            answer[i] = players[i];
            rank.put(players[i],i+1);
        }
        
        for(int i = 0; i < callings.length; i++) {
            
            String cur = callings[i];
            int curRank = rank.get(cur);
            
            String change = answer[curRank-2];
            answer[curRank-2] = cur;
            answer[curRank-1] = change;
            rank.put(cur, curRank-1);
            rank.put(change, curRank);
            
        }
        
        return answer;
    }
}