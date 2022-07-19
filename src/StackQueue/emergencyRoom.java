package StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id= id;
        this.priority= priority;
    }
}

public class emergencyRoom {

    public int solution(int n, int m, int[] arr){
        Queue<Person> queue = new LinkedList<>();
        int answer=0;
        for(int i=0; i<n;i++){
            queue.offer(new Person(i,arr[i]));
        }

        while(!queue.isEmpty()){
            Person poll = queue.poll();
            for(Person x: queue){
                if(x.priority>poll.priority){
                    queue.offer(poll);
                    poll=null;
                    break;
                }
            }
            if(poll!=null){
                answer++;
                if(poll.id==m)
                    return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        emergencyRoom E = new emergencyRoom();
        Scanner kb= new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i]= kb.nextInt();

        System.out.println(E.solution(n,m,arr));
    }
}
