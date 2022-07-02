package String;

import java.util.Scanner;

public class compressWord {
    public  String solution(String str){
        String answer ="";
        str= str+" "; //다음 문자찾을때 에러 방지용 빈공간
        int cnt = 1;
        for(int i=0 ; i<str.length()-1; i++){
            if(str.charAt(i)==str.charAt(i+1)){
                cnt++;
            }
            else{
                answer+=str.charAt(i);
                if(cnt>1){
                    answer+=String.valueOf(cnt);
                }
                cnt =1;
            }
        }
        return  answer;
    }

    public static void main(String[] args){
        compressWord C = new compressWord();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.println(C.solution(str));
    }
}
