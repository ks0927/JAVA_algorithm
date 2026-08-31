import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = 0;
        for(int i = 0; i < A.length ; i++) {
            
            int cur = A[i];
            while(idx < A.length) {
                if(B[idx] > cur) {
                    answer++;
                    idx++;
                    break;
                }
                idx++;
            }
            
        }
        return answer;
    }
}