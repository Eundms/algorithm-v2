import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N; // 방의 크기
    static char[][] box;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        box = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                box[i][j] = str.charAt(j);
            }
        }
        // 가로로 누울 수 있는 자리 - 5개
        // 세로로 누울 수 있는 자리 - 4개
        int res = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (box[i][j] == '.') {
                    cnt += 1;
                }else{
                    if(cnt >= 2){
                        res += 1;
                    }
                    cnt = 0;
                }
            }
            if(cnt>=2){
                res +=1;
            }
        }
        int res2 = 0;
        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (box[i][j] == '.') {
                    cnt += 1;
                }else{
                    if(cnt >= 2){
                        res2 += 1;
                    }
                    cnt = 0;
                }
            }
            if(cnt>=2){
                res2 +=1;
            }
        }
        System.out.println(res+" "+res2);

    }


}
