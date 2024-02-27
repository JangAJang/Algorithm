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
        int[] arr = new int[n];
        int count = Integer.parseInt(st.nextToken());
        for(int index = 0; index < n; index++) {
            arr[index] = Integer.parseInt(br.readLine());
        }
        Node root = new Node(arr);
        for(int index = 0; index < count; index++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] result = getMinMaxInRange(start, end, n, root);
            System.out.println(result[0] + " " +result[1]);
        }
    }

    public static int[] getMinMaxInRange(final int start, final int end, final int size, final Node root) {
        if (start < 0 || end >= size || start > end) {
            throw new IllegalArgumentException("Invalid range");
        }
        int[] result = new int[2];
        getMinMaxInRange(root, 0, size - 1, start, end, result);
        return result;
    }

    private static void getMinMaxInRange(Node node, int nodeStart, int nodeEnd, int queryStart, int queryEnd, int[] result) {
        // 현재 노드가 쿼리 범위 밖에 있는 경우
        if (nodeEnd < queryStart || nodeStart > queryEnd) {
            return;
        }
        // 현재 노드가 쿼리 범위 안에 있는 경우
        if (queryStart <= nodeStart && nodeEnd <= queryEnd) {
            result[0] = Math.min(result[0], node.getMin());
            result[1] = Math.max(result[1], node.getMax());
            return;
        }
        // 현재 노드가 쿼리 범위와 겹치는 경우
        int mid = (nodeStart + nodeEnd) / 2;
        getMinMaxInRange(node.getLeft(), nodeStart, mid, queryStart, queryEnd, result);
        getMinMaxInRange(node.getRight(), mid + 1, nodeEnd, queryStart, queryEnd, result);
    }
}

class Node {
    private int min;
    private int max;
    private Node left;
    private Node right;

    public Node(int[] arr) {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if(arr.length== 1) return;
        this.left = new Node(Arrays.copyOfRange(arr, 0, arr.length/2));
        this.right = new Node(Arrays.copyOfRange(arr, arr.length/2+1, arr.length));
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}