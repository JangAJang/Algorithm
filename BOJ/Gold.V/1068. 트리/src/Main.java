import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

// Gold5. 1068 트리
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int rootIndex = 0;
        Node[] nodes = new Node[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int index = 0; index < n; index++) {
            nodes[index] = new Node(index);
        }

        for(int index = 0; index < n; index++) {
            int parentIndex = Integer.parseInt(st.nextToken());
            if(parentIndex == -1) {
                rootIndex = index;
                continue;
            }
            nodes[parentIndex].addChild(nodes[index]);
        }

        int deleteIndex = Integer.parseInt(br.readLine());
        if(deleteIndex != rootIndex) {
            Node root = nodes[rootIndex];
            root.deleteNodeAt(deleteIndex);
            System.out.println(root.countLeafNode());
            return;
        }
        System.out.println(0);
    }
}

class Node {

    private final List<Node> children;
    private final int index;

    public Node(final int index) {
        this.children = new ArrayList<>();
        this.index = index;
    }

    public void addChild(final Node node) {
        this.children.add(node);
    }

    public boolean isLeafNode() {
        return this.children.isEmpty();
    }

    public void deleteNodeAt(final int index) {
        if(isLeafNode()) return;
        for(Node child : children) {
            if(child.index == index) {
                children.remove(child);
                return;
            }
        }
        children.forEach(child -> child.deleteNodeAt(index));
    }

    public int countLeafNode() {
        if(isLeafNode()) return 1;
        int count = 0;
        for(Node child : children) {
            count += child.countLeafNode();
        }

        return count;
    }
}