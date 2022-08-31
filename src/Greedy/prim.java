package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class prim_edge implements Comparable<prim_edge>{
    public int vex;
    public int cost;
    prim_edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(prim_edge ob){
        return this.cost-ob.cost;
    }
}
public class prim {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        ArrayList<ArrayList<prim_edge>> graph = new ArrayList<ArrayList<prim_edge>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<prim_edge>());
        }
        int[] ch=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            int c=kb.nextInt();
            graph.get(a).add(new prim_edge(b, c));
            graph.get(b).add(new prim_edge(a, c));
        }
        int answer=0;
        PriorityQueue<prim_edge> pQ = new PriorityQueue<>();
        pQ.offer(new prim_edge(1, 0));
        while(!pQ.isEmpty()){
            prim_edge tmp=pQ.poll();
            int ev=tmp.vex;
            if(ch[ev]==0){
                ch[ev]=1;
                answer+=tmp.cost;
                for(prim_edge ob : graph.get(ev)){
                    if(ch[ob.vex]==0) pQ.offer(new prim_edge(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }

}
