class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int l = 0, r = nums.length - 1;

        while(l < nums.length && nums[l] == sorted[l]) l++;
        while(r > l && nums[r] == sorted[r]) r--;

        return r - l + 1;
    }
}