package DailyQuestions;

import java.util.*;

public class RemoveSubFoldersFromFileSystem {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.comparingInt(String::length));
        final Node root = new Node("");
        for(String each : folder) {
            root.addRoute(each);
        }

        for(String each : folder) {
            root.deleteSubroute(each);
        }

        return root.getRoutes();
    }


    class Node {
        private final String val;
        private final Map<String, Node> next;

        public Node(final String val) {
            this.val = val;
            this.next = new HashMap<>();
        }

        public void addNext(final String val) {
            this.next.put(val, new Node(val));
        }

        public void addRoute(final String val) {
            final String[] split = val.split("/");
            addRoute(split, 1);
        }

        public void addRoute(final String[] split, final int index) {
            if(index == split.length) return;
            if(!next.containsKey(split[index])) {
                next.put(split[index], new Node(split[index]));
            }
            next.get(split[index]).addRoute(split, index+1);
        }

        public void deleteSubroute(final String val) {
            final String[] split = val.split("/");
            deleteSubroute(split, 1);
        }

        public void deleteSubroute(final String[] split, final int index) {
            if(split.length == index) {
                next.clear();
                return;
            }

            if(next.containsKey(split[index])) {
                next.get(split[index]).deleteSubroute(split, index+1);
            }
        }

        public List<String> getRoutes() {
            if(next.isEmpty()) {
                return List.of(val);
            }

            return next.keySet()
                .stream()
                .map(key -> next.get(key).getRoutes())
                .flatMap(List::stream)
                .map(route -> "%s/%s".formatted(val, route))
                .toList();
        }
    }
}
