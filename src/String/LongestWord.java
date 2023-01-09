package String;

import java.util.Scanner;

public class LongestWord {
    //split을 사용해서 길이 비교
    public String solution(String str){
        String answer ="";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");
        for(String x : s){
            if(x.length() > m){
                m=x.length();
                answer= x;
            }
        }
        return answer;
    }
    //substring을 통한 split방법
    public String solution2(String str){
        String answer = "";
        int m = Integer.MIN_VALUE,pos;
        while((pos = str.indexOf(' '))!= -1){
            String temp = str.substring(0,pos); //단어 뽑아내기
            int len = temp.length();
            if(len > m){
                m= len;
                answer = temp;
            }
            str = str.substring(pos+1); //뽑아낸 단어 이후의 str로 재변경
        }
        if(str.length()>m)
            answer=str;
        return  answer;

    }
    public static void main(String[] args){
        LongestWord L = new LongestWord();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();
        System.out.println(L.solution(str));
        System.out.println(L.solution2(str));
    }
}
