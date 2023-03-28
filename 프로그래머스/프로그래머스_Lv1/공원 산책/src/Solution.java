class Solution {
    private int[] moveDirection;
    private int[] start;
    private int[][] parkValue;
    public int[] solution(String[] park, String[] routes) {
        parkValue = new int[park.length][park[0].length()];
        for(int x = 0; x < park.length; x++){
            for(int y = 0; y < park[x].length(); y++){
                if(park[x].charAt(y) == 'S'){
                    start = new int[]{x, y};
                    continue;
                }
                if(park[x].charAt(y) == 'X') parkValue[x][y] = 1;
            }
        }
        for(String route : routes){
            String op = route.split(" ")[0];
            int n = Integer.parseInt(route.split(" ")[1]);
            applyOp(op);
            move(n);
        }
        return start;
    }

    private void move(int n){
        if(parkValue.length <= start[0] + moveDirection[0]*n ||
                parkValue[0].length <= start[1] + moveDirection[1]*n) return;

        if(0 > start[0] + moveDirection[0]*n ||
                0 > start[1] + moveDirection[1]*n) return;

        for(int index = 1; index <=n; index++){
            if(parkValue[start[0] + moveDirection[0]*index][start[1]+ moveDirection[1]*index] == 1) return;
        }
        start = new int[]{start[0]+ moveDirection[0] * n, start[1]+ moveDirection[1] * n};
    }

    private void applyOp(String op){
        if(op.equals("E")){
            moveDirection = new int[]{0, 1};
            return;
        }
        if(op.equals("W")){
            moveDirection = new int[]{0, -1};
            return;
        }
        if(op.equals("S")){
            moveDirection = new int[]{1, 0};
            return;
        }
        moveDirection = new int[]{-1, 0};
    }
}