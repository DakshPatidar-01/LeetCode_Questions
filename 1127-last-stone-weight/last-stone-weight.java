class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones)pq.add(x);
        while(pq.size()>2){
            int first_Largest = pq.poll();
            int second_Largest = pq.poll();
            if(first_Largest==second_Largest)continue;
            else {
                int diff = first_Largest-second_Largest;
                pq.add(diff);
            }
        }
        return pq.size()==2?pq.poll()-pq.poll():pq.peek();
    }
}