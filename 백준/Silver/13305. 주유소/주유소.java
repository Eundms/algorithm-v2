import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 주유소..?
    static int N; // 도시의 개수
    static int[] dist; // 인접 도로 길이
    static int[] price; // 주유소의 리터당 가격

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dist = new int[N - 1];
        price = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N - 1; n++) {
            dist[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            price[n] = Integer.parseInt(st.nextToken());
        }

        int unit = price[0]; // 기름 단위
        int res = 0; // 총 금액
        for (int i = 0; i < N - 1; i++) {
            if (unit > price[i]) { // 기름 단위가 더 크다면,
                unit = price[i];
            }
            res += unit * dist[i];
        }
        System.out.println(res);
    }
}
