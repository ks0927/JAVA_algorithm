package Greedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int vertex;
    int value;

    public Node(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }
}
public class dijkstra {
    static ArrayList<ArrayList<Node>> graph;  //인접리스트로 담아두기
    static int[] shortPath;      //가장 빠른거리

    public void solution(int start){
        Queue<Integer> queue =new LinkedList<>();  //큐를 통해서 현재 vertex에서 가까운 vertex를 관리한다.
        shortPath[start] =0;       //시작 한곳은 0으로 초기화
        queue.offer(start);         //시작값을 넣으면서 시작

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            ArrayList<Node> nodes = graph.get(poll);
            for (Node node : nodes) {
                int vertex = node.vertex;
                int value = node.value;
                if (shortPath[vertex] >value+shortPath[poll]) {  //만약 현재 최소거리가 이전vertex(poll)의 값과 현재 값을 더한값보다 작으면
                    shortPath[vertex] = value+shortPath[poll];   //초기화 해준다.
                    queue.offer(vertex);
                }
            }
        }
    }

    public static void main(String[] args) {
        dijkstra D = new dijkstra();
        Scanner kb =new Scanner(System.in);

        int n  = kb.nextInt(); // vertex 수
        int m  = kb.nextInt(); // edge 수

        shortPath =new int[n+1];
        for (int i = 0; i < shortPath.length; i++) {
            shortPath[i] = Integer.MAX_VALUE;//이렇게 미리 최대값으로 채워넣을수도 있지만..
        }
        //Arrays.fill(shortPath,Integer.MAX_VALUE); 이렇게 한번에 초기화 가능함...
        graph= new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < m; i++) {
            int index = kb.nextInt();
            int tmp_vertex = kb.nextInt();
            int tmp_value = kb.nextInt();
            graph.get(index).add(new Node(tmp_vertex,tmp_value));
        }

        D.solution(1);

        for (int i = 0; i < shortPath.length; i++) {
            if(i==0)
                continue;
            if(shortPath[i]!=Integer.MAX_VALUE)
                System.out.println(i+" : " +shortPath[i]);
            else
                System.out.println(i+" : impossible" );
        }

    }
}
