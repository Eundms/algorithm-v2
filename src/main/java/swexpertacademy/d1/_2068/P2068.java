package swexpertacademy.d1._2068;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2068 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/main/java/swexpertacademy/d1/_2068/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int maxNum = 0;
            for (int i = 0; i < 10; i++) {
                int value = Integer.parseInt(st.nextToken());
                maxNum = Math.max(maxNum, value);
            }
            System.out.println("#"+test_case+" "+maxNum);
        }
    }
}
