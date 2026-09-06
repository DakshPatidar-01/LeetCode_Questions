class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())map.put(ch, map.getOrDefault(ch, 0)+1);
        PriorityQueue<Character> pq = 
                new PriorityQueue<>((a,b)->Integer.compare(map.get(a), map.get(b)));

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()){
            char curr = pq.poll();
            while(map.get(curr)>0){
                ans.append(curr);
                map.put(curr, map.get(curr)-1);
            }
        }
        return ans.reverse().toString();
    }
}