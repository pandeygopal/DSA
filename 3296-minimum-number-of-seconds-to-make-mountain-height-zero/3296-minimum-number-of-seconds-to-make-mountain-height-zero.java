class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long left = 1;
        long right = (long)1e18;

        while(left < right){
            long mid = left + (right - left) / 2;

            if(can(mid, mountainHeight, workerTimes))
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    private boolean can(long time, int H, int[] workers){
        long total = 0;

        for(int t : workers){

            long low = 0, high = H;

            while(low <= high){
                long mid = (low + high) / 2;
                long cost = (long)t * mid * (mid + 1) / 2;

                if(cost <= time){
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            total += high;

            if(total >= H) return true;
        }

        return false;
    }
}