package String;

import java.util.Scanner;

public class transUpperLower {
    //Character 함수를 이용하는 경우
    public String solution(String str){
        String answer ="";

        for(char x : str.toCharArray()){
            if(Character.isLowerCase(x))
                answer +=Character.toUpperCase(x);
            else
                answer+=Character.toLowerCase(x);
        }
        return answer;
    }
    //아스키 코드를 이용하는 경우
    public String solution2(String str){
        String answer ="";

        for (char c : str.toCharArray()) {
            if(65<=c && c<=90){ //대문자면
                answer+=(char)(c+32); //32를 더해서 소문자로 만들어준다.
            }
            else{//소문자면
                answer+=(char)(c-32); //32를 빼서 대문자로 만들어준다.
            }
        }
        return answer;
    }

    public static void main(String[] args){

        transUpperLower T = new transUpperLower();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
        System.out.println(T.solution2(str));
    }
}
