class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == ' ') i++;

        if (i == n) return 0;

        int sign = 1;
        char c = s.charAt(i);
        if (c == '+' || c == '-') {
            sign = (c == '-') ? -1 : 1;
            i++;
        }

        long result = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') break;

            result = result * 10 + (ch - '0');
            if (sign == 1 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * result);
    }
}
