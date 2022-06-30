package String;

import java.util.Scanner;

public class repeatedWordRemove {

    public String solution(String str){
        String answer ="";

        //charAt은 현 인덱스의 알파벳을 보여주며 indexOf(charAt())을 통해 현 알파벳이 최초로 발견된 index를 알게됩니다
        //이걸로 현 index와 현 알파벳이 최초로 발견된 index가 같을때 answer에 추가하는 방식으로 중복 문자를 추가하지 않습니다.
        for(int i = 0; i< str.length(); i++){
            if(str.indexOf(str.charAt(i))==i){
                answer+=str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        repeatedWordRemove R  = new repeatedWordRemove();
        Scanner kb = new Scanner(System.in);
        String str  = kb.next();
        System.out.println(R.solution(str));
    }
}
