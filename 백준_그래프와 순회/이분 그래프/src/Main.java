import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;

    public static void main(String[] args)throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int K  = Integer.parseInt(br.readLine());
        while(K-->0){
            CheckBipartite();
        }
    }

    public static void CheckBipartite()throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[V+1];
        for(int i=1; i<=V; i++){
            nodes[i] = new Node();
        }
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes[start].addLeaf(end);
            nodes[end].addLeaf(start);
            if(nodes[start].isRed()){
                nodes[end].setBlack();
            }
            else{
                nodes[end].setRed();
            }
        }
        for(int i=1; i<=V; i++){
            for(int j=0; j<nodes[i].leaves.size(); j++){
                int k = nodes[i].leaves.get(j);
                if(nodes[i].red_black == nodes[k].red_black){
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");
    }

    public static class Node{

        Red_Black red_black;

        List<Integer> leaves = new LinkedList<>();

        public void addLeaf(int val){
            leaves.add(val);
        }

        public boolean isEmpty(){
            if (leaves.isEmpty()) return true;
            else return false;
        }

        public boolean isRed(){
            if(red_black==Red_Black.RED) return true;
            else return false;
        }

        public void setBlack(){
            red_black = Red_Black.BLACK;
        }

        public void setRed(){
            red_black = Red_Black.RED;
        }
    }

    public enum Red_Black{
        RED, BLACK;
    }
}
