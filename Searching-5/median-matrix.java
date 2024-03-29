public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low=0;
        
        int ans=0;
        int m=A.get(0).size();
        int n=A.size();
        int high=Integer.MAX_VALUE;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int temp=0;
            for(int i=0;i<n;i++)
            {
                temp+=solve(A.get(i),mid);
            }
            if(temp<=(n*m)/2)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    public int solve(ArrayList<Integer> list, int val)
    {
        int ans=0;
        int low=0;
        int high=list.size()-1;
        
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(list.get(mid)<val)
            {
                low=mid+1;
                ans=mid+1;
            }
            else
            high=mid-1;
        }
        return ans;
    }
}
