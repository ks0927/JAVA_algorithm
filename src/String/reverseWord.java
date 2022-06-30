package String;

import java.util.ArrayList;
import java.util.Scanner;

public class reverseWord {

    public ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
/*       StringBuilder의 reverse를 이용한 방법, 간단하다. StringBuilder를 사용해서 객체가 여러개 생기는걸 방지한다.
            for(String x: str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        */
        for(String x: str){
            char[] s = x.toCharArray();
            int lt =0, rt= x.length()-1;
            while(lt<rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }
        return answer;

    }

    public static void main(String[] args){
        reverseWord R = new reverseWord();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n ; i++){
            str[i] = kb.next();
        }
        for(String x: R.solution(n,str))
            System.out.println(x);
    }
}
