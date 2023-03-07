public class LocationOfCharacter {
    // lv0. 캐릭터의 좌표
    class Solution {

        private int limitX;
        private int limitY;

        public int[] solution(String[] keyinput, int[] board) {
            limitX = board[0]/2;
            limitY = board[1]/2;
            int[] location = new int[]{0, 0};
            for(String commandEach : keyinput){
                moveLocation(location, commandEach);
            }
            return location;
        }

        private void moveLocation(int[] location, String commandEach){
            if(commandEach.equals("left")) location[0]--;
            if(commandEach.equals("right")) location[0]++;
            if(commandEach.equals("up")) location[1]++;
            if(commandEach.equals("down")) location[1]--;
            if( Math.abs(location[0]) > limitX) location[0] = location[0] / Math.abs(location[0]) * limitX;
            if( Math.abs(location[1]) > limitY) location[1] = location[1] / Math.abs(location[1]) * limitY;
        }
    }
}
