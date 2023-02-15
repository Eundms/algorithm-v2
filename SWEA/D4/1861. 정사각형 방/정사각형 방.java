import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution { // 정사각형방
    static int[][] box;
    static boolean[][] visited;
    static int maxCnt;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수 T
        for (int test = 1; test <= T; test++) {
            maxCnt = 0;
            start = Integer.MAX_VALUE;
            int N = Integer.parseInt(br.readLine()); // 하나의 정수 N
            box = new int[N][N]; // N개의 정수 Ai, 1, … , Ai, N (1 ≤ Ai, j ≤ N2) 이 공백 하나로 구분되어 주어짐
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 각 시작 점에 대해서 dfs 진행
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N]; //방문 여부 체크
                    int move = dfs(i, j);
                    if(maxCnt<move){
                        maxCnt = move;
                        start = box[i][j];
                    }else if(move!=0 && maxCnt==move){
                        if(box[i][j]<start){
                            start = box[i][j];
                        }
                    }
                }
            }

            System.out.println("#"+test+" "+start+" "+maxCnt);
        }
    }

    private static int dfs(int start, int end) {
        int[][] way = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int move = 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, end,1}); // 스택에 시작값 넣음
        visited[start][end] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();

            for (int w = 0; w < 4; w++) {
                int nextX = current[0] + way[w][0];
                int nextY = current[1] + way[w][1];
                if (nextY < 0 || nextY >= visited[0].length
                        || nextX < 0 || nextX >= visited.length) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (box[nextX][nextY] - box[current[0]][current[1]] != 1) {
                    continue;
                }
                visited[nextX][nextY] = true;
                stack.push(new int[]{nextX, nextY});
                move++;
            }

        }
        return move;
    }


}
