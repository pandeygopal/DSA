class Solution {
    public boolean isPossible(int[] target) {

        if(target.length == 1)
            return target[0] == 1;

        long sum = 0;
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for(int x : target){
            sum += x;
            pq.offer(x);
        }

        while(pq.peek() > 1){
            long mx = pq.poll();
            long rest = sum - mx;

            if(rest == 1) return true;
            if(rest == 0 || mx <= rest) return false;

            long prev = mx % rest;
            if(prev == 0) return false;

            pq.offer((int)prev);
            sum = rest + prev;
        }

        return true;
    }
}