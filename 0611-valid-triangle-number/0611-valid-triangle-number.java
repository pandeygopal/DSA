class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int point1=0;
        int point2=1;
        int point3=nums.length-1;
        int count=0;
       for(int i=0;i<nums.length-2;i++){
        for(int j=i+1;j<nums.length-1;j++){
            for(int k=j+1;k<nums.length;k++){
                if(nums[i]+nums[j]>nums[k]){
                count++;
            }
            }
        }
       }
       return count;
    }
}