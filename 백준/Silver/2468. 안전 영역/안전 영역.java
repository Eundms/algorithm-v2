import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /**
   * 물에 잠기지 않는 안전한 영역 비의 양 - 내가 정해서 안전한 영역의 최대 개수 구하기
   **/
  static int N;
  static int[][] box;
  static int maxRain;
  static int minRain;
  static boolean[][] visited;
  public static void main(String[] args) throws IOException {// 안전 영역
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 행과 열의 개수를 나타내는 수

    box = new int[N][N];
    maxRain = Integer.MIN_VALUE;
    minRain = Integer.MAX_VALUE;

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        box[i][j] = Integer.parseInt(st.nextToken());
        maxRain = Math.max(maxRain, box[i][j]);
        minRain = Math.min(minRain, box[i][j]);
      }
    }
    
    int result = 0;
    // 아무지역도 물에 잠기지 않을 수도 있다.
    // box에서 최소값, 최댓값 사이
    for (int rain = minRain; rain < maxRain; rain++) {
      visited = new boolean[N][N];
      int count=0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if(dfs(rain, i, j)) {// 현재 위치에서
            count+=1;
          }
        }
      }
      result = Math.max(result, count);
    }
    if(minRain==maxRain) {
      result = 1;
    }
    System.out.println(result);

  }

  private static boolean dfs( int rain, int i, int j) {
   
    if (i < 0 || i >= N || j < 0 || j >= N) {
      return false;
    }
    if(box[i][j]<=rain) {
      return false;
    }
    if(!visited[i][j]) {
      visited[i][j] = true;
      dfs(rain,i+1,j);
      dfs(rain,i-1,j);
      dfs(rain,i,j+1);
      dfs(rain,i,j-1);
      return true;
    }
    return false;
  }

}
