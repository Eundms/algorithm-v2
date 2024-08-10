import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main { 
	static int[] box = new int[9];
	static int allSum = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i++) {
			box[i] = Integer.parseInt(br.readLine());
			allSum += box[i];
		}
		Arrays.sort(box);
		int i = 0, j = 8;
		while(i < j) {
			int sum = allSum - box[i] - box[j];
			if(sum == 100) {
				break;
			} else if (sum > 100) {
				i++;
			}else {
				j--;
			}
		}
		for(int k = 0; k < 9; k++) {
			if (k == i || k == j)continue;
			System.out.println(box[k]);
		}
	}

}
