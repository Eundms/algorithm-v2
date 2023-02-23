import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 알파벳
    static int R, C; // 표 모양의 보드
    static char[][] board;
    static boolean[][] visited;
    static boolean[] alphaVisited; // 알바벳을 사용했는지
    static int maxCnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for (int r = 0; r < R; r++) { // R개의 줄
            String line = br.readLine();
            for (int c = 0; c < C; c++) { // C개의 대문자 알파벳
                board[r][c] = line.charAt(c);
            }
        }

        visited = new boolean[R][C];
        alphaVisited = new boolean[26];// - 'A'


        //visited[0][0] = true;
        //alphaVisited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(maxCnt);
    }

    static int[][] way = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static void dfs(int i, int j, int cnt) {
        //System.out.println(board[i][j]+" ("+ i+","+j + ")  "+cnt);
        alphaVisited[board[i][j] - 'A'] = true;
        for (int w = 0; w < 4; w++) { // 현재 위치와 상하좌우 확인
            int nextX = i + way[w][0];
            int nextY = j + way[w][1];
            if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            if (alphaVisited[board[nextX][nextY] - 'A']) { // 깊이 그만 가야 함
                maxCnt = Math.max(maxCnt, cnt);
                continue;
            }

           
            dfs(nextX, nextY, cnt + 1);
            maxCnt = Math.max(maxCnt, cnt);
            alphaVisited[board[nextX][nextY] - 'A'] = false;

        }

    }
}
