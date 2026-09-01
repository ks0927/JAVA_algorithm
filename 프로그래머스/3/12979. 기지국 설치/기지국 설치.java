class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int gap = 0;
        int range = 2 * w + 1;
        
        // 맨 앞
        if( stations[0]-w - 1 > 0) {
            gap = stations[0]-w - 1;
            answer += (gap % range == 0 ) ? gap / range : gap / range +1;
        }
        
        // 각 정점 사이 
        for(int i=0; i < stations.length-1; i++) {
            int e = stations[i] + w;
            int s = stations[i+1] - w;
            
            if(s-e -1 > 0 ) {
                gap = s-e -1;
                answer += (gap % range == 0 ) ? gap / range : gap / range +1;
            }
        }
        
        // 맨뒤
        if( n - ( stations[stations.length-1] + w)  > 0) {
            gap = n - ( stations[stations.length-1] + w);
            answer += (gap % range == 0 ) ? gap / range : gap / range +1;
        }
        
        return answer;
    }
}