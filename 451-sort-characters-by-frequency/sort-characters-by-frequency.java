class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())map.put(ch, map.getOrDefault(ch, 0)+1);
        List<Character>[] bucket = new ArrayList[s.length()+1];

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(ch);
        }

        StringBuilder ans = new StringBuilder();
        for(int freq=s.length();freq>=1;freq--){
            if(bucket[freq]!=null){
                for(char ch : bucket[freq]){
                    for(int i=0;i<freq;i++){
                        ans.append(ch);
                    }
                }
            }
        }
        return ans.toString();
    }
}