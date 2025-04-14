class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        
        int left = 1;
        int right = 300000;
        int mid;
        
        while(left < right) {
            mid = (left + right) / 2;
            
            long sum = timeSum(diffs, times, mid);
            
            if(sum > limit) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        
        return left;
    }
    
    public static long timeSum(int[] diffs, int[] times, int level) {
        long sum = 0;
        
        for(int i = 0; i < diffs.length; i++) {
            
            if(diffs[i] <= level) {
                sum += times[i];
            }else{
                sum += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
            }
      
        }   
        
        return sum;
    }
}