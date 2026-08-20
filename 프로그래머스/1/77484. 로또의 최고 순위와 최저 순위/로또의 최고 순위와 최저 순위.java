class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6,6,5,4,3,2,1};
        
        int zcnt =0;
        int cnt =0;
        for(int i=0; i < 6; i++) {
            if(lottos[i] == 0) zcnt++;
            for(int j=0; j < 6 ; j++) {
                if(lottos[i] == win_nums[j]) cnt++;
            }
        }
        
        System.out.println("zcnt:"+zcnt);
        System.out.println("cnt:"+cnt);
        
        int[] answer = {rank[zcnt+cnt],rank[cnt]};
        return answer;
    }
}