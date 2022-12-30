import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String dirs) {
        List<Movement> movements = new ArrayList<>();
        Point lastPoint = new Point(0, 0);
        for(int index = 0; index < dirs.length(); index++){
            Point newPoint = lastPoint.move(dirs.charAt(index));
            movements.add(new Movement(lastPoint, newPoint));
            lastPoint = newPoint;
        }
        return countDifferentMovement(movements);
    }

    private int countDifferentMovement(List<Movement> movements){
        int count = 0;
        for(int index = 0; index < movements.size(); index++){
            if(isDifferentOne(index, movements)) count++;
        }
        return count;
    }

    private boolean isDifferentOne(int index, List<Movement> movements){
        Movement movement = movements.get(index);
        for(int checker = index+1; checker < movements.size(); checker++){
            if(movement.isSame(movements.get(checker))) return false;
        }
        return true;
    }

    private class Point{

        private static final int MAX_VALUE = 5;
        private static final int MIN_VALUE = -5;

        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Point move(char c){
            if(c=='U') return new Point(x, Math.min(MAX_VALUE, y+1));
            if(c=='D') return new Point(x, Math.max(MIN_VALUE, y-1));
            if(c=='R') return new Point(Math.min(MAX_VALUE, x+1), y);
            return new Point(Math.max(MIN_VALUE, x-1), y);
        }
    }

    private class Movement{
        Point from;
        Point to;

        public Movement(Point from, Point to){
            this.from = from;
            this.to = to;
        }

        public boolean isSame(Movement movement){
            return (this.from.equals(movement.getFrom()) && this.to.equals(movement.getTo()))
                    || (this.from.equals(movement.getTo()) && this.to.equals(movement.getFrom()));
        }

        public Point getFrom() {
            return from;
        }

        public Point getTo() {
            return to;
        }
    }
}