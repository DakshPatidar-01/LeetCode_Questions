import java.util.Arrays;

class Solution {
    public int minDistance(String word1, String word2) {    
        if(word1.isEmpty())return word2.length();
        if(word2.isEmpty())return word1.length();
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(word1, word2, 0, 0,dp);
    }

    private int solve(String word1, String word2, int i, int j,int [][] dp) {

        // word1 khatam ho gaya
        if (i == word1.length()) {
            return word2.length() - j;
        }

        // word2 khatam ho gaya
        if (j == word2.length()) {
            return word1.length() - i;
        }

        //Already Present
        if(dp[i][j]!=-1)return dp[i][j];

        // Characters same hain
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j]=solve(word1, word2, i + 1, j + 1,dp);
        }

        // 3 operations
        int insert = 1 + solve(word1, word2, i, j + 1,dp);
        int delete = 1 + solve(word1, word2, i + 1, j,dp);
        int replace = 1 + solve(word1, word2, i + 1, j + 1,dp);

        dp[i][j] = Math.min(insert, Math.min(delete, replace));
        return dp[i][j];
    }
}