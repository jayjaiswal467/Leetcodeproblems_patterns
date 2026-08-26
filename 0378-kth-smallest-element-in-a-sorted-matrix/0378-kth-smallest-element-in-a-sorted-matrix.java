class Solution {
    public int anscalc(int[][] matrix,int n ,int m,int guess){
        int row =n-1;
        int col = 0;
        int count=0;

        while(row>=0 && col<m){
            if(matrix[row][col]<=guess){
                count=count+row+1;
                col++;
            }
            else{
                row--;
            }
        }
    return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        int res = -1;

        while(low<=high){
            int guess=(low+high)/2;
            
            int ans = anscalc(matrix,n,m,guess);
            if(ans<k){
                low=guess+1;
            }
            else{
                res=guess;
                high=guess-1;
            }
        }
    return res;
    }
}