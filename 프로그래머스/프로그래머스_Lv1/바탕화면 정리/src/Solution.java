class Solution {
    public int[] solution(String[] wallpaper) {
        int startX = Integer.MAX_VALUE;
        int endX = Integer.MIN_VALUE;
        int startY = Integer.MAX_VALUE;
        int endY = Integer.MIN_VALUE;
        for(int x = 0; x < wallpaper.length; x++){
            for(int y = 0; y < wallpaper[x].length(); y++){
                if(wallpaper[x].charAt(y) == '#'){
                    startX = Math.min(startX, x);
                    endX = Math.max(endX, x);
                    startY = Math.min(startY, y);
                    endY = Math.max(endY, y);
                }
            }
        }
        return new int[]{startX, startY, endX+1, endY+1};
    }
}