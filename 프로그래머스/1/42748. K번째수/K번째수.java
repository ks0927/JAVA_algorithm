import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int N = commands.length;
        
        int[] answer = new int[N];
        for(int i = 0; i < N ; i++) {
            
            int s = commands[i][0] - 1;
            int e = commands[i][1] - 1;
            int k = commands[i][2] - 1;
            
            ArrayList<Integer> splitArr = new ArrayList<>();
            for(int j = s; j <= e ; j++) {
                splitArr.add(array[j]);
            }
            
            Collections.sort(splitArr);
            answer[i] = splitArr.get(k);
        }
        return answer;
    }
}