class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        solve(image,sr,sc,color,image[sr][sc]);
        return image;
    }

    private static void solve(int[][] image,int i,int j,int newColor,int orignal){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length)return;
        if(image[i][j]!=orignal)return;
        image[i][j]=newColor;
        solve(image, i+1, j, newColor, orignal);
        solve(image, i-1, j, newColor, orignal);
        solve(image, i, j+1, newColor, orignal);
        solve(image, i, j-1, newColor, orignal);
    }
}