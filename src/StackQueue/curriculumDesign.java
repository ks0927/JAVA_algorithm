package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class curriculumDesign {
    public void solution(String target, String lesson){
        Queue<Character> t_queue = new LinkedList<>();
        for(char x: target.toCharArray())
            t_queue.offer(x);
        for(char x:lesson.toCharArray()){
            if(t_queue.isEmpty()) {
                System.out.println("YES");
                break;
            }
            if(x==t_queue.peek())
                t_queue.remove();
        }
        if(!t_queue.isEmpty())
            System.out.println("NO");

    }

    public static void main(String[] args){
        curriculumDesign C = new curriculumDesign();
        Scanner kb= new Scanner(System.in);

        String target = kb.next();
        String lesson = kb.next();
        C.solution(target,lesson);

    }
}
