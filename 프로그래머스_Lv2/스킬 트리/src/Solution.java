import java.util.*;

class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        skillTrees.removeIf(s -> skill.indexOf(s.replaceAll("[^" + skill + "]", "")) != 0);
        answer = skillTrees.size();
        return answer;
    }

//    public int solution(String skill, String[] skill_trees) {
//        int count = 0;
//        for(String skillEach : skill_trees){
//            if(isSkillTreeAvailable(skill, skillEach)) {
//                count++;
//                System.out.println(skillEach);
//            }
//        }
//        return count;
//    }
//
//    private boolean isSkillTreeAvailable(String skill, String skillTree){
//        for(int index = 0; index < skill.length(); index++){
//            skillTree = skillTree.replace(Character.toString(skill.charAt(index)), Integer.toString(index+1));
//        }
//        List<Integer> skillTreeOrder = Arrays.stream(skillTree.split(""))
//                .filter(s-> Pattern.matches("^[0-9]*$", s))
//                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
//        if(skillTreeOrder.isEmpty()) return true;
//        if(isNumberInOrder(skillTreeOrder) && skillTreeOrder.get(0) == 1) return true;
//        return false;
//    }
//
//    private boolean isNumberInOrder(List<Integer> numbers){
//        for(int index = 0; index < numbers.size()-1; index++){
//            if(numbers.get(index+1) - numbers.get(index) != 1) return false;
//        }
//        return true;
//    }
}