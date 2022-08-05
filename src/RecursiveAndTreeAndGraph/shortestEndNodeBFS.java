package RecursiveAndTreeAndGraph;

import java.util.LinkedList;
import java.util.Queue;

public class shortestEndNodeBFS {
    Node root;

    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        int min = Integer.MAX_VALUE;
        while(!Q.isEmpty()){
            int len = Q.size();
            for (int i=0; i<len;i++) {
                Node poll = Q.poll();
                System.out.println("L = " + L+" data: "+poll.data);
                if(poll.lt!=null)
                    Q.offer(poll.lt);
                if(poll.rt!=null)
                    Q.offer(poll.rt);
                if(poll.lt==null && poll.rt==null && min>L) {
                    min =L;
                    System.out.println("now min L = " + min);
                }
            }
            L++;
        }
        System.out.println("min = " + min);
    }

    public static void main(String[] args) {
        shortestEndNodeBFS tree = new shortestEndNodeBFS();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.lt.lt.lt=new Node(6);
        tree.root.lt.lt.rt=new Node(7);
        tree.BFS(tree.root);
    }
}
