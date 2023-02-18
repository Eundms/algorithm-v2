import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main { //숫자판 점프
    static int[][] box;
    static int[][] way = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    static int[] numbers;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        box = new int[5][5];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        set= new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                numbers = new int[6];
                numbers[0] = box[i][j];
                dfs(i, j, 1);
            }
        }
        System.out.println(set.size());

    }

    private static void dfs(int i, int j, int cnt) { // i행 j열
        if(cnt==6){
            set.add(""+numbers[0]+numbers[1]+numbers[2]+numbers[3]+numbers[4]+numbers[5]);
            return ;
        }
        for (int w = 0; w < 4; w++) {
            int nextX = i + way[w][0];
            int nextY = j + way[w][1];
            if (nextX < 0 || nextX >= 5 || nextY < 0 || nextY >= 5) {
                continue;
            }
            numbers[cnt] = box[nextX][nextY];
            dfs(nextX, nextY, cnt + 1);
        }

    }
}
