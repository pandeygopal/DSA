class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int[] d : dir){
                int r = cur[0] + d[0];
                int c = cur[1] + d[1];
                
                if(r>=0 && c>=0 && r<m && c<n && mat[r][c]==-1){
                    mat[r][c] = mat[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{r,c});
                }
            }
        }
        
        return mat;
    }
}