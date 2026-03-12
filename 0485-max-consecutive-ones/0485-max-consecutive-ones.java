class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0;
        int max2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                max++;
            }else{
                if(max>max2){
                    max2=max;
                }
                max=0;
            }
        }
        return (max2>max)?max2:max;
    }
}