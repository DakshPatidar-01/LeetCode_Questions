class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int left=0,right=points.length-1;;
        while(left<=right){
            int pivotIdx = partition(points,left,right);
            if(pivotIdx==k)break;
            else if(pivotIdx<k)left=pivotIdx+1;
            else right=pivotIdx-1;
        }

        return Arrays.copyOfRange(points, 0, k);
    }

    private int partition(int points[][],int left,int right){
        int pivot[] = points[right];
        int pivotDist = dist(pivot);
        int i=left;
        for(int j=left;j<right;j++){
            if(dist(points[j])<=pivotDist){
                swap(points,i,j);
                i++;
            }
        }

        swap(points,i,right);
        return i;
    }

    private int dist(int point[]){
        return point[0]*point[0]+point[1]*point[1];
    }

    private void swap(int points[][],int i,int j){
        int temp[] = points[i];
        points[i]=points[j];
        points[j]=temp;
    }
}