import java.util.*;
class Solution {
    static int N, M;
    static int[][] box;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        N = rows;
        M = columns;
        box = new int[rows][columns];
        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= columns; j++) {
                box[i-1][j-1] = (i-1) * columns + j;
            }
        }
        
        int[][] way = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int q = 0; q < queries.length; q++) {
            int x1 = queries[q][0] - 1;
            int y1 = queries[q][1] - 1;
            int x2 = queries[q][2] - 1;
            int y2 = queries[q][3] - 1;
            
            List<Integer> rotated = new ArrayList<>();
            int temp = box[x1][y1];
            int x = x1, y= y1;
            for(int w = 0; w < 4; w++) { 
                while(true) {
                    int nx = x + way[w][0], ny = y + way[w][1];
                    if(!inRange(nx, ny, x1, y1, x2, y2)){
                        break;
                    }
                    box[x][y] = box[nx][ny];           
                    x = nx; 
                    y = ny;
                    rotated.add(box[nx][ny]);
                }
            }
            box[x1][y1+1] = temp;
            rotated.add(temp);
            
            Collections.sort(rotated);
            answer[q] = rotated.get(0);
        }
        return answer;
    }
    
    static boolean inRange(int x, int y, int sx, int sy, int ex, int ey) {
        return sx <= x && x <= ex && sy <= y && y <= ey;
    }
    
    static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}