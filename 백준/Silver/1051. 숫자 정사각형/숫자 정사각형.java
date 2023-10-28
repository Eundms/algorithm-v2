
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N,M; // N개의 강의, M개의 블루레이, 가능한 블루레이의 크기 중 최소
	static int[][] box;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		
		for(int i = 0; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				box[i][j] = str.charAt(j)-'0';
			}
		}
		
		int maxSize = 0;
		for(int k = 1; k < Math.min(N, M); k++) {
			for(int i = 0; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					//System.out.println(i+","+j+" | "+i+","+(j+k)+" | "+(i+k)+","+j+" | "+(i+k)+","+(j+k));
					if(i+k<N && j+k<M) {
					if(box[i][j]==box[i][j+k] && box[i][j+k]==box[i+k][j] && box[i+k][j]==box[i+k][j+k]) {
						maxSize = k;
					}
					}
				}
			}
		}
		System.out.println((maxSize+1)*(maxSize+1));
		
		
	
	}

}
