//brute force approach

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int i=0;
        int j=n-1;

        while((i>=0 && i<m) && (j>=0 && j<n)){
            if(matrix[i][j]==target)
            return true;

            else if(matrix[i][j]>target)
            j--;

            else if(matrix[i][j]<target)
            i++;
        }
        return false;
    }
}

// binary search approach
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0;
        int high = (n*m)-1;


        while(low<=high){
            int mid = (low+high)/2;
            int i = mid/m;
            int j = mid%m;
            if(matrix[i][j]==target)
            return true;

            else if(matrix[i][j]>target)
            high = mid-1;

            else 
            low=mid+1;
        }
        return false;
    }
}
