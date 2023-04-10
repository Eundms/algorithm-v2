import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {// 봄버맨2
    static int R, C, N;
    static char[][] box;
    static char BOMB = 'O', EMPTY = '.';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken()); // N초가 지난 후의 격자판 상태

        box = new char[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                box[r][c] = str.charAt(c); // 0초 : 초기 폭탄 설치
            }
        }
        // 2초 : 폭탄 설치
        // 3초 : (0: time-3)초에 설치된 폭탄 폭발
        StringBuilder sb = new StringBuilder();
        int time = N;    // 1초 : (휴식)
        if (time == 1) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(box[i][j] );
                }
                sb.append("\n");
            }
        } else if (time % 2 == 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(BOMB);
                }
                sb.append("\n");
            }
        } else {
           if(time%4==3){
               char[][] temp = new char[R][C];
               for (int i = 0; i < R; i++) {
                   for (int j = 0; j < C; j++) {
                       if (box[i][j] == BOMB) {// 현재 bomb이라면
                           temp[i][j] = EMPTY;
                           for (int w = 0; w < 4; w++) {
                               int nx = i + way[w][0];
                               int ny = j + way[w][1];
                               if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                                   continue;
                               }
                               temp[nx][ny] = EMPTY;
                           }
                       }

                   }
               }

               for (int i = 0; i < R; i++) {
                   for (int j = 0; j < C; j++) {
                       if (temp[i][j] != EMPTY) {
                           temp[i][j] = BOMB;
                       }
                   }
               }
               box = copy(temp);

           }
           else if(N%4==1) {
               for (int t = 1; t <= 2; t++) {
                   char[][] temp = new char[R][C];
                   for (int i = 0; i < R; i++) {
                       for (int j = 0; j < C; j++) {
                           if (box[i][j] == BOMB) {// 현재 bomb이라면
                               temp[i][j] = EMPTY;
                               for (int w = 0; w < 4; w++) {
                                   int nx = i + way[w][0];
                                   int ny = j + way[w][1];
                                   if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                                       continue;
                                   }
                                   temp[nx][ny] = EMPTY;
                               }
                           }

                       }
                   }

                   for (int i = 0; i < R; i++) {
                       for (int j = 0; j < C; j++) {
                           if (temp[i][j] != EMPTY) {
                               temp[i][j] = BOMB;
                           }
                       }
                   }
                   box = copy(temp);
               }
           }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sb.append(box[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
        // 4초 : 폭탄 설치
        // 5초 : (2: time-3)초에 설치된 폭탄 폭발
    }


    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    private static char[][] copy(char[][] box) {
        char[][] temp = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = box[i][j];
            }
        }
        return temp;
    }

    private static void printBox(char[][] box) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(box[i][j] + "");
            }
            System.out.println();
        }
    }

    static class Node {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", time=" + time +
                    '}';
        }
    }
}
