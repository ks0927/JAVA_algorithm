package RecursiveAndTreeAndGraph;
/*class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}*/
public class shortestEndNodeDFS {
    Node root;
    static int min = Integer.MAX_VALUE;
    public void DFS(Node root,int egde){

        if(root.lt==null && root.rt==null){
            System.out.println("root:"+root.data+ "edge: "+egde);
            if(min>egde)
                min= egde;
            return;
        }
        else{
            DFS(root.lt,egde+1);
            DFS(root.rt,egde+1);
        }
    }

    public static void main(String[] args) {
        int egde = 0;
        shortestEndNodeDFS tree=new shortestEndNodeDFS();
        tree.root=new Node(1);
        tree.root.lt=new Node(2);
        tree.root.rt=new Node(3);
        tree.root.lt.lt=new Node(4);
        tree.root.lt.rt=new Node(5);
        tree.root.lt.lt.lt=new Node(6);
        tree.root.lt.lt.rt=new Node(7);
        tree.DFS(tree.root,egde);
        System.out.println("min = " + min);
    }
}
