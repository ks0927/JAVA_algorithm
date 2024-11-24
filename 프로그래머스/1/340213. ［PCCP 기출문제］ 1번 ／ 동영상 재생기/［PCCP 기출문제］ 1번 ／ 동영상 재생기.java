import java.util.*;
import java.io.*;

class Solution {
    static int  totalOpS;
    static int  totalOpE;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) { 
        
        int result = 0;
        int totalVid = convertTotalSec(video_len);
        int totalPos = convertTotalSec(pos);
        totalOpS = convertTotalSec(op_start);
        totalOpE = convertTotalSec(op_end);
        
        
        result = checkSkip(totalPos);
        
        for(int i = 0; i < commands.length; i++) {
            if(commands[i].equals("next")) {
                result = (totalVid < result + 10 ) ? totalVid : result + 10;
            }
            if(commands[i].equals("prev")) {
                result = (0 > result - 10 ) ? 0 : result - 10;
            }
            
            result = checkSkip(result);
        }
        
        String answer = String.format("%02d:%02d",result / 60, result % 60);

        return answer;
    }
    
    static public int convertTotalSec(String time) {
        String[] split_time = time.split(":");
        
        int min = Integer.parseInt(split_time[0]);
        int sec = Integer.parseInt(split_time[1]);
        
        return min*60 + sec;
    }
    
    static public int checkSkip(int time) {
        if(time <= totalOpE && time >= totalOpS) {
            return totalOpE;
        }
        
        return time;
    }
}