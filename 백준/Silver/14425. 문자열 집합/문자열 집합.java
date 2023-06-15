import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        for(int i = 0; i < N ; i++){
            set.add(br.readLine());
        }
        int cnt = 0;
        for(int j=0;j < M;j++){
            if(set.contains(br.readLine())){
                cnt+=1;
            }
        }
        System.out.println(cnt);
    }


}
