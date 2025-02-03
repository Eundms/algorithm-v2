import java.util.*;
class Solution {
    static Map<Character, int[]> direction = new HashMap<>();
    static boolean[][][] visited;
    public int solution(String dirs) {
        init();
        int answer = 0;
        // 처음 걸어본 길의 길이 
        // (i,j)에서 w방향 
        int x = 5, y = 5; // 양수 
        for(char d : dirs.toCharArray()) {
            int[] dir = direction.get(d);
           
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx < 0 || nx >= 11 || ny < 0 || ny >= 11) continue;
            // x,y에서 d방향 nx, ny에서 -d방향
            if(!visited[x][y][dir[2]] || !visited[nx][ny][(dir[2]+2)%4]){
                visited[x][y][dir[2]] = true;
                visited[nx][ny][(dir[2]+2)%4] = true;
                answer += 1;
            }
            x = nx;
            y = ny;
        }
        return answer;
    }
    void init() {
        direction.put('U', new int[]{0,1, 0});
        direction.put('L', new int[]{-1,0, 1});
        direction.put('D', new int[]{0,-1 , 2});
        direction.put('R', new int[]{1,0, 3}); 
        visited = new boolean[11][11][4];// 0, 0 부터 10 ,10 
    }
}