class Solution {
    public int[] solution(int brown, int yellow) {
        return (getHeightAndLength(getWidthAndHeightByBrown(brown), yellow));
    }

    private int getWidthAndHeightByBrown(int brown){
        return (brown-4) / 2;
    }

    private int[] getHeightAndLength(int halfBrownSurround, int yellow){
        for(int width = halfBrownSurround/2; width >=1; width--){
            if(width * (halfBrownSurround - width) == yellow) return makeCarpet(width, halfBrownSurround);
        }
        return new int[]{};
    }

    private int[] makeCarpet(int width, int halfOfSurround){
        int height = halfOfSurround - width;
        if(height > width) return new int[]{height+2, width+2};
        return new int[]{width+2, height+2};
    }
}