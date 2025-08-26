class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set =new HashSet<>();
        int [] ans=new int[2];//3 2 4 ->6
        ans[0]=-1;
        for(int i=0;i<nums.length;i++){
            int partner =target-nums[i];
            if(set.contains(partner)){
                ans[1]=i;
                ans[0]=map.get(partner);
                return ans;
            }else{
            map.put(nums[i],i);
            set.add(nums[i]);
            }
        }
        return ans;

    }
}