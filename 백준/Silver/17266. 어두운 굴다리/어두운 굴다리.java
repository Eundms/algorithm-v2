import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {
    
	static int N,M;
	static int[] pos;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        pos = new int[M]; // 굴다리의 길이
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ; i++) {
        	pos[i] = Integer.parseInt(st.nextToken());
        }
       
        // 길이 찾기
        int start = 1, end = N;
        int result = 0;
        while(start<=end) {
        	int mid = (start + end)/2;
        	if(isValid(mid)) {
        		end = mid -1;
        		result = mid;
        	}else {
        		start = mid + 1;
        	}
        }
        System.out.println(result);
        
    }

    static boolean isValid(int len) {
    	int prev = 0;
    	for(int i = 0; i < pos.length; i++) {
    		if(pos[i]-len>prev) { 
    			return false;
    		}
    		prev = pos[i] + len;
    	}
    	return N-prev<=0;
    }
}