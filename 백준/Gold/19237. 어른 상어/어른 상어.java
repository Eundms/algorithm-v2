import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static Priority[] pri; // 상어마다 관리하기 위해 배열 만듦
    static Shark[] sharks;
    static int[][] smell, smellOrigin; // 냄새지속시간, 해당 냄새를 뿌린 상어
    static int[][] way = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 위, 아래, 왼쪽, 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자 모습
        M = Integer.parseInt(st.nextToken()); // 상어의 수
        K = Integer.parseInt(st.nextToken()); // 냄새 지속 시간

        sharks = new Shark[M + 1]; // 1~M
        smell = new int[N][N];
        smellOrigin = new int[N][N];

        //
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int sharkNo = Integer.parseInt(st.nextToken()); // 1 ~ M 번을 가지는 상어
                if (sharkNo > 0) {
                    sharks[sharkNo] = new Shark(i, j, true); // 상어 번호, x좌표, y좌표, 상어방향
                    smellOrigin[i][j] = sharkNo;
                    smell[i][j] = K;
                }
            }
        }

        // way[w][0] way[w][1]
        // 1위 2아래 3왼쪽 4오른쪽
        st = new StringTokenizer(br.readLine());
        for (int m = 1; m < M + 1; m++) {
            sharks[m].dir = Integer.parseInt(st.nextToken()) -1;
        }

        // 상어의 방향 우선순위 - 상어 당 4줄씩
        pri = new Priority[M + 1]; // 1 ~ M 번 상어의 우선순위를 알기 위한 클래스
        for (int i = 0; i < M + 1; i++) {
            pri[i] = new Priority();
        }
        for (int m = 1; m <= M; m++) { // 각 상어의
            Map<Integer, int[]> sharkPri = new HashMap<>();
            // 방향
            for (int i = 0; i < 4; i++) { // 0: 위, 1: 아래, 2: 왼쪽, 3:오른쪽
                int[] wPri = new int[4];
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    wPri[j] = Integer.parseInt(st.nextToken()) - 1;
                }
                sharkPri.put(i, wPri);
            }
            pri[m].item = sharkPri;

        }

        // 1000초 -> -1
        // base case : 1번 상어가 격자에 남을 때까지
        int time = 0;
        while (time <= 1000) {
            time++;
            //printSharks();

            // [2] 1 ~ M번까지 iteration
            for (int sNo = 1; sNo <= M; sNo++) {
                moveOneShark(sNo);
            }
            // [1] smell N x N
            minusSmell();
            killDuplicate();

            for (int sNo = 1; sNo <= M; sNo++) {
                updateSmell(sNo);
            }


            if (allDeadExceptOne()) {
                break;
            }
        }
        if (time == 1001) {
            System.out.println(-1);
        } else {
            System.out.println(time);
        }
    }
    private static void updateSmell(int sharkNo){
        Shark curShark = sharks[sharkNo];
        if(curShark.isAlive) {
            // 냄새 업데이트 (냄새 추가만 업데이트)
            smell[curShark.x][curShark.y] = K;
            smellOrigin[curShark.x][curShark.y] = sharkNo;
        }
    }
    private static void printSharks(){
        System.out.println("<<");
        for(int i = 1; i<sharks.length;i++){
            System.out.println(sharks[i]);
        }
        System.out.println("---");
        printSmell();
        System.out.println(">>");
    }
    private static void printSmell(){
        for(int i = 0; i<N;i++){
            for(int j = 0; j<N;j++){
                System.out.print(smell[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void killDuplicate() {
        for (int idx = 1; idx <= M; idx++) {
            if (!sharks[idx].isAlive) {
                continue;
            }
            Shark cur = sharks[idx];

            for (int next = idx + 1; next <= M; next++) {
                Shark comp = sharks[next];
                if (cur.x == comp.x && cur.y == comp.y) {
                    comp.isAlive = false;
                }
            }
        }
    }

    // 1
    private static boolean allDeadExceptOne() {
        for (int i = 2; i < sharks.length; i++) {
            if (sharks[i].isAlive) { // 죽은 상어 cnt
                return false;
            }
        }
        return true;
    }

    private static void moveOneShark(int sharkNo) { // shark 한 동작
        // shark가 없는 경우..!
        Shark curShark = sharks[sharkNo];
        if (!curShark.isAlive) {
            return;
        }
        // 상어가 갈 수 있는지 체크
        // 1. 상하좌우 확인 -> 아무 냄새  x 칸
        if (checkBasicWay(curShark.x, curShark.y)) {
            int[] w = pri[sharkNo].getPriority(curShark.dir);
            for (int i = 0; i < 4; i++) { // 상하좌우를 확인해서
                int nx = curShark.x + way[w[i]][0];
                int ny = curShark.y + way[w[i]][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (smell[nx][ny] == 0) { // 냄새가 없다면, 이곳으로 이동
                    // 상어가 이동했을 때 무엇을 업데이트 해야 하는가?
                    // 1. 현재 상어 위치 = 가려고 하는 곳으로 업데이트
                    curShark.x = nx;
                    curShark.y = ny;
                    curShark.dir = w[i];
                    break;
                }
            }
        } else {
            // 2. 자신의 냄새가 있는 칸
            //   1) pri[sharkNo].getPriority(curWIdx)
            // 자신의 냄새가 있는 칸
            int[] w = pri[sharkNo].getPriority(curShark.dir);
            for (int i = 0; i < 4; i++) { // 상하좌우를 확인해서
                int nx = curShark.x + way[w[i]][0];
                int ny = curShark.y + way[w[i]][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                if (smellOrigin[nx][ny] == sharkNo) { // 자신의 냄새라면,
                    // 그 위치로 옮긴다.
                    curShark.x = nx;
                    curShark.y = ny;
                    curShark.dir = w[i];
                    break;
                }
            }
        }



    }

    private static boolean checkBasicWay(int x, int y) {
        for (int w = 0; w < 4; w++) {
            int nx = x + way[w][0];
            int ny = y + way[w][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (smell[nx][ny] == 0) { // 냄새가 없다면, true
                return true;
            }
        }
        return false;
    }

    private static void minusSmell() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smell[i][j] > 0) { // smell 이 남아있으면..!
                    smell[i][j] -= 1;
                    if (smell[i][j] == 0) { // 냄새 x
                        smellOrigin[i][j] = 0; // shark x
                    }
                }

            }
        }
    }

    static class Shark {
        int x, y, dir;
        boolean isAlive;

        public Shark(int x, int y, boolean isAlive) {
            this.x = x;
            this.y = y;
            this.isAlive = isAlive;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", isAlive=" + isAlive +
                    '}';
        }
    }

    static class Priority { //상어번호 sNum;
        Map<Integer, int[]> item; // 0 : { 1, 2, 0, }, 1 : {}

        public Priority() {
        }

        int[] getPriority(int curWIdx) { // 현재 방향을 input으로 받아서
            return item.get(curWIdx); // 우선순위 리스트를 리턴
        }
    }
}
