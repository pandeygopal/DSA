class Solution {
    public int findMin(int[] nums) {
        int ele=nums[0];
        int left=0;
        int right = nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid] < ele){
                if(ans>nums[mid]){
                    ans=nums[mid];
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
               left=mid+1;
            }
        }
        if(nums[0]<ans) return nums[0];
        return ans;
    }
}