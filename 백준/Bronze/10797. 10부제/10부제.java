import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt =0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            String str = st.nextToken();
            if(str.charAt(str.length()-1)-'0'==N){
                cnt+=1;
            }
        }
        System.out.println(cnt);

    }
}
