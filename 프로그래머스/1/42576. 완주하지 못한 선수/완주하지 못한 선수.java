import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 맵에 참가자 저장
        for(String part : participant) {
            map.put(part , map.getOrDefault(part,0) + 1);
        }
        
        
        String answer = "";
        
        // 완주자들을 맵에서 확인하면서 value를 -1 함
        for(String comp : completion) {
            if(map.containsKey(comp)) {
                map.replace(comp, map.get(comp) - 1);
            }
        }
        
        // value 값이 0 이아니라면 완주 못한 사람이다.
        for (String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
            }
        }
        
        return answer;
    }
}