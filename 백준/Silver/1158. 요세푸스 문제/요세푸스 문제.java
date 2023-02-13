
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st  = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());// 1번 ~ N번 
    int K = Integer.parseInt(st.nextToken()); // 양의 정수 K
    
    Queue<Integer> list = new LinkedList<>();
    for(int i=1;i<=N;i++) {
      list.add(i);
    }

    List<Integer> arr = new ArrayList<>();
    int cnt=0;
    while(!list.isEmpty()) {// 순서대로 K제거
      for(int i=0;i<K-1;i++) {
        int x = list.poll(); 
        list.add(x);
      }
      arr.add(list.poll());
    }

    System.out.print("<");
    for(int i=0;i<arr.size();i++) {
      
      System.out.print(arr.get(i));
      if(i!=arr.size()-1) {
        System.out.print(", ");
      }
     
    }
    System.out.print(">");
    
    
  }

}
