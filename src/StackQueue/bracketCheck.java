package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class bracketCheck {
    public boolean solution(String str){
        Stack<Character> stack = new Stack<>();

        for(char x: str.toCharArray()){
            if(x=='(')
                stack.add(x);
            else{
                if(stack.empty())
                    return false;
                stack.pop();
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        bracketCheck B = new bracketCheck();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();

        boolean answer = B.solution(str);
        if(answer)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
