import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> map = new ArrayList<>();
        
        int temp = -1;
        for(int value : arr) {
            if(value == temp) {
                continue;
            }else{
                temp = value;
                map.add(value);
            }
        }
        
        int[] answer = map.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}