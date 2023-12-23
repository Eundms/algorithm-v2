import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static int N; // 관찰 횟수
    static int[]temp; // 소의 번호, 위치
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        temp = new int[11]; // 1 - 10
        Arrays.fill(temp, -1);
        
        int cnt = 0;
        StringTokenizer st;
        for(int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if(temp[cow]==-1) {
            	temp[cow] = pos;
            	continue;
            }
            if(temp[cow]!= pos) {
            	cnt +=1;
            	temp[cow] = pos;
            }
            
        }
        System.out.println(cnt);
    }
}

 