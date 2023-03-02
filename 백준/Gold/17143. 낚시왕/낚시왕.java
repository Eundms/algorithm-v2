import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C, M; //격자판크기, 상어의 수
    static List<Shark> sharkList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 상어의 수
        if(M==0){
            System.out.println(0);
            return;
        }
        // r c 상어위치 s속력 d이동방향 z크기
        // 1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽
        sharkList = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 행
            int c = Integer.parseInt(st.nextToken()); // 열
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 이동방향
            int z = Integer.parseInt(st.nextToken()); // 크기
            sharkList.add(new Shark(r, c, s, d, z)); // 상어
        }
        //System.out.println("======== START =========");

        int sharkSize = 0;
        for (int i = 1; i <= C; i++) { // 1. 낚시왕 이동
            Collections.sort(sharkList); // 상어  Sort
            // 2. 열에 있는 상어중, 가장 가까운 상어 잡기. 상어 잡으면, 격자판에서 잡은 상어가 사라짐
            sharkSize += catchShark(i);
            //System.out.println("======== CATCH =========");
            //System.out.println(sharkList.toString());
            // 3. 상어 이동
            moveShark();
            Collections.sort(sharkList); // 상어  Sort
            //System.out.println("======== MOVE =========");
            //System.out.println(sharkList.toString());
            // 4. 상어 먹힘
            if(sharkList.size()>0){
                eatShark();
            }
        }
        System.out.println(sharkSize);
    }

    static int[][] way = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static void eatShark() {
        int prevI = 0;
        int prevX = sharkList.get(prevI).r;
        int prevY = sharkList.get(prevI).c;
        for (int m = 1; m < sharkList.size(); m++) {
            Shark shark = sharkList.get(m);
            int x = shark.r; // 1~R
            int y = shark.c; // 1~C
            if (prevX == x && prevY == y) {
                if (sharkList.get(prevI).z > shark.z) {
                    sharkList.remove(m);
                } else {
                    sharkList.remove(prevI);
                }
                m--;
            }
            prevI = m ;
            prevX = sharkList.get(prevI).r;
            prevY = sharkList.get(prevI).c;
        }
    }

    private static void moveShark() {
        for (int m = 0; m < sharkList.size(); m++) {
            Shark shark = sharkList.get(m);
            int x = shark.r; // 1~R
            int y = shark.c; // 1~C
            int dx = way[shark.d - 1][0];
            int dy = way[shark.d - 1][1];
            int count = shark.s;
            //System.out.println("before -> "+shark);
            while (count > 0) {
                int nextX = x + dx;
                int nextY = y + dy;
                if (nextX < 1 || nextX >= R + 1 || nextY < 1 || nextY >= C + 1) {
                    dx = 0 - dx; //방향 반대로 전환
                    dy = 0 - dy;
                } else {
                    count--;
                    x = nextX;
                    y = nextY;
                }
                //System.out.println(count+" "+x+","+y);
            }
            shark.r = x;
            shark.c = y;
            for (int w = 0; w < 4; w++) {
                if (way[w][0] == dx && way[w][1] == dy) {
                    shark.d = w + 1;
                    break;
                }
            }
            //System.out.println("after -> "+shark);

        }
    }

    private static int catchShark(int catcherCol) {
        for (int m = 0; m < sharkList.size(); m++) {
            Shark shark = sharkList.get(m);
            if (shark.c == catcherCol) {
               // System.out.println("catch: "+shark);
                sharkList.remove(m);
                return shark.z;
            }
        }
        return 0;
    }


    static class Shark implements Comparable<Shark> {
        int r, c; // 위치
        int s; // 속력
        int d; // 이동방향
        int z; // 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.r - o.r == 0) { // y: 같다면,  x: 오름차순 정렬
                return this.c - o.c;
            }
            return this.r - o.r; // y: 오름차순 정렬, x: 오름차순 정렬
        }

        @Override
        public String toString() {
            return "{" +
                    "(" + r +
                    ", " + c +
                    ") , s=" + s +
                    ", d=" + d +
                    ", z=" + z +
                    '}';
        }
    }
}
