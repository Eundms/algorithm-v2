import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int N;
    static int[][] box;
    static int houseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                box[i][j] = str.charAt(j) - '0';
            }
        }
        List<Integer> houseList = new ArrayList<>();
        int totalCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] == 1) {
                    houseCnt = 1;
                    totalCnt += 1;
                    dfs(i, j);
                    houseList.add(houseCnt);
                }
            }
        }
        System.out.println(totalCnt); // 총 단지수
        // 단지내 집의 수 오름차순 정렬
        Collections.sort(houseList);
        for (int h = 0; h < houseList.size(); h++) {
            System.out.println(houseList.get(h));
        }
    }

    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private static void dfs(int i, int j) {
        box[i][j] = 2;
        for (int w = 0; w < 4; w++) {
            int nx = i + way[w][0];
            int ny = j + way[w][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (box[nx][ny] == 1) {
                box[nx][ny] = 2;
                dfs(nx, ny);
                houseCnt++;
            }
        }
    }
}
