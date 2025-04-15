import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int N  = nums.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int p : nums) {
            set.add(p);
        }
        
        int t = N/2;
        
        if(set.size() > t) {
            answer = t;
        }else{
            answer = set.size();
        }
        
        return answer;
    }
}