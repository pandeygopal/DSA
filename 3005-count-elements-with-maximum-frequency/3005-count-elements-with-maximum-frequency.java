class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxFreq=0;
        for(int i=0;i<nums.length;i++){
            int freq=map.getOrDefault(nums[i], 0)+1;
            map.put(nums[i],freq);
            maxFreq=(maxFreq>freq)? maxFreq : freq;
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
           if(map.get(nums[i])==maxFreq){
            count++;
           }
        }
        return count;
    }
}