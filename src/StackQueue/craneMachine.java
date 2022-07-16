package StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class craneMachine {
    public int solution(int n, int[][] arr,int m, int[] move){
        int answer =0;
        int cnt=0;
        int pick=0;
        Stack<Integer> stack= new Stack<>();
        while(cnt<m){
            for(int i=0;i<n;i++){
                if(arr[i][move[cnt]-1]==0)
                    continue;
                else{
                    pick=arr[i][move[cnt]-1];
                    arr[i][move[cnt]-1]=0;
                    break;
                }
            }
            if(stack.empty()){
                stack.push(pick);
                pick=0;
            }

            if(stack.peek()==pick){
                stack.pop();
                answer+=2;
                pick=0;
            }
            if(pick>0){
                stack.push(pick);
                pick=0;
            }
            cnt++;
        }
        return answer;

    }

    public static void main(String[] args){
        craneMachine C = new craneMachine();
        Scanner kb= new Scanner(System.in);

        int n = kb.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                arr[i][j]= kb.nextInt();
        }
        int m = kb.nextInt();
        int[] move = new int[m];
        for(int i=0;i<m;i++)
            move[i]= kb.nextInt();

        System.out.println(C.solution(n,arr,m,move));
    }
}
