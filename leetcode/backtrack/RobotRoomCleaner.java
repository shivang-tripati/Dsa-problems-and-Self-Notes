package leetcode.backtrack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * RobotRoomCleaner
 * 
 */

 interface Robot {
  // returns true if next cell is open and robot moves into the cell.
  // returns false if next cell is obstacle and robot stays on the current cell.
  boolean move();

  // Robot will stay on the same cell after calling turnLeft/turnRight.
  // Each turn will be 90 degrees.
  void turnLeft();
  void turnRight();

  // Clean the current cell.
  void clean();
}

public class RobotRoomCleaner {

     // Up, Right, Down, Light
    final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0,-1}}; //The reason for having directionality in this cleaning process, instead of just using a simple DFS in all four directions,
    //  is to ensure thorough coverage and efficient exploration. By systematically rotating 90 degrees after each movement and exploring all options in that direction before backtracking,
    //  we guarantee that every area is adequately cleaned without revisiting already cleaned spaces unnecessarily. 
    
    Set<String> visited = new HashSet<>();

    public void cleanRoom(Robot robot) {
        dfs(0, 0, robot, 0);
    }

    private void dfs(int row, int col, Robot robot, int arrow) { // arrow -> is point where the robot is currently at

        String key = row + "," + col;

        if(!visited.contains(key)){
            visited.add(key);
            
            robot.clean();

            for(int i=0; i < 4; i++) {
                if(robot.move()) {
                    int[] currDirection = DIRECTIONS[arrow]; // first move up as arrow == 0; inititally
                    dfs(row + currDirection[0], col + currDirection[1], robot, arrow);

                }
                // change robot direction and arrow 
                robot.turnRight(); // turn clock wise
                arrow = (arrow + 1) % 4;
            }
        }

        // move back
        moveBack(robot);
    }

    private void moveBack(Robot robot) {
        // turn 180 deg back
        robot.turnLeft();
        robot.turnLeft();

        robot.move();

        // turn back the original direction
        robot.turnRight();
        robot.turnRight();
    }



    class RobotMock implements Robot {
    private int[][] room;
    private int row;
    private int col;
    private int direction;
    private Set<List<Integer>> visited = new HashSet<>();

    public RobotMock() {
        this.room = new int[][]{{0}};
        this.row = 0;
        this.col = 0;
        this.direction = 0;
    }

    public RobotMock(int[][] room) {
        this.room = room;
        this.row = 0;
        this.col = 0;
        this.direction = 0;
    }

    @Override
    public boolean move() {
        if (row >= 0 && row < room.length && col >= 0 && col < room[0].length && room[row][col] == 0) {
            switch (direction) {
                case 0: row--; break; // Move up
                case 1: col++; break; // Move right
                case 2: row++; break; // Move down
                case 3: col--; break; // Move left
            }
            return true;
        }
        return false;
    }

    @Override
    public void turnLeft() {
        direction = (direction + 3) % 4; // 90-degree turn to the left
    }

    @Override
    public void turnRight() {
        direction = (direction + 1) % 4; // 90-degree turn to the right
    }

    @Override
    public void clean() {
        visited.add(List.of(row, col));
    }

    public void printVisited() {
        for (List<Integer> cell : visited) {
            System.out.println("Visited cell: " + cell);
        }
    }
}


}

