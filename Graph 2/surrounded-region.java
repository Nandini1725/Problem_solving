class pair{
    int first;
    int second;

    pair(int first, int second){
        this.first = first;
        this.second = second; 
    }
}
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];
        Queue<pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            if(visited[0][i]==0 && board[0][i]=='O'){
                q.add(new pair(0,i));
            }
            if(visited[n-1][i]==0 && board[n-1][i]=='O'){
                q.add(new pair(n-1,i));
            }
        }
        for(int i=0;i<n;i++){
            if(visited[i][0] == 0 && board[i][0]=='O'){
                q.add(new pair(i,0));
            }
            if(visited[i][m-1]==0 && board[i][m-1]=='O'){
                q.add(new pair(i,m-1));
            }
        }

        int[] dirRow = {-1,0,1,0};
        int[] dirCol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            visited[row][col]= 1;
            q.remove();
            for(int i=0;i<4;i++){
                int newRow = row + dirRow[i];
                int newCol = col + dirCol[i];

                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && visited[newRow][newCol]==0 && board[newRow][newCol]=='O'){
                    q.add(new pair(newRow, newCol));
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && board[i][j]=='O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
