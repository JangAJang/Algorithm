import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        return isAllNotContained(sortNumbers(phone_book));
    }

    private List<String> sortNumbers(String[] phone_book){
        return Arrays.stream(phone_book).sorted().collect(Collectors.toList());
    }

    private List<String> makeHeaders(String number){
        List<String> headers = new ArrayList<>();
        for(int index = 0; index < number.length(); index++){
            headers.add(number.substring(0, index));
        }
        return headers;
    }

    private boolean isHeaderContainingNumber(String number, List<String> headers){
        return headers.contains(number);
    }

    private boolean isAllNotContained(List<String> sorted){
        for(int index = 0; index < sorted.size()-1; index++){
            if(isHeaderContainingNumber(sorted.get(index), makeHeaders(sorted.get(index+1)))) return false;
        }
        return true;
    }
}