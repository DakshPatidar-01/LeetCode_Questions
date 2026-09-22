class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean flag = false;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                if(i==sr&&j==sc){
                    fillColor(i,j,image,color,image[sr][sc]);
                    return image;
                }
            }
            if(flag)break;
        }
        return image;
    }

    private void fillColor(int i,int j,int image[][],int color,int orignal){
        if(i<0||j<0||i>=image.length||j>=image[0].length || image[i][j]!=orignal || image[i][j]==color)return;
        image[i][j]=color;
        fillColor(i+1, j, image, color,orignal);
        fillColor(i-1, j, image, color,orignal);
        fillColor(i, j+1, image, color,orignal);
        fillColor(i, j-1, image, color,orignal);
    }
}