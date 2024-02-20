import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int taskCount = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        long[] arr = new long [n];
        for(int index = 0; index < n; index++) {
            arr[index] = Long.parseLong(br.readLine());
        }
        Node node = Node.createSegmentTree(arr, 1, n);
        node.printNodeInfo();
        while(taskCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            int task = Integer.parseInt(st.nextToken());
            int firstInput = Integer.parseInt(st.nextToken());
            if(task == 1) {
                long secondInput = Long.parseLong(st.nextToken());
                node.changeSum(firstInput, secondInput - arr[firstInput-1]);
                node.printNodeInfo();
                continue;
            }
            int secondInput = Integer.parseInt(st.nextToken());
            System.out.println(node.getRangeSum(firstInput, secondInput));
        }
    }
}

class Node {
    private long value;
    private int start;
    private int end;
    private Node leftChild;
    private Node rightChild;

    public Node(long value, int start, int end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }

    public boolean containsIndex(final int index) {
        return this.start <= index && this.end >= index;
    }

    public static Node createSegmentTree(final long[] ingredients, final int start, final int end) {
        if(ingredients.length == 1) {
            return new Node((ingredients[0]), start, end);
        }

        Node node = new Node(Arrays.stream(ingredients).sum(), start, end);
        node.createChild(ingredients, start, end);
        return node;
    }

    public void createChild(final long[] ingredients, final int start, final int end) {
        int mid = (end+start-1)/2;
        long[] leftIngredients = Arrays.copyOfRange(ingredients, 0, ingredients.length/2);
        long[] rightIngredients = Arrays.copyOfRange(ingredients, ingredients.length/2, ingredients.length);
        this.leftChild = Node.createSegmentTree(leftIngredients, start, mid);
        this.rightChild = Node.createSegmentTree(rightIngredients, mid+1, end);
    }

    public void printNodeInfo() {
        if(leftChild != null) leftChild.printNodeInfo();
        if(rightChild != null) rightChild.printNodeInfo();
    }

    public long getRangeSum(final int start, final int end) {
        if(leftChild != null && leftChild.containsIndex(start) && leftChild.containsIndex(end))
            return leftChild.getRangeSum(start, end);
        if(rightChild != null && rightChild.containsIndex(start) && rightChild.containsIndex(end))
            return rightChild.getRangeSum(start, end);

        if(start >= end) return this.value;

        long leftSum = leftChild != null ? leftChild.getRangeSum(start, leftChild.end) : 0;
        long rightSum = rightChild != null ? rightChild.getRangeSum(rightChild.start, end) : 0;
        return leftSum + rightSum;
    }

    public void changeSum(int index, long value) {
        this.value += value;
        if(leftChild != null && leftChild.containsIndex(index)) leftChild.changeSum(index, value);
        if(rightChild != null && rightChild.containsIndex(index)) rightChild.changeSum(index, value);
    }
}