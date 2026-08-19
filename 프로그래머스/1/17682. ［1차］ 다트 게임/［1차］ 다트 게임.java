import java.util.*;
class Solution {
    public int solution(String dartResult) {    
        int[] arr = new int[3];
        int idx = 0;
        
        String tmp = "";
        for(int i= 0; i< dartResult.length(); i++) {
            char a = dartResult.charAt(i);
            if(Character.isDigit(a)) {

                if(tmp.equals("")) {
                    tmp = String.valueOf(a);
                    continue;
                }
                
                if(a == '0' && tmp.equals("1")) {
                    tmp += String.valueOf(a);
                    continue;
                }
                
                //이제 tmp 처리
                if(tmp.contains("10")) {
                    int v = 10;
                    if(tmp.contains("D")) v = v*v;
                    if(tmp.contains("T")) v = v*v*v;
                    if(tmp.contains("*")) {
                        v *=2;
                        if(idx != 0) {
                            arr[idx-1] *= 2;
                        }
                    }
                    if(tmp.contains("#")) v *= -1;
                    arr[idx] = v;
                }else{
                    int v = tmp.charAt(0)-'0';
                    if(tmp.contains("D")) v = v*v;
                    if(tmp.contains("T")) v = v*v*v;
                    if(tmp.contains("*")) {
                        v *=2;
                        if(idx != 0) {
                            arr[idx-1] *= 2;
                        }
                    }
                    if(tmp.contains("#")) v *= -1;
                    arr[idx] = v;
                }
                idx+=1;

                tmp = String.valueOf(a);
            }
            else{
                tmp += String.valueOf(a);
            }

        }
        //나머지 처리
        if(tmp.contains("10")) {
            int v = 10;
            if(tmp.contains("D")) v = v*v;
            if(tmp.contains("T")) v = v*v*v;
            if(tmp.contains("*")) {
                v *=2;
                if(idx != 0) {
                    arr[idx-1] *= 2;
                }
            }
            if(tmp.contains("#")) v *= -1;
            arr[idx] = v;
        }else{
            int v = tmp.charAt(0)-'0';
            if(tmp.contains("D")) v = v*v;
            if(tmp.contains("T")) v = v*v*v;
            if(tmp.contains("*")) {
                v *=2;
                if(idx != 0) {
                    arr[idx-1] *= 2;
                }
            }
            if(tmp.contains("#")) v *= -1;
            arr[idx] = v;
        }

        int answer = 0;
        for(int i=0;i <3 ; i++) {
            answer += arr[i];
        }
        return answer;
    }
}