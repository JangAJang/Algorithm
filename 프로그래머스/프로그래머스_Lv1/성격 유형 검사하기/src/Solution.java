import java.util.HashMap;

class Solution {

    private static final int SCORE_DIVIDER = 4;
    private static final int LEFT_TYPE = 0;
    private static final int RIGHT_TYPE = 1;
    private static final String[] mbtiTypes = {"R", "T", "C", "F", "J", "M", "A", "N"};
    private final HashMap<String, Integer> mbtiScore= new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        initializeMap();
        calculateScore(survey, choices);
        return getMBTI();
    }

    private void initializeMap(){
        for(String type : mbtiTypes){
            mbtiScore.put(type, 0);
        }
    }

    private String getMBTI(){
        return distinguishROrT().concat(distinguishCOrF()).concat(distinguishJOrM()).concat(distinguishAOrN());
    }

    private String distinguishROrT(){
        return mbtiScore.get("R") >= mbtiScore.get("T") ? "R" : "T";
    }

    private String distinguishCOrF(){
        return mbtiScore.get("C") >= mbtiScore.get("F") ? "C" : "F";
    }

    private String distinguishJOrM(){
        return mbtiScore.get("J") >= mbtiScore.get("M") ? "J" : "M";
    }

    private String distinguishAOrN(){
        return mbtiScore.get("A") >= mbtiScore.get("N") ? "A" : "N";
    }

    private void calculateScore(String[] survey, int[] choices){
        for(int i=0; i<choices.length; i++){
            getScoreOfSurvey(survey[i], choices[i]);
        }
    }

    private void getScoreOfSurvey(String survey, int choice){
        String[] type = survey.split("");
        if(choice > SCORE_DIVIDER) addScoreTo(type[RIGHT_TYPE], choice - SCORE_DIVIDER);
        if(choice < SCORE_DIVIDER) addScoreTo(type[LEFT_TYPE], SCORE_DIVIDER - choice);
    }

    private void addScoreTo(String type, int score){
        mbtiScore.replace(type, mbtiScore.get(type), mbtiScore.get(type)+score);
    }
}