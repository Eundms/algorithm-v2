import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        hanoi(1, 2,3,  N);
        System.out.println(k);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();
    // from : A, to : C
    public static void hanoi(int from, int mid, int to,  int cnt) {
        if (cnt == 1) {
            sb.append(from + " " + to + "\n");
            k++;
            return;
        }
        // from to by cnt
        hanoi(from,  to, mid, cnt - 1);// A->B 이동 C 거침
        sb.append(from+" "+to+"\n");// A->C이동
        k++;
        hanoi(mid, from, to, cnt - 1); // B->C 이동 A거침
    }
}