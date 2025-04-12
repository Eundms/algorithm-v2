import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1]; // 0~y 까지

        queue.add(new int[]{y, 0});
        visited[y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int count = current[1];

            if (value == x) return count;

            if (value % 2 == 0 && !visited[value / 2]) {
                visited[value / 2] = true;
                queue.add(new int[]{value / 2, count + 1});
            }

            if (value % 3 == 0 && !visited[value / 3]) {
                visited[value / 3] = true;
                queue.add(new int[]{value / 3, count + 1});
            }

            if (value - n >= x && !visited[value - n]) {
                visited[value - n] = true;
                queue.add(new int[]{value - n, count + 1});
            }
        }

        return -1;
    }
}
