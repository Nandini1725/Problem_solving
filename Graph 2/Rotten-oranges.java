
class Solution {
    
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int freshOranges = 0;
        Deque<int[]> queue = new LinkedList<>(); 
      
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (grid[i][j] == 2) { 
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) { 
                    freshOranges++;
                }
            }
        }
      
        int minutesElapsed = 0;
        int[] directions = {1, 0, -1, 0, 1};
        while (!queue.isEmpty() && freshOranges > 0) {
            minutesElapsed++;
            for (int i = queue.size(); i > 0; --i) {
                int[] position = queue.poll();
                for (int j = 0; j < 4; ++j) { 
                    int x = position[0] + directions[j]; 
                    int y = position[1] + directions[j + 1];
                    
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshOranges--;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }

        return freshOranges > 0 ? -1 : minutesElapsed;
    }
}
