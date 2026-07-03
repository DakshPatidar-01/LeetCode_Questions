class Solution {
    private PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int stone:stones)pq.offer(stone);
        while((!pq.isEmpty()) && pq.size()!=1){
            int y= pq.poll();
            int x = pq.poll();
            if(y!=x)pq.add(y-x);
        }
        if(pq.isEmpty())return 0;
        return pq.peek();
    }
}