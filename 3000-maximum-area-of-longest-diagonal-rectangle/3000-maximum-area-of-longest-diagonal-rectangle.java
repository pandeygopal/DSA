class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxA=0;
        int maxD=0;
        for(int i=0;i<dimensions.length;i++){
            int len=dimensions[i][0];
            int breth=dimensions[i][1];
            if((len*len)+(breth*breth)>maxD){
                maxA=len*breth;
                maxD=(len*len)+(breth*breth);
            }else if((len*len)+(breth*breth)==maxD){
                maxA=Math.max(maxA,len*breth);
            }
        }
        return maxA;
    }
}