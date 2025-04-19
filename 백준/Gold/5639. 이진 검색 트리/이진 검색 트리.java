import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    static ArrayList<Integer> map;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new ArrayList<>();

        while(true) {
            String str = br.readLine();
            if(str == null || str.equals("")) {
                break;
            }

            map.add(Integer.parseInt(str));
        }

        Node root = makeTree(0, map.size()-1);

        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb);
    }

    private static void postOrder(Node node) {
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        sb.append(node.value).append("\n");
    }

    private static Node makeTree(int start, int end) {

        if(start > end)
            return null;

        Node now = new Node(map.get(start));

        int index;
        for(index = start + 1; index <= end ; index++) {
            if(map.get(index) > now.value) {
                break;
            }
        }

        now.left = makeTree(start+1, index - 1);
        now.right = makeTree(index, end);

        return now;
    }
}
