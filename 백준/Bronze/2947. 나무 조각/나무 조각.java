import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int[][] way = {{-1,0},{0,1},{1,0},{0,-1}};
	static int[] arr = new int[5];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			for(int i = 0; i < 4 ; i++) {
				if(arr[i] > arr[i+1]) {
					int tmp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = tmp;
					print(arr);
				}
			}
			if(arr[0] == 1 && arr[1] == 2 && arr[2] == 3 && arr[3] == 4 && arr[4] == 5) break;
		}
		System.out.print(sb);
	}
	static void print(int[] arr) {
		for(int i = 0; i < 5; i++) {
			sb.append(arr[i]+" ");
		}
		sb.append("\n");
	}
}