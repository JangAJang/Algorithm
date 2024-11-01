package DailyQuestions;

public class DeleteCharactersToMakeFancyString {

	public String makeFancyString(String s) {
		char continuousAlphabet;
		int count = 0;

		StringBuilder sb = new StringBuilder();

		count = 1;
		continuousAlphabet = s.charAt(0);
		sb.append(continuousAlphabet);

		for(int index = 1; index < s.length(); index++) {
			if(continuousAlphabet == s.charAt(index)) {
				// 이번에 3번째라면 무시하고 넘긴다.
				if(count == 2) {
					continue;
				}

				// 3번째 전이라면 append하고 count증가
				sb.append(s.charAt(index));
				count++;
				continue;
			}

			continuousAlphabet = s.charAt(index);
			sb.append(s.charAt(index));
			count = 1;
		}

		return sb.toString();
	}
}
