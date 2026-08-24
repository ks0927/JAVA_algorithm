import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        Map<String,Integer> map = new HashMap<>();
        char last = 0;
        for(int i=0; i < words.length; i++) {
            String cur = words[i];
            
            if(last != 0) { 
                if(last != cur.charAt(0)) {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
                if(map.containsKey(cur)) {
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
            }
            map.put(cur,1);
            last = cur.charAt(cur.length()-1);
        }

        return answer;
    }
}