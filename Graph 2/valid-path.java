class pair{
    int first;
    int second;
    
    pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class Solution {
    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] arr = new int[A+1][B+1];
        Arrays.fill(arr,0);
        
        for(int i=0;i<=A;i++){
            for(int j=0;j<=B;j++){
                for(int k=0;k<C;k++)
                if(Math.sqrt(Math.pow(E[k]-i , 2) + Math.pow(F[k]-j , 2)) <=D){
                    arr[i][j]=1;
                    break;
                }
            }
        }
        
        if(arr[0][0]==1 || arr[A][B]==1)
        return "NO";
        
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,0));
        arr[0][0]=1;
        int[] X = {0,0,1,1,1,-1,-1,-1};
        int[] Y = {1,-1,0,1,-1,0,1,-1};
        
        while(!q.isEmpty()){
            int x = q.peek().first;
            int y = q.peek().second;
            q.remove();
            if(x==A && y==B)
            return "YES";
            
            for(int i=0;i<8;i++){
                int newx = x+ X[i];
                int newy = y+ Y[i];
                
                if(newx>=0 && newx<=A && newy>=0 && newy<=B && arr[newx][newy]==0){
                    arr[newx][newy]=1;
                    q.add(new pair(newx,newy));
                }
            }
        }
        return "NO";
    }
}
