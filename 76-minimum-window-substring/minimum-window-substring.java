class Solution {
    public String minWindow(String s,String t) {
        HashMap<Character,Integer> need=new HashMap<>(),freq=new HashMap<>();
        for(char c:t.toCharArray())need.put(c,need.getOrDefault(c,0)+1);

        int left=0,matched=0,required=need.size(),start=0,minLen=Integer.MAX_VALUE;

        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            freq.put(c,freq.getOrDefault(c,0)+1);

            if(need.containsKey(c)&&freq.get(c).intValue()==need.get(c))matched++;

            while(matched==required){
                if(right-left+1<minLen){
                    start=left;
                    minLen=right-left+1;
                }
                char x=s.charAt(left++);
                freq.put(x,freq.get(x)-1);

                if(need.containsKey(x)&&freq.get(x)<need.get(x))matched--;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}