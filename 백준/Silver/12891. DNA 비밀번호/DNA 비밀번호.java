import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
  /**
   * DNA 비밀번호 : 모든 문자열에 등장하는 문자가 "A C G T"인 문자열
   * ACKA : DNA 문자열 아님
   * ACCA : DNA 문자열
   * 
   * 임의의 DNA 문자열 -> DNA 문자열의 "부분문자열"을 비밀번호로 사용하자
   * 부분문자열 조건 : A C G T 가 각각 몇번 이상 등장해야함
   * 
   * ============ [INPUT] ============
   * "DNA 문자열" "부분문자열 길이"
   * A C G T
   * 
   * ============ [OUTPUT] ============
   * 민호가 만들 수 있는 비밀번호 종류의 수
   * @throws IOException 
   * */ 
  static int totalCount;
  static int S;
  static int P;
  static char[] alpha =  {'A', 'C', 'G', 'T'} ; 
  static char[] dna;
  static Map<Character,Integer> rule = new HashMap<>();
  static Map<Character,Integer> count = new HashMap<>(); // 초기화

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine());
    S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이(S)
    P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열 길이(P)
    
    dna = br.readLine().toCharArray(); // DNA 문자열
    st = new StringTokenizer(br.readLine());
    
  
    for(char c : alpha) {
      rule.put(c, Integer.parseInt(st.nextToken()));
    }
    count.put('A',0);
    count.put('C',0);
    count.put('G',0);
    count.put('T',0);
    
    for(int i=0;i<P;i++) {
      count.put(dna[i], count.getOrDefault(dna[i], 0)+1);
    }
   
    totalCount+=checkVaild();
   

    for(int i=0;i<S-P;i++) { // start idx
      count.put(dna[i], count.getOrDefault(dna[i], 0)-1);
      count.put(dna[i+P], count.getOrDefault(dna[i+P], 0)+1);
      totalCount+=checkVaild();

    }
    System.out.println(totalCount);
   
  }
  private static int checkVaild( ) {

    for(Character c : alpha) {
     if(count.get(c)<rule.get(c) ) {
       return 0;
     }
   }
    return 1;
  }


}