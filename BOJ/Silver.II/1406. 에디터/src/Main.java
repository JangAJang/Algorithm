import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Silver2. 1406 에디터
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String input;
    private static int cursor;

    public static void main(String[] args) throws IOException {
        input = br.readLine();
        cursor = input.length();
        int count = Integer.parseInt(br.readLine());
        while(count-- > 0) {
            activateCommand(br.readLine());
        }
        System.out.println(input);
    }

    private static void activateCommand(final String command) {
        if(command.equals("L")) {
            leftCursor();
            return;
        }

        if(command.equals("D")) {
            rightCursor();
            return;
        }

        if(command.equals("B")) {
            deleteLetter();
            return;
        }

        placeLetter(command.split(" ")[1]);
    }

    private static void placeLetter(final String letter) {
        String prefix = input.substring(0, cursor);
        String suffix = "";
        if(cursor < input.length()) {
            suffix = input.substring(cursor);
        }
        input = prefix + letter + suffix;
        cursor++;
    }

    private static void leftCursor() {
        cursor = Math.max(0, cursor-1);
    }

    private static void rightCursor() {
        cursor = Math.min(cursor+1, input.length());
    }

    private static void deleteLetter() {
        if(cursor == 0) return;
        String prefix = input.substring(0, cursor-1);
        String suffix = "";
        if(cursor <= input.length()) {
            suffix = input.substring(cursor);
        }
        input = prefix + suffix;
        cursor--;
    }
}