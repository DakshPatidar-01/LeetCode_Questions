class Solution {
    public static String reverseVowels(String s) {
        char arr[] = new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=s.charAt(i);
        }
        int left=0,right=s.length()-1;
        while(left<right){
            while(left<right && !isVowel(Character.toLowerCase(arr[left])))left++;
            while(left<right && !isVowel(Character.toLowerCase(arr[right])))right--;
            char temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;right--;
        }
        return new String(arr);
    }

    private static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'|| ch=='o'|| ch=='u'){
            return true;
        }
        return false;
    }
}