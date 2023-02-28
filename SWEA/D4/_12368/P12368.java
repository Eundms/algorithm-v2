package swexpertacademy.d3._12368;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P12368 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++) {
            st= new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B= Integer.parseInt(st.nextToken());
            // 24시간제 시계 0 시 ~ 23시
            int clock=(A+B)%24;
            System.out.println("#"+test_case+" "+clock);
        }

    }
}
