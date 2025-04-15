import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String str: participant) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }
        
        for(String str: completion) {
            if(map.get(str) == 1) {
                map.remove(str);
            }else{
                map.put(str, map.get(str) - 1);
            }
        }
        
        ArrayList<String> result = new ArrayList<>(map.keySet());
        String answer = result.get(0);
        return answer;
    }
}