import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        for(int cur : d) {
            if(cur <= budget) {
                answer++;
                budget-=cur;
            }else{
                break;
            }
        }
        return answer;
    }
}