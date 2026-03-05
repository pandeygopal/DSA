class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int m : matchsticks) sum += m;

        if(sum % 4 != 0) return false;

        int side = sum / 4;
        int[] sides = new int[4];

        Arrays.sort(matchsticks);

        return dfs(matchsticks, matchsticks.length - 1, sides, side);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        if(index < 0)
            return sides[0] == target && sides[1] == target &&
                   sides[2] == target && sides[3] == target;

        int val = matchsticks[index];

        for(int i = 0; i < 4; i++) {
            if(sides[i] + val <= target) {
                sides[i] += val;

                if(dfs(matchsticks, index - 1, sides, target))
                    return true;

                sides[i] -= val;
            }
        }

        return false;
    }
}