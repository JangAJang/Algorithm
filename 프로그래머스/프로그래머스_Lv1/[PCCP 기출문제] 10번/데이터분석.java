import java.util.*;

class Solution {
    int extIndex, sort_by_index;

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        init(ext, sort_by);

        ArrayList<int[]> list = new ArrayList<>();

        for(int[] arr : data)
            if(arr[extIndex] < val_ext)
                list.add(arr);

        Collections.sort(list, (o1, o2)->{
            return o1[sort_by_index] - o2[sort_by_index];
        });

        answer = new int[list.size()][];

        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);


        return answer;
    }


    void init(String ext, String sort_by){
        if(ext.equals("code")) extIndex = 0;
        if(ext.equals("date")) extIndex = 1;
        if(ext.equals("maximum")) extIndex = 2;
        if(ext.equals("remain")) extIndex = 3;

        if(sort_by.equals("code")) sort_by_index = 0;
        if(sort_by.equals("date")) sort_by_index = 1;
        if(sort_by.equals("maximum")) sort_by_index = 2;
        if(sort_by.equals("remain")) sort_by_index = 3;
    }

}