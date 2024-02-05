import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final boolean[] arr = new boolean[21];

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(br.readLine());
        while(count-- > 0) {
            String command = br.readLine();
            if (command.equals("all")) {
                setAll();
                continue;
            }

            if (command.equals("empty")) {
                setEmpty();
            }

            String[] commandAndNumber = command.split(" ");
            int value = Integer.parseInt(commandAndNumber[1]);
            command = commandAndNumber[0];
            if(command.equals("add")) {
                add(value);
                continue;
            }

            if(command.equals("remove")) {
                remove(value);
                continue;
            }

            if(command.equals("check")) {
                check(value);
                continue;
            }

            if(command.equals("toggle")) {
                toggle(value);
            }


        }

    }

    private static void setAll() {
        for(int count = 1; count <= 20; count++) {
            arr[count] = true;
        }
    }

    private static void setEmpty() {
        for(int count = 1; count <= 20; count++) {
            arr[count] = false;
        }
    }

    private static void add(final int value) {
        arr[value] = true;
    }

    private static void remove(final int value) {
        arr[value] = false;
    }

    private static void check(final int value) {
        System.out.println(arr[value] ? 1 : 0);
    }

    private static void toggle(final int value) {
        arr[value] = !arr[value];
    }
}