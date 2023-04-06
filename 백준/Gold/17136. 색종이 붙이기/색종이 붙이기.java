import java.io.*;
import java.util.StringTokenizer;

public class Main { //색종이...
    static int[][] box;
    static int minCnt = Integer.MAX_VALUE;
    static boolean isAllZero = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        box = new int[10][10];
        StringTokenizer st;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    isAllZero = false;
                }
            }
        }
        if (isAllZero) {
            System.out.println(0);
        } else {
            back(0, 0, 0);
            System.out.println(minCnt == Integer.MAX_VALUE ? -1 : minCnt);

        }
    }

    static int[] paper = {0, 5, 5, 5, 5, 5}; // 1: 5 , 2: 5... 5: 5

    private static void back(int x, int y, int cnt) { // 0 ~ 9 까지 사용
        if (x >= 9 && y >= 10) {
            minCnt = Math.min(cnt, minCnt);
            return;
        }
        if (y >= 10) { // 0 ~ 9까지 아래 로직을 수행해야하므로
            back(x + 1, 0, cnt);
            return;
        }

        if (box[x][y] == 0) {
            back(x, y + 1, cnt);
        } else { // box[x][y] == 1
            for (int size = 5; size >= 1; size--) { // size 5 4 3 2 1 차례대로 넣어보기
                if (paper[size] > 0 && isAttachAvailable(x, y, size)) {
                    attach(x, y, size, 0);
                    paper[size]--;

                    back(x, y + 1, cnt + 1);

                    attach(x, y, size, 1);
                    paper[size]++;
                }

            }
        }
    }

    private static boolean isAttachAvailable(int x, int y, int size) {
        for (int r = x; r < x + size; r++) {
            for (int c = y; c < y + size; c++) {
                if (r < 0 || r >= 10 || c < 0 || c >= 10) return false;
                if (box[r][c] == 0) return false;
            }
        }
        return true;
    }

    private static void attach(int x, int y, int size, int value) {
        for (int r = x; r < x + size; r++) {
            for (int c = y; c < y + size; c++) {
                box[r][c] = value;
            }
        }
    }

}
