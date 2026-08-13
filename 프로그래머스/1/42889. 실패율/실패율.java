import java.util.*;

class Solution {
    
    static class Failure {
        int stage;
        double fail;
        
        Failure(int stage, double fail) {
            this.stage = stage;
            this.fail = fail;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        double[] failRate = new double[N+2];
        int[] ch = new int[N+2];
        
        int tot = stages.length;
        for(int i=0; i < stages.length; i++) {
            ch[stages[i]]++;
        }
        
        int sum = 0;
        for(int i=1; i < N+1; i++) {
            int remain = tot - sum;
            failRate[i] = (remain == 0) ? 0.0 : ch[i] / (double) remain;
            sum+=ch[i];
        }
        
        // System.out.println(Arrays.toString(failRate));
    
        List<Failure> arr = new ArrayList<>();
        
        for(int i=1; i < failRate.length -1; i++) {
            arr.add(new Failure(i , failRate[i]));
        }
        
        // 정렬
        arr.sort((a,b) -> {
            if(a.fail != b.fail) return Double.compare(b.fail, a.fail);
            return Integer.compare(a.stage , b.stage);
        });
        
        int idx = 0;
        for(Failure f : arr) {
            answer[idx] = f.stage;
            idx++;
        }
        
        return answer;
    }
}