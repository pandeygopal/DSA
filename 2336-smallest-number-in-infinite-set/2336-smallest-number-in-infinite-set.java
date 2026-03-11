class SmallestInfiniteSet {

    private int curr = 1;
    private TreeSet<Integer> set = new TreeSet<>();

    public SmallestInfiniteSet() {}

    public int popSmallest() {

        if(!set.isEmpty()){
            int val = set.first();
            set.remove(val);
            return val;
        }

        return curr++;
    }

    public void addBack(int num) {

        if(num < curr){
            set.add(num);
        }
    }
}