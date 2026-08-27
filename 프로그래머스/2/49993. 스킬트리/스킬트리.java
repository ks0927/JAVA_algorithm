import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character,Integer> map = new HashMap<>();
        
        int idx =1;
        for(char cur : skill.toCharArray()) {
            map.put(cur,idx++);
        }
        
        for(String str : skill_trees) {
            int check = 1;
            boolean flag = false;
            
            for(int i=0; i < str.length(); i++) {
                
                char now = str.charAt(i);
                if(map.containsKey(now)) {
                    if(map.get(now) == check) {
                        check++;
                    }else{
                        flag = true;
                        break;
                    }
                }
  
            }
            
            if(!flag) answer++; 
            
        }
        
        return answer;
    }
}