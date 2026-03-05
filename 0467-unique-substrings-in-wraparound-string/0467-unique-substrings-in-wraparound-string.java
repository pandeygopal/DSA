class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        int k = 0;

        for(int i = 0; i < p.length(); i++) {
            if(i > 0 && (p.charAt(i) - p.charAt(i-1) == 1 ||
               p.charAt(i-1) - p.charAt(i) == 25)) {
                k++;
            } else {
                k = 1;
            }

            int index = p.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], k);
        }

        int sum = 0;
        for(int x : dp) sum += x;

        return sum;
    }
}