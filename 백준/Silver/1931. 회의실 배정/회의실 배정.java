import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 회의의 수

        time = new int[N][2];
        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time[n][0] = start;
            time[n][1] = end;
        }
        //끝나는 시간으로 정렬, 끝나는 시간이 같다면, 시작 시간으로 정렬
        Arrays.sort(time,(x,y)->{
            if(x[1]==y[1]) return Integer.compare(x[0],y[0]);
            else return Integer.compare(x[1],y[1]);
        });
        
        int cnt = 1;
        int end = time[0][1];
        for(int n=1;n<N;n++){
            if (end<=time[n][0]){//끝나는 시각 < 시작하는 시각
                end = time[n][1];
                cnt+=1;
            }
        }
        System.out.println(cnt);

    }

}
