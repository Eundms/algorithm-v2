import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /**
     * 의자 7, 접시 7 , 나이프 7
     * 9명중 진짜 7명 찾기
     * 7명의 합이 100이 되는 수
     */
    static int N = 9;
    static int R = 7;
    static int[] arr = new int[9];
    static boolean[] visited = new boolean[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        comb(0,0);
    }

    private static void comb(int cnt, int start) { // 9개중 7개 선택
        if (cnt == 7) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if (sum == 100) {
                for (int i = 0; i < N; i++) {
                    if (visited[i]) {
                        System.out.println(arr[i]);
                    }
                }
            }
            return;
        }
        for(int i=start;i<N;i++){
            if(visited[i])continue;
            visited[i]=true;
            comb(cnt+1,i+1);
            visited[i]=false;
        }


    }
}
