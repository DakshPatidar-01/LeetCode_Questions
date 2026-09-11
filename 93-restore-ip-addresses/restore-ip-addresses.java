class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        makeSegment(0,0,new ArrayList<>(),s);
        return ans;
    }

    private void makeSegment(int idx,int parts,List<String> curr,String s){
        if(parts==4){
            if(idx==s.length())ans.add(String.join(".",curr));
            return;
        }

        for(int len=1;len<=3 && len+idx<=s.length();len++){
            String part = s.substring(idx,idx+len);
            if(!isValid(part))continue;
            curr.add(part);
            makeSegment(idx+len, parts+1, curr, s);
            curr.remove(curr.size()-1);
        }
    }

    private boolean isValid(String  part){
        if(part.length()>3)return false;
        if(part.length()>1 && part.charAt(0)=='0')return false;
        int num = Integer.parseInt(part);
        return num<=255;
    }
}