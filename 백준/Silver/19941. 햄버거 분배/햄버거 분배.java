import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {//햄버거 분배
    static int N;
    static int K;
    static char[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 식탁의 길이
        K = Integer.parseInt(st.nextToken()); // 햄버거를 선택할 수 있는 거리
        array = new char[N]; // 사람과 햄버거의 위치
        String temp = br.readLine();
        for (int n = 0; n < N; n++) {
            array[n] = temp.charAt(n);
        }
        int count=0;
        for(int i=0;i<N;i++){
            if(array[i]=='P'){
                for(int j = i-K;j<=i+K;j++){
                    if(j<0 || j>=N){continue;}
                    if(array[j]=='H'){
                        array[j]='E';
                        count+=1;
                        break;
                    }
                }
            }
        }
        // 햄버거를 먹을 수 있는 최대 사람 수
        System.out.println(count);
    }
}
