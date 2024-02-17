import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Node root = new Node("");
        int count = Integer.parseInt(br.readLine());
        while(count-- > 0) {
            String[] inputs = br.readLine().split(" ");
            Queue<String> route = readRoute(inputs);
            root.addChild(route);
        }
        root.showMap("").forEach(System.out::println);
    }

    public static Queue<String> readRoute(final String[] inputs) {
        return new ArrayDeque<>(Arrays.asList(inputs).subList(1, inputs.length));
    }
}

class Node {

    private final TreeSet<Node> children;
    private final String name;

    public Node(final String name) {
        this.name = name;
        this.children = new TreeSet<>((Comparator.comparing(Node::getName)));
    }

    public String getName() {
        return name;
    }

    public boolean hasName(final String name) {
        return this.name.equals(name);
    }

    public void addChild(final Queue<String> route) {
        if(route.isEmpty()) return;
        String childName = route.poll();
        this.children.add(new Node(childName));

        for(Node child : children) {
            if(child.hasName(childName)) {
                child.addChild(route);
                return;
            }
        }
    }

    public List<String> showMap(final String prefix) {
        if(this.children.isEmpty()) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(Node child : children) {
            result.add(prefix + child.getName());
            result.addAll(child.showMap(prefix + "--"));
        }
        return result;
    }
}