import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main { // 청소년 상어
    static int[][] box; // 물고기 번호(1 ~ ?)
    static int[][] way = {{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}}; //8
    static List<Fish> fishes;
    static int maxSum; // 물고기 idx => 최댓값 상어 먹음

    public static void main(String[] args) throws Exception {
        box = new int[4][4];
        fishes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken()); // 물고기 번호 1 ~ 16
                int b = Integer.parseInt(st.nextToken()) - 1; // 방향 - 8보다 작거나 같은 자연수
                fishes.add(new Fish(a, i, j, b, true));
                box[i][j] = a;
            }
        }
        Collections.sort(fishes);
        // 0,0 부터 시작
        Fish fish = fishes.get(box[0][0] - 1);
        Shark shark = new Shark(0, 0, fish.dir, fish.id); // fish 거리
        fish.isAlive = false;
        box[0][0] = -1; // shark위치 표시

        moveShark(box, shark, fishes);
        System.out.println(maxSum);

    }

    private static void printMatrix(int[][] box){
        for(int i = 0; i<4;i++){
            for(int j = 0; j<4;j++){
                System.out.print(box[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    private static void moveShark(int[][] box, Shark shark, List<Fish> fishes) {
        if (shark.sumFishNum > maxSum) { // 상어가 지금까지 먹은 물고기
            maxSum = shark.sumFishNum;
        }
        for (int i = 0; i < fishes.size(); i++) {
            moveFish(box, fishes, fishes.get(i)); // 물고기 움직임
        }

        // 상어 움직임
        for (int dist = 1; dist < 4; dist++) { // 속력
            int nx = shark.x + way[shark.dir][0] * dist;
            int ny = shark.y + way[shark.dir][1] * dist;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                continue;
            }
            if (box[nx][ny] > 0) { // 물고기 만난 경우
                int[][] copied = copyMatrix(box);
                List<Fish> copiedFish = copyFishes(fishes);

                copied[shark.x][shark.y] = 0;  // 기존 위치 상어 x 표시

                Fish killed = copiedFish.get(box[nx][ny] - 1); // 먹힌 물고기
                Shark newShark = new Shark(killed.x, killed.y, killed.dir, shark.sumFishNum + killed.id);
                killed.isAlive = false; // box[killed.x][killed.y] = 0
                copied[killed.x][killed.y] = -1; // 상어 위치 표시

                moveShark(copied, newShark, copiedFish);
            }
        }
    }

    private static void moveFish(int[][] box, List<Fish> fishes, Fish fish) { // fish 옮기기
        if (!fish.isAlive) { //이동하기 위한 fish
            return;
        }
        for (int i = 0; i < 8; i++) {
            int nextDir = (fish.dir + i) % 8;
            int nx = fish.x + way[nextDir][0]; // x: 행번호 y: 열번호
            int ny = fish.y + way[nextDir][1];

            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && box[nx][ny] > -1) { // 이동할 수 있는 경우
                box[fish.x][fish.y] = 0;

                if (box[nx][ny] == 0) {// 물고기 x , 상어 x => 비어있음
                    fish.x = nx;
                    fish.y = ny;

                } else { // 비어있지 않음
                    Fish target = fishes.get(box[nx][ny] - 1);
                    int tempX = target.x;
                    int tempY = target.y;
                    target.x = fish.x;
                    target.y = fish.y;

                    fish.x = tempX;
                    fish.y = tempY;

                    box[target.x][target.y] = target.id;
                }
                box[fish.x][fish.y] = fish.id;
                fish.dir = nextDir;
                return;
            }
        }

    }

    private static List<Fish> copyFishes(List<Fish> fishes) {
        List<Fish> copy = new ArrayList<>();
        fishes.forEach(e -> copy.add(new Fish(e.id, e.x, e.y,  e.dir, e.isAlive)));
        return copy;
    }

    private static int[][] copyMatrix(int[][] box) {
        int[][] copyed = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copyed[i][j] = box[i][j];
            }
        }
        return copyed;
    }


    static class Fish implements Comparable<Fish> {
        int id, x, y, dir;
        boolean isAlive;

        public Fish(int id, int x, int y, int dir, boolean isAlive) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isAlive = isAlive;
        }

        @Override
        public int compareTo(Fish o) {
            return this.id - o.id;
        }
    }

    static class Shark {
        int x, y, dir, sumFishNum;

        public Shark(int x, int y, int dir, int sumFishNum) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.sumFishNum = sumFishNum;
        }
    }

}