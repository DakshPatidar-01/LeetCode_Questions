class Solution {
    public boolean isAnagram(String s, String t) {
        char []arr1 = s.toCharArray();
        char []arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String ar1 = new String(arr1);
        String ar2 = new String(arr2);

        if(ar1.equals(ar2)){
            return true;
        }

        return false;
        
    }
}