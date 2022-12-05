import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {

    Printer printer;

    public int solution(int[] priorities, int location) {
        initializePrinter(priorities);
        return getCountForLocation(location);
    }

    private int getCountForLocation(int location){
        return printer.getTurnOfLocation(location);
    }

    private void initializePrinter(int[] priorities){
        printer = new Printer(priorities);
    }
}

class Printer{
    private final Deque<Paper> printer = new ArrayDeque<>();

    public Printer(int[] priorities){
        for(int location = 0; location < priorities.length; location++){
            printer.addLast(new Paper(location, priorities[location]));
        }
    }

    public int getTurnOfLocation(int location){
        int count = 1;
        while(true){
            if(isFirstBiggest() && isFirstRequired(location)) return count;
            if(isFirstBiggest()) {
                System.out.println(printer.getFirst().getPriority());
                removeFirst();
                count++;
                continue;
            }
            movePaper();
        }
    }

    private void removeFirst(){
        printer.pollFirst();
    }

    private void movePaper(){
        printer.addLast(printer.pollFirst());
    }

    public boolean isFirstRequired(int location){
        return printer.getFirst().getLocation() == location;
    }

    public boolean isFirstBiggest(){
        return printer.getFirst().getPriority() == getBiggestPriorities();
    }

    private int getBiggestPriorities(){
        return printer.stream().mapToInt(Paper::getPriority).max().orElse(0);
    }
}

class Paper{
    private final int location;
    private final int priority;

    public Paper(int location, int priority){
        this.location = location;
        this.priority = priority;
    }

    public int getLocation() {
        return location;
    }

    public int getPriority() {
        return priority;
    }
}