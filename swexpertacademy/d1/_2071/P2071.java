package swexpertacademy.d1._2071;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P2071 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/main/java/swexpertacademy/d1/_2071/input.txt")); // input.txt.txt
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Integer.parseInt(st.nextToken());
            }
            System.out.println("#" + test_case + " " + Math.round(sum / 10));
        }
    }
}
