import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution { //D3 상호의 배틀필드
    static int H, W;
    static char[][] box; // 게임 맵
    static int N;
    static int x, y; // 전차 위치
    static int dx, dy; // 전차 이동 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            box = new char[H][W]; // 게임 맵
            for (int h = 0; h < H; h++) { // H x W 크기의 격자판
                String str = br.readLine();
                for (int w = 0; w < W; w++) {
                    box[h][w] = str.charAt(w);
                    if (box[h][w] == '^') {
                        dx = -1;
                        dy = 0;
                        x = h;
                        y = w;
                    } else if (box[h][w] == 'v') {
                        dx = 1;
                        dy = 0;
                        x = h;
                        y = w;
                    } else if (box[h][w] == '<') {
                        dx = 0;
                        dy = -1;
                        x = h;
                        y = w;
                    } else if (box[h][w] == '>') {
                        dx = 0;
                        dy = 1;
                        x = h;
                        y = w;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());// 사용자가 넣을 입력의 개수
            String str = br.readLine();
            for (int i = 0; i < N; i++) { // 시뮬레이션 진행
                char command = str.charAt(i);
                if (command == 'S') {
                    shoot();
                } else {
                    turn(command);
                    move();
                }
            }

            // 결과 출력
            System.out.print("#" + t + " ");
            printMap();
        }
    }
    private static void printMap(){
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                System.out.print(box[h][w]);
            }
            System.out.println();
        }
    }
    private static void shoot() {
        /**
         * 벽돌벽 -> 평지, 포탄 소멸
         * 강철벽, 게임 맵 밖 -> 아무일 x
         * */
        int pX=x,pY=y; // 포탄 초기 위치
        while (true) {
            int nextX = pX + dx;
            int nextY = pY + dy;
            if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) {
                break;
            }
            if(box[nextX][nextY]=='*'){ // 벽돌로 만든 벽에 부딪힌다면,
                box[nextX][nextY]='.'; // 평지화
                break; // 포탄 소멸
            }else if(box[nextX][nextY]=='#'){ //강철로 만든 벾에 부딪힌다면,
                break;
            }
            pX = nextX;
            pY = nextY;
        }

    }

    private static void turn(char direction) { // 전차 이동할 방향 변경
        if (direction == 'U') {
            dx = -1;
            dy = 0;
            box[x][y] = '^';
        } else if (direction == 'D') {
            dx = 1;
            dy = 0;
            box[x][y] = 'v';
        } else if (direction == 'L') {
            dx = 0;
            dy = -1;
            box[x][y] = '<';
        } else { // R
            dx = 0;
            dy = 1;
            box[x][y] = '>';
        }
    }

    private static void move() {
        int nextX = x + dx;
        int nextY = y + dy;
        if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) {
            return;
        }
        if (box[nextX][nextY] != '.') { //평지가 아니라면 이동 불가
            return;
        }
        char carDirection = box[x][y];
        box[x][y] = '.'; // 전차 없앰
        x = nextX;
        y = nextY;
        box[x][y] = carDirection;
    }
}
