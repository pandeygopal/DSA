class Solution {
    public int maxSumDivThree(int[] nums) {
        int NEG = Integer.MIN_VALUE / 4;
        int[] dp = new int[]{0, NEG, NEG};

        for (int num : nums) {
            int rem = num % 3;
            int[] next = new int[]{dp[0], dp[1], dp[2]};
            for (int r = 0; r < 3; r++) {
                if (dp[r] == NEG) continue;
                int newRem = (r + rem) % 3;
                next[newRem] = Math.max(next[newRem], dp[r] + num);
            }
            dp = next;
        }
        return Math.max(0, dp[0]);
    }
}
