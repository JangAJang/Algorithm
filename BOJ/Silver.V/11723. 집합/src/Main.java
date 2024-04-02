import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int value;

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        value = 0;
        StringTokenizer st;
        while(count-- > 0) {
            String command = br.readLine();
            if(command.equals("all")) {
                all();
                continue;
            }

            if(command.equals("empty")) {
                empty();
                continue;
            }

            st = new StringTokenizer(command);
            String word = st.nextToken();
            int index = Integer.parseInt(st.nextToken())-1;

            if(word.equals("check")) {
                System.out.println(check(index));
                continue;
            }

            if(word.equals("add")) {
                add(index);
                continue;
            }

            if(word.equals("remove")) {
                remove(index);
                continue;
            }

            if(word.equals("toggle")) {
                toggle(index);
            }
        }
    }

    private static void empty() {
        value = 0;
    }

    private static void all() {
        value = Integer.parseInt("11111111111111111111", 2);
    }

    private static void add(final int index) {
        value = value | (1<<index);
    }

    private static void remove(final int index) {
        value -= 1 << index;
    }

    private static int check(final int index) {
        int result = value & 1 << index;
        return result > 0 ? 1 : 0;
    }

    private static void toggle(final int index) {
        if(check(index) == 0) {
            add(index);
            return;
        }

        remove(index);
    }
}