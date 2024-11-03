package DailyQuestions;

public class RotateString {

	public boolean rotateString(String s, String goal) {
		for(int index = 0; index < s.length(); index++) {
			if( (s.substring(index) + s.substring(0, index)).equals(goal) ) return true;
		}
		return false;
	}
}
