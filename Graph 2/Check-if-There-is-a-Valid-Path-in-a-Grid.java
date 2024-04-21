class Solution {
    public int[] parent;
    public int[][] grid;
    public int row;
    public int col;

    public int find(int x){
        if(parent[x]!=x)
        parent[x] = find(parent[x]);

        return parent[x];
    }

    public void left(int i, int j){
        if(j>0 && (grid[i][j-1] ==1 || grid[i][j-1]==4 || grid[i][j-1]==6)){
            parent[find(i*col + j)] = find(i*col + j-1);
        }
    }

    public void right(int i, int j){
        if(j<col-1 && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5))
        parent[find(i*col + j)] = find(i*col +j+1);
    }

    public void up(int i, int j){
        if(i>0 && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4))
        parent[find(i*col +j)] = find((i-1)*col+j);
    }

    public void down(int i, int j){
        if(i<row-1 && (grid[i+1][j]==2 || grid[i+1][j]==5 || grid[i+1][j]==6)){
            parent[find(i*col +j)] = find((i+1)*col +j);
        }
    }
    public boolean hasValidPath(int[][] grid) {
        this.grid=grid;
        row = grid.length;
        col = grid[0].length;
        parent = new int[row*col];

        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int x = grid[i][j];
                switch(x){
                    case 1:
                        left(i,j);
                        right(i,j);
                        break;

                    case 2:
                        up(i,j);
                        down(i,j);
                        break;

                    case 3:
                        left(i,j);
                        down(i,j);
                        break;    

                    case 4:
                        right(i,j);
                        down(i,j);
                        break;

                    case 5:
                        left(i,j);
                        up(i,j);
                        break; 

                    case 6:
                        right(i,j);
                        up(i,j);
                        break;  

                    default:
                    break;             
                }
            }
        }
        return find(0)==find(row*col -1);
    }
}
