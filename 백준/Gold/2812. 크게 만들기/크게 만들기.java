import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
  private static Stack<Character> stack;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // n자리 숫자
    int K = Integer.parseInt(st.nextToken()); // k개 지우기
    String number = br.readLine();

    stack = new Stack<>();
    // k개를 지웠을 때...
    // 자신보다 큰 수가 뒤에 있으면 지운다.
    int delCount = 0;
    for (int i = 0; i < N; i++) {
      
      char current = number.charAt(i); // 현재값
      
      //System.out.println(stack.toString());
      
      if (stack.isEmpty()) { // 스택이 비어있다면,
        stack.add(current); // 일단 넣기
      } else {
        if (stack.peek() < current) {// 스택 맨 위 값보다 작다면 일단 넣어 (뒤에 어쩔지 모름)
          while (true) {
            if (stack.isEmpty() || stack.peek() >= current || delCount == K) {// 스택 맨 위 값이 현재값보다 클때까지 pop
              break;
            }
            stack.pop();
            delCount += 1;
          }
        }
        stack.add(current);
      }
      
    }
    
    while(delCount<K) {
      stack.pop();
      delCount++;
    }
    for(int i=0;i<stack.size();i++) {
      System.out.print(stack.get(i));
    }
    System.out.println();
    


  }

}
