import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N,M; // 포켓몬 개수, 문제의 개수 M
	static Map<String, Integer> nameToNum;
	static Map<Integer, String> numToName;
	public static void main(String[] args) throws Exception	{
		nameToNum = new HashMap<>();
		numToName = new HashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int n = 1; n <= N ; n++) {
			String name = br.readLine();
			nameToNum.put(name, n);
			numToName.put(n, name);
		}
		
		for(int m = 1; m <= M; m++) {
			String str = br.readLine();
			if(str.charAt(0)-'0'>=0 && str.charAt(0)-'0'<=9) {
				System.out.println(numToName.get(Integer.parseInt(str)));
			}else{
				System.out.println(nameToNum.get(str));
			}
		}
	}

}
