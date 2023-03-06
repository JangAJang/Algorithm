import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder pre = new StringBuilder();
    private static final StringBuilder in = new StringBuilder();
    private static final StringBuilder post = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for(int index = 0; index < n; index++){
            String[] connection = br.readLine().split(" ");
            nodes[connection[0].charAt(0)-'A'] = new Node(connection[1].charAt(0), connection[2].charAt(0));
        }
        preorder(nodes, 0);
        inorder(nodes, 0);
        postorder(nodes, 0);
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }

    private static void preorder(Node[] nodes, int current){
        pre.append((char)(current+'A'));
        if(nodes[current].hasLeft()) preorder(nodes, nodes[current].getLeft());
        if(nodes[current].hasRight()) preorder(nodes, nodes[current].getRight());
    }

    private static void inorder(Node[] nodes, int current){
        if(nodes[current].hasLeft()) inorder(nodes, nodes[current].getLeft());
        in.append((char)(current+'A'));
        if(nodes[current].hasRight()) inorder(nodes, nodes[current].getRight());
    }

    private static void postorder(Node[] nodes, int current){
        if(nodes[current].hasLeft()) postorder(nodes, nodes[current].getLeft());
        if(nodes[current].hasRight()) postorder(nodes, nodes[current].getRight());
        post.append((char)(current+'A'));
    }

    static class Node{
        private int left;
        private int right;

        public Node(char left, char right) {
            this.left = left - 'A';
            this.right = right - 'A';
            if(left == '.') this.left = Integer.MAX_VALUE;
            if(right == '.') this.right = Integer.MAX_VALUE;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public boolean hasLeft(){
            return left != Integer.MAX_VALUE;
        }

        public boolean hasRight(){
            return right != Integer.MAX_VALUE;
        }
    }
}