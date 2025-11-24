class Solution {
    public int minCostConnectPoints(int[][] points) {
     int n= points.length;
     if(n<=1) return 0;
     int [] minDist = new int [n];
     boolean [] inMST = new boolean [n];
     Arrays.fill(minDist,Integer.MAX_VALUE);
     minDist[0]=0;
     int totalCost=0;
     for(int i=0;i<n;i++){
        int u=-1;
        int best=Integer.MAX_VALUE;
        for(int v=0;v<n;v++){
            if(!inMST[v] && minDist[v]<best){
                best=minDist[v];
                u=v;
            }
        }
        inMST[u]=true;
        totalCost += best == Integer.MAX_VALUE ? 0 : best;
        for(int v=0;v<n;v++){
            if(!inMST[v]){
              int dist = Math.abs(points[u][0]-points[v][0]) + Math.abs(points[u][1]-points[v][1]);
               if(dist < minDist[v]){
                minDist[v]=dist;
            }
            }
           
        }


     }
     return totalCost;   
    }
}