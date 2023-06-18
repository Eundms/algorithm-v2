import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] ppl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        ppl = new int[15][15];
        for (int i = 0; i < 15; i++) {
            ppl[i][1] = 1;
            ppl[0][i] = i;
        }
        for (int kk = 1; kk < 15; kk++) {
            for (int nn = 2; nn < 15; nn++) {
                ppl[kk][nn] = ppl[kk][nn - 1] + ppl[kk - 1][nn];
            }
        }
        
        for (int t = 0; t < test; t++) { // a층의 b호에 살려면 , a-1층의 1호 ~ b호까지 사람들의 수의 합
            int k = Integer.parseInt(br.readLine()); // k층
            int n = Integer.parseInt(br.readLine()); // n호
            System.out.println(ppl[k][n]);
        }
    }


}
