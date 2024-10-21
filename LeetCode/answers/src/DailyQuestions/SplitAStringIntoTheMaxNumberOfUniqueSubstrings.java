package DailyQuestions;

public class SplitAStringIntoTheMaxNumberOfUniqueSubstrings {

    public int maxUniqueSplit(String s) {
        return getSubstringSize(s, 0, new HashSet<>());
    }

    private int getSubstringSize(final String s, final int start, final Set<String> set) {

        int value = set.size();

        for(int index = start+1; index <= s.length(); index++) {
            final String split = s.substring(start, index);
            final Set<String> nextSet = new HashSet<>(set);
            nextSet.add(split);
            value = Math.max(getSubstringSize(s, index, nextSet), value);
        }

        return value;
    }
}
