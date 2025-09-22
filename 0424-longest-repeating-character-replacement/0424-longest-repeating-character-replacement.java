class Solution {
    public int characterReplacement(String s, int k) {
        int idx=0;
        int max=0;
        int left=0;
        int maxfreq=0;
        Map<Character,Integer> map=new HashMap<>();
        while(s.length()>idx){
            map.put(s.charAt(idx), map.getOrDefault(s.charAt(idx), 0) + 1);
            maxfreq=Math.max(maxfreq,map.get(s.charAt(idx)));
            if(idx-left+1 - maxfreq>k){
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
            }
            max=Math.max(max,idx-left+1);
            idx++;
        }
        return max;
    }
}