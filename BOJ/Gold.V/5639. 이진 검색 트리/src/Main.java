import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true){
            String input = br.readLine();
            if(input == null || input.equals("")) break;
            int value = Integer.parseInt(input);
            root.addValue(value);
        }
        printNode(root);
    }

    private static void printNode(Node node){
        if(node == null) return;
        printNode(node.getLeft());
        printNode(node.getRight());
        System.out.println(node.getValue());
    }

    static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void addValue(int value){
            if(this.value > value){
                if(this.left == null){
                    this.left = new Node(value);
                    return;
                }
                this.left.addValue(value);
                return;
            }
            if(this.right == null){
                this.right = new Node(value);
                return;
            }
            this.right.addValue(value);
        }
    }
}