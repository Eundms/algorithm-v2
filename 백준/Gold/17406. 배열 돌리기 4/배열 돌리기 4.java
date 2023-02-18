import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * [ 배열 A의 값 = 각 행에 있는 모든 수의 합 중 최솟값 ]
     * <p>
     * (r-s, c-s)
     * (r  ,   c)
     * (r+s, c+s)
     **/
    static int N;
    static int M;

    static int[][] box;

    static int[][] kArray; // 회전 연산 정보
    static int[] kNumbers; // k개의 Number
    static boolean[] kVisited; // kArray에서 방문했는지
    static int K;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //배열 크기
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); //회전연산의 개수

        box = new int[N][M]; // 배열 A에 들어있는 수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        kArray = new int[K][3];

        for (int k = 0; k < K; k++) { // k개의 줄에 회전 연산의 정보 r,c,s
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 행
            int c = Integer.parseInt(st.nextToken()); // 열
            int s = Integer.parseInt(st.nextToken());
            kArray[k][0] = r;
            kArray[k][1] = c;
            kArray[k][2] = s;
        }

        // 순열
        kNumbers = new int[K]; //선택된 K개 (순서대로)
        kVisited = new boolean[K]; // k 방문여부
        permutation(0);
        System.out.println(res);
    }
    private static void permutation(int cnt){//K개 정렬
        if(cnt == K){
            int[][] rbox = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j = 0 ; j<M;j++){
                    rbox[i][j] = box[i][j];
                }
            }
            // 순열 대로 rotate 실행
            for(int i=0;i<K;i++){
                int r = kArray[kNumbers[i]][0];
                int c = kArray[kNumbers[i]][1];
                int s = kArray[kNumbers[i]][2];
                rbox = rotate(r,c,s,rbox);
            }
            // A배열의 값 구하기
            res = Math.min(res,aValue(rbox));
            return;
        }
        for(int i=0;i<K;i++){
            if(kVisited[i])continue;
            kVisited[i]=true;
            kNumbers[cnt] = i;
            permutation(cnt+1);
            kVisited[i]=false;


        }
    }

    public static int[][] rotate(int r, int c, int s, int[][] rbox) {
        // 범위:  (r-s ~ r+s, c-s ~ c+s)
        int[][]temp = new int[N][M];
        int[][] way = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0;i<N;i++){
            for(int j = 0 ; j<M;j++){
                temp[i][j] = rbox[i][j];
            }
        }
        for (int k = 0; k < s; k++) {
            int startx = r - s - 1 + k;
            int starty = c - s - 1 + k;
            for (int w = 0; w < 4; w++) { // 방향 전환
                while (true) {
                    int nextx = startx + way[w][0]; // nextx>=0
                    int nexty = starty + way[w][1];
                    if (nextx >= r - s - 1 + k && nextx <= r + s - 1 - k && nexty >= c - s - 1 + k && nexty <= c + s - 1 - k) {
                        temp[nextx][nexty] = rbox[startx][starty];
                        startx = nextx;
                        starty = nexty;
                    } else {
                        break;
                    }
                }
            }
        }
        return temp;
    }

    private static void print(int[][] box) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(box[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();
    }

    private static int aValue(int[][] rbox) {
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int rowSum = 0;
            for (int j = 0; j < M; j++) {
                rowSum += rbox[i][j];
            }
            minSum = Math.min(rowSum, minSum);
        }
        return minSum;
    }


}
