package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class ironBar {
    public int solution(String str){
        Stack<Character> stack = new Stack<>();
        int answer=0;
/*        ArrayList<Character> arr = new ArrayList<>();
       for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='(')
                arr.add(str.charAt(i));
            else{// case ')'
                if(str.charAt(i-1)==')'){
                    arr.add(str.charAt(i));
                }
                else{// case'('
                    arr.remove(i-1);
                    arr.add('L');
                }
            }
        }*/
        String replaceStr = str.replace("()","L");
        //System.out.println(replaceStr);
        for(char x: replaceStr.toCharArray()){
            if(x=='(')
                stack.add(x);
            else{ //x==L or x==)
                if(x=='L'){
                   answer+=stack.size();
                }
                if(x==')'){ //막대기의 끝부분이니까 +1 하고 pop해서 이번막대기 끝
                    answer+=1;
                    stack.pop();
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        ironBar I = new ironBar();
        Scanner kb= new Scanner(System.in);

        String str = kb.next();
        System.out.println(I.solution(str));

    }
}
