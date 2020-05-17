import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description: 模拟行走机器人
 * @author: qpy
 */
public class RobotSim {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 0 北边  1 东 2 南  3 西
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direction = 0;
        int x = 0;
        int y = 0;
        int step = 0;
        int result = 0;
        Set<String> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add( obstacles[i][0] + "." + obstacles[i][1] );
        }

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                direction = (direction + 3) % 4;
            } else if (commands[i] == -1) {
                direction = (direction + 1) % 4;
            } else if (commands[i] > 0) {

                for (int j = 1; j <= commands[i]; j++) {
                    int xx = x + dir[direction][0];
                    int yy = y + dir[direction][1];
                    if (obstacleSet.contains( xx + "." + yy )) {
                        break;
                    }
                    x = x + dir[direction][0];
                    y = y + dir[direction][1];
                    result = Math.max( result, x * x + y * y );
                }
            }

        }
        return result;
    }
}
