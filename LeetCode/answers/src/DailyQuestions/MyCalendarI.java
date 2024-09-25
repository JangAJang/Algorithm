package DailyQuestions;

public class MyCalendarI {

    class MyCalendar {

        private int start;
        private int end;
        private MyCalendar left;
        private MyCalendar right;

        public MyCalendar() {
            this.start = -1;
            this.end = -1;
        }

        public static MyCalendar of(final int start, final int end) {
            MyCalendar calendar = new MyCalendar();
            calendar.start = start;
            calendar.end = end;
            return calendar;
        }

        public boolean book(int start, int end) {
            if(start == -1) {
                this.start = start;
                this.end = end;
                return true;
            }

            if(end <= this.start) { // 새로운 예약의 종료시간이 내 시작시간보다 작거나 같으면 왼쪽에 추가
                if(this.left == null) {
                    this.left = MyCalendar.of(start, end);
                    return true;
                }

                return this.left.book(start, end);
            }

            if(start >= this.end) {
                if(this.right == null) {
                    this.right = MyCalendar.of(start, end);
                    return true;
                }

                return this.right.book(start, end);
            }

            return false;
        }
    }
}
