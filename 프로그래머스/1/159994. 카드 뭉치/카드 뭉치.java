import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {   
        int idx1 = 0;
        int idx2 = 0;
        
        for(String str : goal) {
        
            if(idx1 < cards1.length) {
                if(cards1[idx1].equals(str)) {
                idx1++;
                continue;
                }
            }
            
            if(idx2 < cards2.length) {
                if(cards2[idx2].equals(str)) {
                idx2++;
                continue;
                }
            }

            return "No";
        }
        
        return "Yes";
    }

}