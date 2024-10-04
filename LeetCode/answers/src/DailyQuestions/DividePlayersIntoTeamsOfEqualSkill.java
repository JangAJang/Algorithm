package DailyQuestions;

public class DividePlayersIntoTeamsOfEqualSkill {

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long value = skill[0] + skill[skill.length-1];
        long sum = 0;

        for(int index = 0; index < skill.length/2; index++) {
            if(value != skill[index] + skill[skill.length - 1 - index]) {
                return -1;
            }
            sum += skill[index] * skill[skill.length - 1 - index];
        }

        return sum;
    }
}
