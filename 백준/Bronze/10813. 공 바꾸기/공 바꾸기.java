import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N,M;
    static int[]box;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[N+1];
        for(int i = 1; i <= N; i++) {
        	box[i] = i;
        }
        for(int m = 0; m < M ; m++) {
        	st = new StringTokenizer(br.readLine());
        	int i = Integer.parseInt(st.nextToken());
        	int j = Integer.parseInt(st.nextToken());
        	int temp = box[i];
        	box[i] = box[j];
        	box[j] = temp;
        }
        for(int i = 1; i <= N; i++) {
        	System.out.print(box[i]+" ");
        }
        
    }
}

 