/**
 * @program: algorithm
 * @description:
 * @author: qpy
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] charArray = new int[26];
        for (char task : tasks) {
            charArray[task - 'A']++;
        }

        int max = 0, count = 0;
        for (int i : charArray) {
            if (max == i) {
                count++;
            } else if (i > max) {
                count = 1;
            }
            max = Math.max( max, i );
        }
        return Math.max( (n + 1) * (max - 1) + count, tasks.length );
    }
}
