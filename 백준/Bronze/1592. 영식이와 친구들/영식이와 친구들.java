import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  /*
   * 공 M번 -> 게임 over
   * M번보다 적게 받은 사람 공 던짐
   *  https://www.acmicpc.net/problem/1592
   * (현재 공을 받은 횟수) 
   * 홀수번, 자기의 현재 위치에서 시계방향으로 L번째 있는 사람
   * 짝수번, 자기의 현재 위치에서 반시계방향으로 L번째 있는 사람
   * **/
  static int N,M,L;
  static int[] ballCnt;
  public static void main(String[] args) throws IOException {
   // System.setIn(new FileInputStream("src/excel/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 1 ~ N까지 적혀있는 자리
    M = Integer.parseInt(st.nextToken()); // 공을 M번 받음 -> 게임 종료
    L = Integer.parseInt(st.nextToken()); // 시계 방향으로 L번째
    
    ballCnt = new int[N]; // 1 ~ N 
    ballCnt[0]=1;
    int idx=0;
    int cnt = 0;
    // 첫째 줄에 공을 몇 번 던지는지
    while(true) {
      if(checkTerminate()) { // 공 던지는 것 체크
        break;
      }
      // 1 ~ N 까지 적혀있는 자리 
      // (공 받은 횟수)
      // 홀수번 -> L번째 있는 사람
      // 짝수번 반시계 -> L번째 있는 사람
      if(ballCnt[idx]%2==0) {
        idx = (idx + N - L ) % N;
      }else {
        idx = (idx + L) % N;
      }
      cnt+=1;
      ballCnt[idx]+=1;
      
    }
    System.out.println(cnt);
    

  }
  private static boolean checkTerminate() {
    for(int i=0;i<N;i++) {
      if(ballCnt[i]==M) {
        return true;
      }
    }
    return false;
  }

}
