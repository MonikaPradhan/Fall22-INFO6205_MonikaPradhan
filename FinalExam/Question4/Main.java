package Question4;

/*Question 4: You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
                An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
                Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
*/

/*Complexity :
    Time Complexity : O(N*M)
    Space Complexity : O(N*M)
 */

public class Main {
    public static void main(String[] args) {
        //Providing the input
        int[][] grid ={{0,0,0},{0,1,0},{0,0,0}};
        //int[][] grid = {{0,1},{0,0}};
        // Defining the variable to store the final result
        int result = uniquePathsWithObstacles(grid);
        System.out.println("The output is : "+result);
    }

    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathMatrix = new int[m][n];

        // unique path for top row will be either 1 or 0 in case there is obstacle.
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)  {
                pathMatrix[i][0] = 0;
                break;
            } else
                pathMatrix[i][0] = 1;
        }

        // unique path for first col will be either 1 or 0 in case there is obstacle.
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1)  {
                pathMatrix[0][j] = 0;
                break;
            } else
                pathMatrix[0][j] = 1;
        }

        // unique path for to a cell will be number of paths from top + number of paths from left.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1)
                    pathMatrix[i][j] = 0;
                else
                    pathMatrix[i][j] = pathMatrix[i-1][j] + pathMatrix[i][j-1];
            }
        }

        return pathMatrix[m-1][n-1];
    }
}