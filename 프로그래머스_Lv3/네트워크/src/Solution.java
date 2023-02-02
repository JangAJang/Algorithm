import java.util.*;

class Solution {

    private static class Node{

        private final Set<Integer> nextNodes;

        public Node() {
            nextNodes = new HashSet<>();
        }

        public void addNextNode(int next){
            nextNodes.add(next);
        }

        public Set<Integer> getNextNodes() {
            return nextNodes;
        }
    }

    private boolean[] visited;
    private Node[] nodes;

    public int solution(int n, int[][] computers) {
        nodes = new Node[n];
        for(int index = 0; index < n; index++){
            nodes[index] = new Node();
        }
        visited = new boolean[n];
        for (int[] computer : computers) {
            addData(computer);
        }
        int result = 0;
        for(int index = 0; index < n; index++){
            if(visited[index]) continue;
            dfs(index);
            result++;
        }
        return result;
    }

    private void dfs(int index){
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.add(nodes[index]);
        visited[index] = true;
        while(!nodeStack.isEmpty()){
            Node currentNode = nodeStack.pop();
            Set<Integer> nextIndex = currentNode.getNextNodes();
            for (Integer nextEach : nextIndex) {
                if(!visited[nextEach]) nodeStack.add(nodes[nextEach]);
                visited[nextEach] = true;
            }
        }
    }

    private void addData(int[] computer){
        List<Integer> indexes = new ArrayList<>();
        for(int index = 0; index < computer.length; index++){
            if(computer[index] == 1) indexes.add(index);
        }
        for(int index = 0; index < indexes.size(); index++){
            for(int nextNodeIndex : indexes){
                if(indexes.get(index) == nextNodeIndex) continue;
                nodes[indexes.get(index)].addNextNode(nextNodeIndex);
            }
        }
    }
}