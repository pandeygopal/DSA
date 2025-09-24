public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        long integerPart = num / den;
        sb.append(integerPart);
        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }
        
        sb.append(".");
        
        Map<Long, Integer> seenRemainders = new HashMap<>();
        
        while (remainder != 0) {
            if (seenRemainders.containsKey(remainder)) {
                int index = seenRemainders.get(remainder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }
            
            seenRemainders.put(remainder, sb.length());
            
            remainder *= 10;
            long quotientDigit = remainder / den;
            sb.append(quotientDigit);
            remainder = remainder % den;
        }
        
        return sb.toString();
    }
}
