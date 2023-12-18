import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	static boolean[][] picked;
	static int N,M,K;
	
	static int answer;
    static int[][] way = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] box;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        box = new int[N][M];
        
        answer  = Integer.MIN_VALUE;
        for(int i = 0; i < N ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0 ; j < M ; j++) {
        		box[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
    	
    	picked = new boolean[N][M];
    	pick(0, 0);
        System.out.println(answer);
    }
    
    static void pick( int pickCnt, int sum) {
    	if(pickCnt == K) {
    		answer = Math.max(answer, sum);
    		return;
    	}
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++) {
    			if(picked[i][j])continue;
    			if(isValid(i,j)) {
    				picked[i][j] = true;
        			pick( pickCnt+1, sum + box[i][j]);    				
    				picked[i][j] = false;
    			}
    		}
    	}
    }
    static boolean isValid(int i, int j) {
    	for(int w = 0; w < 4; w++) {
    		int nx = i + way[w][0];
    		int ny = j + way[w][1];
    		if(nx<0 || nx>= N || ny<0 || ny>=M)continue;
    		if(picked[nx][ny]) {
    			return false;
    		}
    	}
    	return true;
    }
}

 