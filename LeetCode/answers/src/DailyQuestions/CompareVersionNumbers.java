package DailyQuestions;

public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        for(int index = 0; index < Math.max(ver1.length, ver2.length); index++) {
            int value = compareVersionByIndex(ver1, ver2, index);
            if(value != 0) return value;
        }
        return 0;
    }

    private int compareVersionByIndex(String[] ver1, String[] ver2, int index) {
        int ver1Value = ver1.length <= index ? 0 : Integer.parseInt(ver1[index]);
        int ver2Value = ver2.length <= index ? 0 : Integer.parseInt(ver2[index]);
        if(ver1Value == ver2Value) return 0;
        return ver1Value > ver2Value ? 1 : -1;
    }
}
