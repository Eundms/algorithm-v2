import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        sushi = new int[N]; // 초밥....
        for (int i = 0; i < N; i++) { // 두번째 줄 ~ N개의 줄 : 초밥 종류 1이상 d이하의 정수
            sushi[i] = Integer.parseInt(br.readLine());
        }


        int maxSusiKinds = 0;

        int[] isExistInRange = new int[3001];
        int cntSusiKinds = 0; // 초밥 가짓수

        for (int start = 0; start < k; start++) {
            if (isExistInRange[sushi[start]] == 0) {
                cntSusiKinds += 1;
            }
            isExistInRange[sushi[start]] += 1;
        }

        for (int idx = 1; idx < N; idx++) { // 초밥 종류 1 ~ N
            // [1] 빼야 하는 값 sushi[idx-1]
            isExistInRange[sushi[idx - 1]] -= 1;
            if (isExistInRange[sushi[idx - 1]] == 0) {
                cntSusiKinds -= 1;
            }

            // [2] 더해야 하는 값 sushi[idx+k-1]
            if (isExistInRange[sushi[(idx + k - 1) % N]] == 0) {
                cntSusiKinds += 1;
            }
            isExistInRange[sushi[(idx + k - 1) % N]] += 1;

            if (isExistInRange[c] > 0) { // 쿠폰의 초밥이 포함되는 경우
                maxSusiKinds = Math.max(maxSusiKinds, cntSusiKinds);
            }else{
                maxSusiKinds = Math.max(maxSusiKinds, cntSusiKinds+1);
            }
        }

        //
        System.out.println(maxSusiKinds);

    }
}
