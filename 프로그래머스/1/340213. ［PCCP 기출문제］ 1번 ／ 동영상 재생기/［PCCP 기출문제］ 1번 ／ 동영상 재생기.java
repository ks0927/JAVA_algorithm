class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int VL = convertSecond(video_len);
        int PS = convertSecond(pos);
        int OS = convertSecond(op_start);
        int OE = convertSecond(op_end);

        if(PS >= OS && PS <= OE) {
            PS = OE;
        }
        
        for(String cmm : commands) {
            if(cmm.equals("prev")) {
                
                if(PS-10 < 0) {
                    PS = 0;
                }else{
                    PS -= 10;
                } 

            }
            
            if(cmm.equals("next")) {
                
                if(PS+10 > VL) {
                    PS = VL;
                }else{
                    PS += 10;
                } 
            }
            if(PS >= OS && PS <= OE) {
                PS = OE;
            }
        }
        
        
        String answer = String.format("%02d:%02d",PS/60,PS%60);
        
        return answer;
    }
    
    public static int convertSecond(String str) {
        String[] parse = str.split(":");
        
        int sum = 0;
        
        sum += (Integer.parseInt(parse[0]) * 60);
        sum += (Integer.parseInt(parse[1]));
                
        return sum;
    }
}