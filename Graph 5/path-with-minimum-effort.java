class tuple{
    int difference;
    int row;
    int col;
    tuple(int difference, int row, int col){
        this.difference = difference;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<tuple> pq = new PriorityQueue<tuple>((x,y) -> x.difference - y.difference);
        pq.offer(new tuple(0,0,0));
        int[][] dist = new int[heights.length][heights[0].length];
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        dist[0][0]=0;
        int[] dirRow = {-1,0,1,0};
        int[] dirCol = {0,1,0,-1};
        while(!pq.isEmpty()){
            tuple it = pq.peek();
            int difference = it.difference;
            int row = it.row;
            int col = it.col;
            pq.poll();

            if(row==heights.length-1 && col==heights[0].length-1)
            return difference;

            for(int i=0;i<4;i++){
                int newRow = row+dirRow[i];
                int newCol = col + dirCol[i];

                if(newRow>=0 && newRow<heights.length && newCol>=0 && newCol<heights[0].length){
                    int effort = Math.max(Math.abs(heights[row][col]-heights[newRow][newCol]),difference);
                    
                    if(effort< dist[newRow][newCol]){
                        dist[newRow][newCol] = effort;
                        pq.offer(new tuple(effort,newRow,newCol));
                    }
                }
            }
        }
        return 0;
    }
}
