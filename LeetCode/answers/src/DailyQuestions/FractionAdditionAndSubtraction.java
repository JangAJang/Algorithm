package DailyQuestions;

public class FractionAdditionAndSubtraction {

    public String fractionAddition(String expression) {
        String answer = "0/1";
        expression = expression.replaceAll("-", "+-");
        List<Fraction> fractions = Arrays.stream(expression.split("\\+"))
            .filter(each -> !each.equals(""))
            .map(each -> Fraction.from(each))
            .toList();

        for(final Fraction each : fractions) {
            Fraction fraction = Fraction.from(answer);
            answer = fraction.addFraction(each).getIrreducibleFraction();
        }

        return answer;
    }

    private static class Fraction {
        private int son;
        private int mom;

        public Fraction(int son, int mom) {
            this.son = son;
            this.mom = mom;
        }

        public static Fraction from(final String expression) {
            String[] split = expression.split("/");
            return new Fraction(parseSon(split[0]), Integer.parseInt(split[1]));
        }

        public String getIrreducibleFraction() {
            if(son == 0) return "0/1";
            String pM = son < 0 ? "-" : "";
            int gcd = gcd(Math.abs(son), mom);
            return pM + "%d/%d".formatted(Math.abs(son) / gcd, mom / gcd);
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        private static int parseSon(String son) {
            if(son.toCharArray()[0] == '+') return Integer.parseInt(son.substring(1, son.length()));
            if(son.toCharArray()[0] == '-')return -1 * Integer.parseInt(son.substring(1, son.length()));

            return Integer.parseInt(son);
        }

        public Fraction addFraction(final Fraction fraction) {
            int son1 = this.son * fraction.getMom();
            int son2 = fraction.getSon() * this.mom;
            return new Fraction(son1 + son2, this.mom * fraction.getMom());
        }

        public int getMom() {
            return this.mom;
        }

        public int getSon() {
            return this.son;
        }
    }
}


