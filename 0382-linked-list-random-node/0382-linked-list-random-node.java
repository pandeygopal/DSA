class Solution {

    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        this.head = head;
        rand = new Random();
    }

    public int getRandom() {
        int res = -1;
        int i = 1;
        ListNode curr = head;

        while(curr != null){
            if(rand.nextInt(i) == 0){
                res = curr.val;
            }
            curr = curr.next;
            i++;
        }

        return res;
    }
}