
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  static int N; // 탑의 수
  static int[] height; // N개 탑들의 높이

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    height = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int n = 0; n < N; n++) {
      height[n] = Integer.parseInt(st.nextToken());
    }
    
    Stack<Integer>stack = new Stack<>();//인덱스 번호를 넣는다.
    for(int start = 0 ; start < N ; start ++) {
      if(stack.isEmpty()) { // 스택이 비어있다면,
        stack.push(start); // 스택에 이번 index값을 넣는다. 
      }
      
      //스택의 최상단값
      int top = height[stack.peek()] ;
      // 현재 위치 값
      int now = height[start];

      if(top>now) {//스택의 최상단값이 현재 위치의 값보다 크다면, 
        System.out.println(stack.peek()+1);
        stack.push(start);//현재위치
      }else {//나보다 큰 값을 찾아야 함
        while(true) {
          if(stack.isEmpty() || height[stack.peek()]>now) {
            break;
          }
          stack.pop();
        }
        if(stack.isEmpty()) {
          System.out.println(0);
        }else {
          System.out.println(stack.peek()+1);
        }
        stack.add(start);
      }
      
    }


  }

}
