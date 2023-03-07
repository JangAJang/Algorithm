class Solution {

    private class Position{
        int[] location;
        int distance;

        public Position(int[] location, int distance){
            this.location = location;
            this.distance = distance;
        }

        public void setDistance(int x){
            distance = Math.abs(location[0] - x/3) + Math.abs(location[1] - x%3);
        }

        public int getDistance(){
            return distance;
        }

        public void setLocation(int[] x){
            location = x;
        }
    }

    Position left;
    Position right;

    public String solution(int[] numbers, String hand) {
        left = new Position(new int[]{3, 0}, 0);
        right = new Position(new int[]{3, 2}, 0);
        String answer = "";
        for(int i=0; i<numbers.length; i++){
            answer = answer.concat(getNextFinger(numbers[i], hand));
        }
        return answer;
    }

    private String getNextFinger(int x, String hand){
        if(x == 0) x = 11;
        if(x%3 == 1) return setL(x-1);
        if(x%3 == 0) return setR(x-1);
        return findFromMiddleLine(x-1, hand);
    }

    private String findFromMiddleLine(int x, String hand){
        left.setDistance(x);
        right.setDistance(x);
        if(left.getDistance() == right.getDistance()) return getFromSameDist(x, hand);
        return getFromDifferentDist(x);
    }

    private String getFromSameDist(int x, String hand){
        if(hand.equals("right")) return setR(x);
        return setL(x);
    }

    private String getFromDifferentDist(int x){
        if(left.getDistance() < right.getDistance()) return setL(x);
        return setR(x);
    }

    private String setR(int x){
        right.setLocation(new int[]{x/3, x%3});
        return "R";
    }

    private String setL(int x){
        left.setLocation(new int[]{x/3, x%3});
        return "L";
    }

}