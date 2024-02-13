import java.util.*;
import java.util.stream.IntStream;

class Solution {

    private final HashMap<Integer, List<Integer>> points = new HashMap<>();
    private final List<Integer> yList = new ArrayList<>();

    public String[] solution(int[][] line) {
        makePoints(line);
        Collections.sort(yList);
        int startX = Integer.MAX_VALUE;
        int startY = yList.get(0);
        int endX = Integer.MIN_VALUE;
        int endY = yList.get(yList.size()-1);
        for(int x : points.keySet()){
            startX = Math.min(x, startX);
            endX = Math.max(x, endX);
        }
        String[] answer = new String[endY-startY+1];
        for(int y = endY; y >=startY; y--){
            StringBuilder sb = new StringBuilder();
            for(int x = startX; x <= endX; x++){
                if(points.containsKey(x) && points.get(x).contains(y)){
                    sb.append("*");
                    continue;
                }
                sb.append(".");
            }
            answer[endY - y] = sb.toString();
        }
        return answer;
    }

    private void makePoints(int[][] line){
        for(int x = 0; x < line.length-1; x++){
            for(int y = x+1; y < line.length; y++){
                addPoint(line[x], line[y]);
            }
        }
    }

    private void addPoint(int[] x, int[] y){
        int divider = x[0]*y[1] - x[1]*y[0];
        if(divider == 0) return;
        long X = (long) x[1] *y[2] - (long) x[2] *y[1];
        long Y = (long) x[2] *y[0] - (long) x[0] *y[2];
        double pointX = (double) X / divider;
        double pointY = (double) Y / divider;
        if(pointX != (int)pointX || pointY != (int)pointY) return;
        System.out.println(pointX + " , " + pointY);
        putPoint((int)pointX, (int)pointY);
        yList.add((int)pointY);
    }

    private void putPoint(int x, int y){
        if(points.containsKey(x)){
            points.get(x).add(y);
            return;
        }
        points.put(x, new ArrayList<>());
        points.get(x).add(y);
    }
}