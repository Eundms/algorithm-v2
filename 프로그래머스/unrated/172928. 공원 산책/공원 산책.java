import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        Map<String,int[]> way = new HashMap<>();
        way.put("N",new int[]{-1,0});
        way.put("S",new int[]{1,0});
        way.put("W",new int[]{0,-1});
        way.put("E",new int[]{0,1});
        
        int N = park.length;
        int M = park[0].length();

        char[][] box = new char[N][M];
        // S : 시작 지점, O : 이동 가능한 통로, X : 장애물
        // 현재 위치에서 동쪽으로 5칸 이동
        int sx = 0, sy = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                box[i][j] = park[i].charAt(j);
                if(box[i][j] == 'S'){
                    sx = i;
                    sy = j;
                    box[i][j] = 'O';
                }
            }
        }
        for(int r = 0; r < routes.length; r++){
            String op = routes[r].split(" ")[0]; // 이동할 방향
            int n = Integer.parseInt(routes[r].split(" ")[1]); // 이동 칸 수
            
            
            int[] d = way.get(op);
            int nx = sx, ny = sy ;
            boolean isValid = true;
            for(int step = 1; step <= n ; step++){
                nx = sx + d[0] * step; // 시작x + 방향dx
                ny = sy + d[1] * step; // 시작y + 방향dy
                if(nx<0 || nx>=N || ny<0 || ny>=M || box[nx][ny]=='X') {
                    isValid= false;
                    break;
                }
            }
            
            if(isValid==true && box[nx][ny]=='O'){
                sx = nx;
                sy = ny;
            }
        }
        // 1. 공원 벗어나는가
        // 2. 장애물을 만나는가
        
        return new int[]{sx,sy};
    }
    static void print(char[][]box, int N, int M){
        for(int i = 0; i< N ; i ++){
            for(int j = 0; j< M ; j++){
                System.out.print(box[i][j]+" ");
            }
            System.out.println();
        }
    }
}