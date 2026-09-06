class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq =
                    new PriorityQueue<>((a, b) -> Integer.compare(map.get(a), map.get(b)));
        for(int x:nums)map.put(x, map.getOrDefault(x, 0)+1);
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
            if(pq.size()>k)pq.poll();
        }
        int ans[] = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++]=pq.poll();
        }
        return ans;
    }
}