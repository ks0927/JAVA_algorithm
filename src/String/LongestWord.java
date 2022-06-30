package String;

import java.util.Scanner;

public class LongestWord {
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

    public static void main(String[] args){
        LongestWord L = new LongestWord();
        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();
        System.out.println(L.solution(str));
    }
}
