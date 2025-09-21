class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int idx=0;
        int left=0;
        int right=0;
        int max=0;
        int count=0;
        while(idx<s.length()){
            if(map.containsKey(s.charAt(idx)) && map.get(s.charAt(idx)) >= left){
                left=map.get(s.charAt(idx))+1;
            }
            map.put(s.charAt(idx),idx);
            max=Math.max(max,idx-left+1);
            idx++;
        }
        return max;
    }
}