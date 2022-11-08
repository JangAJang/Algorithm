import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {

    HashMap<String, Set<String>> alertingNames = new HashMap<>();
    HashMap<String, Integer> alertedCount = new HashMap<>();
    HashMap<String, Integer> alertScore = new HashMap<>();

    public int[] solution(String[] id_list, String[] report, int k) {
        setMap(id_list);
        analyzeReports(report);
        deleteCountByK(k);
        setUpScore(id_list);
        return getValueByIdList(id_list);
    }

    private int[] getValueByIdList(String[] id_list){
        int[] score = new int[id_list.length];
        for(int i=0; i< score.length; i++){
            score[i] = alertScore.get(id_list[i]);
        }
        return score;
    }

    private void setMap(String[] id_list){
        for(String id : id_list){
            initializeIdOnMap(id);
        }
    }

    private void initializeIdOnMap(String id){
        alertingNames.put(id, new HashSet<>());
        alertedCount.put(id, 0);
        alertScore.put(id, 0);
    }

    private void analyzeReports(String[] report){
        for(String reportEach: report){
            analyzeEach(reportEach);
        }
    }

    private void analyzeEach(String reportEach){
        String[] names = reportEach.split(" ");
        if(isNewName(names)){
            putNamesOnAlertingNames(names);
            addAlertedCount(names[1]);
        }
    }

    private boolean isNewName(String[] names){
        return !alertingNames.get(names[0]).contains(names[1]);
    }

    private void putNamesOnAlertingNames(String[] names){
        alertingNames.get(names[0]).add(names[1]);
    }

    private void addAlertedCount(String name){
        alertedCount.replace(name, alertedCount.get(name), alertedCount.get(name)+1);
    }

    private void deleteCountByK(int k){
        for(String id : alertedCount.keySet()){
            alertedCount.replace(id, alertedCount.get(id), alertedCount.get(id)/k);
        }
    }

    private void setUpScore(String[] id_list){
        for(String id : id_list){
            checkAlertingNamesOfId(id);
        }
    }

    private void checkAlertingNamesOfId(String id){
        int totalCount = 0;
        for(String name : alertingNames.get(id)){
            totalCount += getValueOfName(name);
        }
        alertScore.replace(id, 0, totalCount);
    }

    private int getValueOfName(String name){
        if (alertedCount.get(name) > 0) return 1;
        return 0;
    }
}