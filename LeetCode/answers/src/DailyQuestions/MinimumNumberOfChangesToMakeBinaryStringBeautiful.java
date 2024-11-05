package DailyQuestions;

public class MinimumNumberOfChangesToMakeBinaryStringBeautiful {

	public int minChanges(String s) {
		int count = 0;
		for(int index = 0; index < s.length(); index += 2) {
			if(s.charAt(index) != s.charAt(index+1)) count++;
		}

		return count;
	}
}
