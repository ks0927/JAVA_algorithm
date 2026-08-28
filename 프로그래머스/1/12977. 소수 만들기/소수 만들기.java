import java.util.*;

class Solution {
    static int R,N;
    static int[] map;
    static int answer;
    
    public int solution(int[] nums) {
        
        R = 3;
        N = nums.length;
        map = new int[3];
        combi(0,0, nums,0);

        return answer;
    }
    
    static void combi(int depth, int start, int[] nums,int sum) {
        if(depth == R) {
            
            for(int i=2; i<= Math.sqrt(sum); i++) {
                if(sum % i == 0) return; 
            }
            answer++;
            
            return;
        }
        
        for(int i=start; i < N; i++) {
            map[depth] = nums[i];
            combi(depth+1, i+1,nums,sum + nums[i]);
            map[depth] = 0;
            
        }
    }
}