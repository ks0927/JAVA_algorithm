import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int v : arr) {  
            if(dq.isEmpty()){
                dq.addFirst(v);
            }else{ 
                if(dq.peekFirst() == v){
                    continue;
                }
                dq.addFirst(v); 
            }
        }

        int[] answer = new int[dq.size()];
        
        int size = dq.size();
        for(int i = 0; i < size; i++) {
            answer[i] = dq.pollLast();
        }
        
        return answer;
    }
}