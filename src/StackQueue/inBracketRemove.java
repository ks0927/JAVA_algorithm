package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class inBracketRemove {
    public String solution(String str){
        Stack<Character> stack = new Stack<>();

        for(char x: str.toCharArray()){
            stack.push(x);
            if(x==')'){
                while(stack.peek()!='('){
                    stack.pop();
                }
                stack.pop();
            }
        }
        String answer="";
        for(char x: stack)
            answer+=x;

        return answer;
    }

    public static void main(String[] args){
        inBracketRemove I = new inBracketRemove();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        System.out.println(I.solution(str));

    }
}
