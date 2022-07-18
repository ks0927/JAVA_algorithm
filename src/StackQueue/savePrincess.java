package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class savePrincess {
    public int solution(int n, int k){
        Queue<Integer> queue =new LinkedList<>();
        for(int i=1;i<=n;i++)
            queue.offer(i);
        int cnt =1;
        while(queue.size()!=1){
            if(cnt==k){
                queue.remove();
                cnt=1;
            }
            Integer poll = queue.poll();
            queue.offer(poll);
/*            for(int x: queue) {
                System.out.print(x + " ");
            }
            System.out.println();*/
            cnt++;
        }
        return queue.peek();
    }

    public static void main(String[] args){
        savePrincess S = new savePrincess();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.println(S.solution(n,k));
    }
}
