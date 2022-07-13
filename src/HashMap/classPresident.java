package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class classPresident {
    public char solution(int n,String str){
        char answer = ' ';
        Map<Character,Integer> vote = new HashMap<>();
        for(char x : str.toCharArray()){
            if(vote.containsKey(x)) {
                int a =vote.get(x);
                vote.put(x,++a);
            }
            else{
                vote.put(x,0);
            }
        }
        int max=0;
        for(char key : vote.keySet()){
            if(vote.get(key)>max){
                max=vote.get(key);
                answer = key;
            }
        }
        return answer;

    }

    public static void main(String[] args){

        classPresident C = new classPresident();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(C.solution(n,str));
    }
}
