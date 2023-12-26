import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
    static int N; // 지난 날의 수
    static int X; // X일 동안 가장 많이 들어온 방문자 수
    static int[] box;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 총 N일 동안
        X = Integer.parseInt(st.nextToken()); // X일 동안 가장 많이 들어온 방문자 수
        
        box = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	box[i] = Integer.parseInt(st.nextToken());
        }
        
        int cnt = 0;
        int maxCome = Integer.MIN_VALUE; // 가장 많이 들어온 방문자 수
        int sum = 0;
        for(int i = 0 ; i < X; i++) {
        	sum += box[i];
        }
        maxCome = sum;
        cnt = 1;
        for(int i = 1; i <= N - X ; i++) {
        	sum -= box[i-1]; // 첫번째 수 제외
        	sum += box[i+X-1]; // 마지막 수 포함
        	if(sum>maxCome) {
        		maxCome = sum;
        		cnt =1;
        	}else if(sum== maxCome) {
        		cnt +=1;
        	}
        }
        
        if(maxCome == 0) {
        	System.out.println("SAD");
        	return;
        }
        
        System.out.println(maxCome);
        System.out.println(cnt);
        return;
	} 
}
