class Solution {

    private String[] lower;
    private StringBuilder stringBuilder = new StringBuilder();

    public String solution(String s) {
        lower = s.toLowerCase().split("");
        changeToJaden();
        return stringBuilder.toString();
    }

    private void changeToJaden(){
        for(int index=0; index<lower.length; index++){
            stringBuilder.append(changeEach(index));
        }
    }

    private String changeEach(int index){
        if(index == 0) return lower[index].toUpperCase();
        if(lower[index-1].equals(" ")) return lower[index].toUpperCase();
        return lower[index];
    }
}