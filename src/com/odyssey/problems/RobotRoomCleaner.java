package com.odyssey.problems;

import com.odyssey.datacontract.Robot;
import com.odyssey.interfaces.IProblem;

import java.util.HashMap;
import java.util.Map;

public class RobotRoomCleaner implements IProblem {
    @Override
    public void init() {

    }

    @Override
    public void solve() {

    }

    private Direction curDir = Direction.UP;
    private int x = 0;
    private int y = 0;
    private Map<Integer, Map<Integer, Boolean>> mem = new HashMap<>();

    public void cleanRoom(Robot robot) {
        boolean visited = mem.getOrDefault(x, new HashMap<>()).getOrDefault(y, false);
        if (visited) {
            // retreat to previous cell
            robot.turnRight();
            moveNextDir();
            robot.turnRight();
            moveNextDir();
            robot.move();
            movePos(curDir);
            // adjust dir
            robot.turnLeft();
            movePrevDir();
            return;
        }

        // add position
        Map<Integer, Boolean> yToStatus = mem.get(x);
        if (yToStatus == null) {
            yToStatus = new HashMap<>();
        }
        yToStatus.put(y, true);
        mem.put(x, yToStatus);

        // clean
        robot.clean();

        // move or turn
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                movePos(curDir);
                cleanRoom(robot);
            } else {
                robot.turnRight();
                moveNextDir();
            }
        }
        // retreat to previous cell
        robot.turnRight();
        moveNextDir();
        robot.turnRight();
        moveNextDir();
        robot.move();
        movePos(curDir);
        // adjust dir
        robot.turnLeft();
        movePrevDir();
    }

    private void movePos(Direction curDir) {
        switch (curDir) {
            case UP: {
                y++;
                break;
            }
            case RIGHT: {
                x++;
                break;
            }
            case DOWN: {
                y--;
                break;
            }
            case LEFT: {
                x--;
                break;
            }
        }
    }

    public void moveNextDir() {
        switch (curDir) {
            case UP: {
                curDir = Direction.RIGHT;
                break;
            }
            case RIGHT: {
                curDir =  Direction.DOWN;
                break;
            }
            case DOWN: {
                curDir =  Direction.LEFT;
                break;
            }
            case LEFT: {
                curDir =  Direction.UP;
                break;
            }
        }
    }

    public void movePrevDir() {
        switch (curDir) {
            case UP: {
                curDir = Direction.LEFT;
                break;
            }
            case RIGHT: {
                curDir =  Direction.UP;
                break;
            }
            case DOWN: {
                curDir =  Direction.RIGHT;
                break;
            }
            case LEFT: {
                curDir =  Direction.DOWN;
                break;
            }
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

}
