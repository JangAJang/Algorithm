class Solution {

    public String solution(String new_id) {
        return doSequences(new_id);
    }

    private String doSequences(String id){
        id = id.toLowerCase();
        id = doSequence2(id);
        id = doSequence3(id);
        id = doSequence4(id);
        id = doSequence5(id);
        id = doSequence6(id);
        return doSequence7(id);
    }

    private String doSequence2(String id){
        String result = "";
        for(int i=0; i<id.length(); i++){
            result = checkWord(result, id.charAt(i));
        }
        return result;
    }

    private String checkWord(String result, char c){
        if(c - 'a' >=0 && c - 'a' <=25 ) return result.concat(Character.toString(c));
        if(c - '0' >=0 && c - '0' <= 9) return result.concat(Character.toString(c));
        if(c == '-' || c == '_' || c == '.') return result.concat(Character.toString(c));
        return result;
    }

    private String doSequence3(String id){
        String result = "";
        for(int i=0; i<id.length(); i++){
            result = putCharacterIfNotPoints(result, id.charAt(i));
        }
        return result;
    }

    private String putCharacterIfNotPoints(String result, char next){
        if(result.isEmpty()) return result.concat(Character.toString(next));
        if(result.charAt(result.length()-1) == '.' && next == '.') return result;
        return result.concat(Character.toString(next));
    }

    private String doSequence4(String seq3){
        if(seq3.length() == 0) return seq3;
        if(seq3.charAt(0) == '.') return doSequence4(deleteFirstPoint(seq3));
        if(seq3.charAt(seq3.length()-1) == '.') return doSequence4(deleteLastPoint(seq3));
        return seq3;
    }

    private String deleteFirstPoint(String seq3){
        return seq3.substring(1);
    }

    private String deleteLastPoint(String seq3){
        return seq3.substring(0, seq3.length()-1);
    }

    private String doSequence5(String seq4){
        if(seq4.length() == 0) return "a";
        return seq4;
    }

    private String doSequence6(String seq5){
        if(seq5.length() > 15) seq5 = seq5.substring(0, 15);
        if(seq5.charAt(seq5.length()-1) == '.') return doSequence6(deleteLastPoint(seq5));
        return seq5;
    }

    private String doSequence7(String seq6){
        if(seq6.length() < 3) return duplicateLastLetter(seq6);
        return seq6;
    }

    private String duplicateLastLetter(String seq6){
        while(seq6.length() < 3){
            seq6 = seq6.concat(Character.toString(seq6.charAt(seq6.length()-1)));
        }
        return seq6;
    }
}