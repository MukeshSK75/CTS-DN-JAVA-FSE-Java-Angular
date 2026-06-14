public class Ex08_OpPrecedence {
    public static void main(String[] args) {
        int r1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + r1 + "  (* before +)");

        int r2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + r2 + "  (parentheses first)");

        int r3 = 20 / 4 + 3 * 2 - 1;
        System.out.println("20 / 4 + 3 * 2 - 1 = " + r3 + "  (/ and * before + and -)");

        int r4 = 100 % 30 + 10 * 2;
        System.out.println("100 % 30 + 10 * 2 = " + r4 + "  (% and * before +)");
    }
}
