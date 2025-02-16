import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        String value;
        Node left;
        Node right;

        public Node(String value) {
            this.value = value;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] map = new Node[26];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String cur = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            int curIndex = cur.charAt(0) - 'A';
            int leftIndex = (left.equals(".")) ? -1 : left.charAt(0) - 'A';
            int rightIndex = (right.equals(".")) ? -1 : right.charAt(0) - 'A';

            Node parents;

            if (map[curIndex] == null) {
                parents = new Node(cur);
                map[curIndex] = parents;
            }
            parents = map[curIndex];

            if (leftIndex != -1 && map[leftIndex] == null) {
                Node leftChild = new Node(left);
                map[leftIndex] = leftChild;
                parents.left = map[leftIndex];
            } else if (leftIndex == -1) {
                parents.left = new Node(".");
            }

            if (rightIndex != -1 && map[rightIndex] == null) {
                Node rightChild = new Node(right);
                map[rightIndex] = rightChild;
                parents.right = map[rightIndex];
            } else if (rightIndex == -1) {
                parents.right = new Node(".");
            }

        }
        preOrder(map[0]);
        sb.append("\n");
        innerOrder(map[0]);
        sb.append("\n");
        postOrder(map[0]);

        System.out.print(sb);
    }

    static private void preOrder(Node cur) {
        if (cur.value.equals(".")) {
            return;
        }

        sb.append(cur.value);
        preOrder(cur.left);
        preOrder(cur.right);
    }

    static private void innerOrder(Node cur) {
        if (cur.value.equals(".")) {
            return;
        }

        innerOrder(cur.left);
        sb.append(cur.value);
        innerOrder(cur.right);
    }

    static private void postOrder(Node cur) {
        if (cur.value.equals(".")) {
            return;
        }

        postOrder(cur.left);
        postOrder(cur.right);
        sb.append(cur.value);

    }
}


