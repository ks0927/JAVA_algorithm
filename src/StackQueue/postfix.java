package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class postfix {
    public int solution(String str){
        Stack<Integer> stack = new Stack<>();

        for(char x: str.toCharArray()){
            if(Character.isDigit(x)){
                stack.push(Integer.parseInt(String.valueOf(x)));
                //stack.push(Character.getNumericValue(x));
                //stack.push(x-48);
            }
            else if(x=='+'){
                int n1= stack.pop();
                int n2= stack.pop();
                stack.push(n2+n1);
            }
            else if(x=='-'){
                int n1= stack.pop();
                int n2= stack.pop();
                stack.push(n2-n1);
            }
            else if(x=='*'){
                int n1= stack.pop();
                int n2= stack.pop();
                stack.push(n2*n1);
            }
            else if(x=='/'){
                int n1= stack.pop();
                int n2= stack.pop();
                stack.push(n2/n1);
            }
        }
        return stack.pop();

    }

    public static void main(String[] args){
        postfix P = new postfix();
        Scanner kb= new Scanner(System.in);
        String str = kb.next();

        System.out.println(P.solution(str));
    }
}
