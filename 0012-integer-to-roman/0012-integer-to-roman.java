public class Solution {
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; i++) {
            int count = num / values[i];
            num %= values[i];
            while (count-- > 0) sb.append(symbols[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] tests = {3, 4, 9, 58, 1994, 1, 3999};
        for (int t : tests) {
            System.out.printf("%d -> %s%n", t, intToRoman(t));
        }
    }
}
