import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dosi; // 도시
    static boolean[][] visited; // 도시 방문 여부
    static List<int[]> chicken; // 치킨 가게
    static List<int[]> house; // 집
    static boolean[] cVisited; // 치킨집 선택 여부(총 true : M개)

    static int[][] choiceDosi;
    static int minChickenDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // N x N 도시
        M = Integer.parseInt(st.nextToken()); // 치킨집을 몇 개 살릴것인가

        chicken = new ArrayList<>();
        house = new ArrayList<>();
        dosi = new int[N][N];
        // N개의 줄 : 도시의 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                dosi[i][j] = Integer.parseInt(st.nextToken()); // 도시의 정보 0(빈칸) 1(집) 2(치킨집)
                if (dosi[i][j] == 2) { // 치킨집
                    chicken.add(new int[]{i, j});
                } else if (dosi[i][j] == 1) { // 집
                    house.add(new int[]{i, j});
                }
            }
        }

        // 폐업시킬 [chicken.size()-M]개의 치킨집을 뽑고,
        cVisited = new boolean[chicken.size()];
        selectMChicken(0, 0);
        System.out.println(minChickenDistance);

    }
    private static int[][] simulateDelChicken(){
       int[][] temp = new int[N][N];
       for(int i=0;i<N;i++){
           for(int j=0;j<N;j++){
                temp[i][j] = dosi[i][j];
           }
       }
       for(int i=0;i<chicken.size();i++){
           if(cVisited[i]){
               int[] loc = chicken.get(i);
               temp[loc[0]][loc[1]] = 0;
           }
       }
       return temp;
    }
    private static void selectMChicken(int cnt, int start) {
        if (cnt == chicken.size()-M) {
            int allDist = 0;// 해당 경우의 치킨 거리를 구한다.
            choiceDosi = simulateDelChicken();
            for (int[] hLoc : house) {
                visited = new boolean[N][N];
                allDist += bfs(hLoc[0], hLoc[1], 0);
            }
            minChickenDistance = Math.min(allDist,minChickenDistance); // 치킨 거리의 최솟값인지 확인하기
            return;
        }
        for(int i = start;i<chicken.size();i++){
            if(cVisited[i])continue;
            cVisited[i]=true;
            selectMChicken(cnt+1,i+1);
            cVisited[i] =false;

        }
    }

    private static int bfs(int i, int j, int cnt) { // 출발지는 집
        int[][] way = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, cnt});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int w = 0; w < 4; w++) {
                int nextX = now[0] + way[w][0];
                int nextY = now[1] + way[w][1];
                int nextCnt = now[2] + 1;
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (choiceDosi[nextX][nextY] == 2) { // 치킨 집 발견!!
                    return nextCnt;
                }
                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, nextCnt});
            }
        }
        return 0;
    }
}
