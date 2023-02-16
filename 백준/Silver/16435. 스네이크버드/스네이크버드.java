import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {//스네이크버드
    static int N; // 과일의 개수
    static int L; // 스네이크 초기 길이
    static int[] height; // 과일의 높이

    public static void main(String[] args) throws IOException {
        // 과일 -> 길이+1
        // i번째 과일 높이 h_i
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 과일의 개수
        L = Integer.parseInt(st.nextToken()); // 스네이크버드의 초기 길이 정수
        // 자신의 길이보다 작거나 같은 높이의 과일을 먹을 수 있음

        st = new StringTokenizer(br.readLine());
        height = new int[N];
        for(int i=0;i<N;i++){
            height[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(height);

        int nowHeight=L;
        for(int i=0;i<N;i++){
            if(nowHeight<height[i]){
                break;
            }nowHeight+=1;
        }
        System.out.println(nowHeight);

    }
}
