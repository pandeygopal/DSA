class Solution {
    public static int numWaterBottles(int numBottles, int numExchange) {
        int totaldrunk= numBottles;
        int emptybottles=numBottles;
        while(emptybottles>=numExchange)
        {
       int newbottles= emptybottles/numExchange;
       emptybottles=emptybottles%numExchange+newbottles;
       totaldrunk+=newbottles;
        }
        return totaldrunk;

    }
}