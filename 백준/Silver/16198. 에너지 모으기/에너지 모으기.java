import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
	static int N;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		back(list, 0);
        System.out.print(max);

	}
	static void back(List<Integer> list, int sum) {
		if(list.size() == 2) {
			max = Math.max(max, sum);
			return;
		}
		for(int x = 1; x < list.size()-1; x++) {
			int removed = list.get(x);
			int charge = list.get(x-1) * list.get(x + 1);
			list.remove(x);
			back(list, sum + charge);
			list.add(x, removed);
		}
	}
	
}