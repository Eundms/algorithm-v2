import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] kArray;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        // 1 - 49 중 6개의 수 = 집합 S & 번호 선택
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 집합 S의 원소 수 _ 이중 6개 선택하기
            if (k == 0) {
                break;
            }
            kArray = new int[k]; // [ 집합 S중 6개 선택 ]
            for (int i = 0; i < k; i++) {
                kArray[i] = Integer.parseInt(st.nextToken());
            }

            selected = new int[6];
            comb(0, 0);
            System.out.println();
        }

    }

    private static void comb(int cnt, int start) {
        if(cnt==6){
            for(int i=0;i<6;i++){
                System.out.print(kArray[selected[i]]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < kArray.length; i++) {
            selected[cnt] = i;
            comb(cnt+1,i+1);
        }
    }
}
