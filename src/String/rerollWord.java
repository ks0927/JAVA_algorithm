package String;

import java.util.Scanner;

public class rerollWord {
    public String solution(String str){
        str =str.toUpperCase();
        int len = str.length();
        for(int i=0; i<len/2 ; i++){
            if(str.charAt(i)!= str.charAt(len-1-i)){
                return "NO";
            }
        }
        return "Yes";
    }

    public static void main(String[] args){
        rerollWord R = new rerollWord();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.println(R.solution(str));
    }
}
