import java.util.ArrayDeque;
import java.util.Queue;

class Solution {

    private boolean[][] visited;
    private int[][] positions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        Queue<Node> nodes = new ArrayDeque<>();
        nodes.add(new Node(0, 0, 1));
        while(!nodes.isEmpty()){
            Node currentNode = nodes.remove();
            if(visited.length-1 == currentNode.x && visited[0].length-1 == currentNode.y) return currentNode.distance;
            addNextNodes(currentNode, maps, nodes);
        }
        return -1;
    }

    private void addNextNodes(Node currentNode, int[][] maps, Queue<Node> nodes){
        for(int i=0; i< 4;i++){
            int sumX = currentNode.x + positions[i][0];
            int sumY = currentNode.y + positions[i][1];
            if(sumX < 0 || sumY < 0  || maps[0].length-1 < sumY || maps.length-1 < sumX) continue;
            if(maps[sumX][sumY] == 1 && !visited[sumX][sumY]){
                visited[sumX][sumY] = true;
                nodes.add(new Node(sumX,sumY,currentNode.distance+1));
            }
        }
    }

    private class Node{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}