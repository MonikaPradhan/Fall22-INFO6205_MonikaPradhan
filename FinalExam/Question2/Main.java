package Question2;

/*Question 2:
        Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
       An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

/*Complexity :
    Time Complexity : O(n*m)
    Space Complexity:  O(1)
 */

public class Main {
    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int result = numIslands(grid);
        System.out.println("The number if Islands is : " + result);
    }

    public static int numIslands(char[][] grid) {
            int countOfIslands = 0;

            // Find land and keep counting the connected land to it which will make an island.
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        countOfIslands = countOfIslands + 1;
                        countConnectedLand(grid, i, j);
                    }
                }
            }

            return countOfIslands;
    }

        private static void countConnectedLand ( char[][] grid, int i, int j){
        // If we are out of the grid bounds or the current grid position is not land then return.
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
                return;
            }

            if (grid[i][j] == '0') {
                return;
            }

            // Update the current land value in grid to water, so we dont count this land again.
            grid[i][j] = '0';
            countConnectedLand(grid, i + 1, j);
            countConnectedLand(grid, i - 1, j);
            countConnectedLand(grid, i, j + 1);
            countConnectedLand(grid, i, j - 1);

            return;
        }
    }


