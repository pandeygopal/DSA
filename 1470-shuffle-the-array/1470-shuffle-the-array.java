class Solution {
    public int[] shuffle(int[] nums, int n) {
       int [] arr=new int[n+n];
       int p=0;
       for(int i=0;i<n;i++){
        arr[p]=nums[i];
        arr[p+1]=nums[i+n];
        p=p+2;
       }
       return arr;
        
    }
}