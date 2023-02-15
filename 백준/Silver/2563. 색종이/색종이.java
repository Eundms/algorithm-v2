import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {// 색종이 // 푸는 중
    static int N;// 색종이 수
    static boolean[][] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new boolean[100][100];
        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int starty = Integer.parseInt(st.nextToken());
            int startx = Integer.parseInt(st.nextToken());

            // 가로, 세로 크기 100, 정사각형 모양의 흰색 도화지
            for (int i = startx; i < startx + 10; i++) {
                for (int j = starty; j < starty + 10; j++) {
                    box[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(box[i][j]==true){
                    cnt+=1;
                }
            }
        }
        System.out.println(cnt);

    }
}
