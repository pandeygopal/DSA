class Solution {

    int[][] rects;
    int[] prefix;
    Random rand = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;

        prefix = new int[rects.length];
        int sum = 0;

        for(int i = 0; i < rects.length; i++){
            int[] r = rects[i];
            sum += (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            prefix[i] = sum;
        }
    }

    public int[] pick() {

        int target = rand.nextInt(prefix[prefix.length-1]);

        int index = Arrays.binarySearch(prefix, target + 1);
        if(index < 0) index = -index - 1;

        int[] r = rects[index];

        int x = r[0] + rand.nextInt(r[2] - r[0] + 1);
        int y = r[1] + rand.nextInt(r[3] - r[1] + 1);

        return new int[]{x,y};
    }
}