package DailyQuestions;

public class FindIfPathExistsInGraph {
    class Solution {

        private int[] parent;

        public boolean validPath(int n, int[][] edges, int source, int destination){
            parent = new int[n];
            for(int index = 0; index < n; index++) {
                parent[index] = index;
            }
            for(int[] edge : edges) {
                union(Math.min(edge[0], edge[1]), Math.max(edge[0], edge[1]));
            }
            return find(source) == find(destination);
        }

        private int find(int a) {
            if(a == parent[a]) return a;
            return parent[a] = find(parent[a]);
        }

        private void union(int a, int b) {
            a = find(a);
            b = find(b);
            if(a == b) return;

            if(a < b) {
                parent[b] = a;
                return;
            }

            parent[a] = b;
        }
    }
}
