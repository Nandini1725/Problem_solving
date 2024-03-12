import java.util.ArrayList;

public class Solution 
{
    public static int solve(int mid,ArrayList<Integer> boards){
        int painter = 1;
        int boardsPaint=0;
        for(int i=0;i<boards.size();i++){
            if(boardsPaint + boards.get(i)<=mid){
                boardsPaint+=boards.get(i);
            }
            else{
                painter++;
                boardsPaint = boards.get(i);
            }
        }
        return painter;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int low=0;
        int high=0;

        for(int i=0;i<boards.size();i++){
            low = Math.max(boards.get(i),low);
            high += boards.get(i);
        }

        while(low<=high){
            int mid= (low+high)/2;
            int cnt= solve(mid,boards);
            if(cnt<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
