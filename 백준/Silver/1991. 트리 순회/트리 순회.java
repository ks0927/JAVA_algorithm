import java.io.*;
import java.util.*;

public class Main {
    static String result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        // 노드들을 알파벳 A B ... 순서로 담아놓는 배열
        Node[] tree = new Node[26];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            char current = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if (tree[current - 'A'] == null) {
                Node node = new Node(current);
                tree[current - 'A'] = node;
            }

            if (leftChild != '.') {
                Node leftNode = new Node((leftChild));
                tree[leftChild - 'A'] = leftNode;
                tree[current - 'A'].left = leftNode;
            }

            if (rightChild != '.') {
                Node rightNode = new Node((rightChild));
                tree[rightChild - 'A'] = rightNode;
                tree[current - 'A'].right = rightNode;
            }
        }

        result = "";
        preorder(tree[0]);
        sb.append(result).append("\n");

        result = "";
        inorder(tree[0]);
        sb.append(result).append("\n");

        result = "";
        postorder(tree[0]);
        sb.append(result).append("\n");

        System.out.print(sb);

    }

    // 전위순회 (루트 , 왼쪽자식 , 오른쪽 자식)
    public static void preorder(Node head) {
        if (head == null) return;
        result += (String.valueOf(head.value));
        preorder(head.left);
        preorder(head.right);
    }

    // 중위순회 (왼쪽자식 , 루트 , 오른쪽 자식)
    public static void inorder(Node head) {
        if (head == null) return;
        inorder(head.left);
        result += (String.valueOf(head.value));
        inorder(head.right);
    }

    // 후위순회 (왼쪽자식 , 오른쪽자식 , 루트)
    public static void postorder(Node head) {
        if (head == null) return;
        postorder(head.left);
        postorder(head.right);
        result += (String.valueOf(head.value));
    }

    static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
