package String;

import java.util.Scanner;

public class wordDistance {

    public int[] solution(String str, char c){
        int[] answer = new int[str.length()];
        int d = 1000;
        for(int i= 0 ; i<str.length(); i++){
            if(str.charAt(i)==c){
                d=0;
                answer[i]=d;
            }
            else{
                d++;
                answer[i]=d;
            }
        }//여기까지 왼쪽->오른쪽 한번
        d=1000;
         for(int i= str.length()-1; i>=0; i--){
             if(str.charAt(i)==c)
                 d=0;
             else{
                 d++;
                 answer[i] = Math.min(answer[i],d); //Math.min으로 작은값 리턴
             }
         }

        return answer;
    }

    public static void main(String[] args){
        wordDistance W = new wordDistance();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        char c = kb.next().charAt(0);

        for(int x : W.solution(str,c)){
            System.out.print(x+" ");
        }
    }
}
