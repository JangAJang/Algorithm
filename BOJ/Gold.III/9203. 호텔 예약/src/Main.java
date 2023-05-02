import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            countRooms();
        }
    }

    private static void countRooms()throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int reservationCount = Integer.parseInt(st.nextToken());
        int cleaningTime = Integer.parseInt(st.nextToken());
        List<Reservation> reservations = getReservations(cleaningTime, reservationCount);
        int count = 1;
        Reservation reservation = reservations.get(0);
        for(int index = 1; index < reservations.size(); index++){
            if(reservations.get(index).getStart().isBefore(reservation.getEnd())){
                count++;
                reservation = reservations.get(index);
            }
        }
        System.out.println(count);
    }

    private static List<Reservation> getReservations(int cleaningTime, int reservationCount) throws IOException{
        List<Reservation> reservations = new ArrayList<>();
        while(reservationCount-- > 0){
            String[] info = br.readLine().split(" ");
            String name = info[0];
            LocalDateTime start = LocalDateTime.parse(info[1]+" " + info[2], dateTimeFormatter);
            LocalDateTime end = LocalDateTime.parse(info[3]+" " + info[4], dateTimeFormatter);
            Reservation reservation = new Reservation(name, start, end);
            reservation.addCleaningTime(cleaningTime);
            reservations.add(reservation);
        }
        return sortReservations(reservations);
    }

    private static List<Reservation> sortReservations(List<Reservation> reservations){
        reservations.sort((i1, i2) -> {
            if(i1.getEnd().isBefore(i2.getEnd())) return -1;
            if(i1.getEnd().isEqual(i2.getEnd())){
                if(i1.getStart().isBefore(i2.getStart())) return -1;
                return 1;
            }
            return 1;
        });
        return reservations;
    }

    static class Reservation{
        private String name;
        private LocalDateTime start;
        private LocalDateTime end;

        public Reservation(String name, LocalDateTime start, LocalDateTime end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        public LocalDateTime getStart() {
            return start;
        }

        public LocalDateTime getEnd() {
            return end;
        }

        public void addCleaningTime(int cleaningTime) {
            int hour = cleaningTime / 60;
            int minute = cleaningTime% 60;
            end = end.plusMinutes(minute);
            end = end.plusHours(hour);
        }
    }

}