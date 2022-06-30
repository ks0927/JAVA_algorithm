package String;

import java.util.Scanner;

public class findChar {
    public int solution(String str, char c){
        int answer =  0;
        str = str.toUpperCase();
        c = Character.toUpperCase(c);

        for(char x : str.toCharArray()){
            if(x==c) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        findChar F = new findChar();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.println(F.solution(str,c));
    }

}

