class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        long low = 1;
        long top = limit;
        
        long index = 0;
        // check 해봐서 가능하면 작은쪽을 살펴 보고 아니면 큰쪽을 살펴봐야함 
        // 이분탐색
        while(low <= top) {
            index = (low + top) / 2;
            
            if(check(index,diffs,times,limit)) {
                top = index - 1;
            }else{
                low = index + 1;
            }
        }
        int answer = (int) low;
        return answer;
    }
    
    public static boolean check(long level, int[] diffs, int[] times, long limit) {
        long sum = 0;
        for(int i = 0; i < diffs.length; i++) {
            if(diffs[i] <= level) {
                sum += times[i];
            }else{
                sum += ( (diffs[i] - level) * (times[i] + times[i - 1]) + times[i] );
            }
        }
        
        if(sum > limit){
            return false;
        }
        
        return true;
    }
}